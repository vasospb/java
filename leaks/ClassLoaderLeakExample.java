import java.io.IOException;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public final class ClassLoaderLeakExample {
    static volatile boolean running = true; // used to stop LongRunningThread

    public static void main(String[] args) throws Exception {
        Thread thread = new LongRunningThread();
        try {
            thread.start();
            System.out.println("Running, press any key to stop.");
            System.in.read();
        } finally {
            running = false;
            thread.join();
        }
    }

    static final class LongRunningThread extends Thread {
        @Override public void run() {
            while(running) {
                try { loadAndDiscard(); } catch (Throwable ex) { ex.printStackTrace(); }
                try { Thread.sleep(500); } // 0.5 seconds. Чем меньшее значение, тем быстрее получим java.lang.OutOfMemoryError
                catch (InterruptedException ex) {
                    System.out.println("Caught InterruptedException, shutting down.");
                    running = false;
                }
            }
        }
    }

    static void loadAndDiscard() throws Exception {
        ClassLoader childClassLoader = new ChildOnlyClassLoader();
        // use created ChildOnlyClassLoader to load class LoadedInChildClassLoader
        Class<?> childClass =
                Class.forName(LoadedInChildClassLoader.class.getName(), true, childClassLoader);
        // create object of LoadedInChildClassLoader
        childClass.newInstance();
    }

    static final class ChildOnlyClassLoader extends ClassLoader {
        ChildOnlyClassLoader() { super(ClassLoaderLeakExample.class.getClassLoader()); }

        @Override protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            if (!LoadedInChildClassLoader.class.getName().equals(name)) {
                return super.loadClass(name, resolve);
            }
            try {
                Path path = Paths.get(LoadedInChildClassLoader.class.getName() + ".class");
                byte[] classBytes = Files.readAllBytes(path);
                Class<?> c = defineClass(name, classBytes, 0, classBytes.length);

                if (resolve) {
                    resolveClass(c);
                }
                return c;
            } catch (IOException ex) {
                throw new ClassNotFoundException("Could not load " + name, ex);
            }
        }
    }

    // name in jmap -histo - ClassLoaderLeakExample$LoadedInChildClassLoader
    public static final class LoadedInChildClassLoader {
        static final byte[] moreBytesToLeak = new byte[1024 * 1024 * 10];
        //private static final ThreadLocal<LoadedInChildClassLoader> threadLocal = new ThreadLocal<>();

        public LoadedInChildClassLoader() {
            //threadLocal.set(this); // ThreadLocal keeps a reference to the object
        }
    }
}
