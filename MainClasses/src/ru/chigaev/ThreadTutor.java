package ru.chigaev;

/**
 * Created by vchigaev on 3/30/2016.
 */

public class ThreadTutor {
    static StringBuffer buf = new StringBuffer();
    static void log(String s) {
        buf.append(s+"\n");
    }

    static class TestThread implements Runnable {
        String threadName;

        public TestThread(String threadName) {
            this.threadName = threadName;
        }

        @Override
        public void run() {
            for (int i=0;i<10;i++) {
               // System.out.println(threadName +" via system out:"+i);
               log(threadName+":"+i);
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 =new Thread(new TestThread("t1"));
        Thread t2 = new Thread(new TestThread("t2"));
        System.out.println("Starting threads");
        t1.start();
        t2.start();


    /*  try {
       //   t1.join();
          System.out.println("---------------------");
        //  t2.join();
      } catch (InterruptedException e) {
           e.printStackTrace();
       }*/

        System.out.println("Finished");
        System.out.println("buf "+buf);
    }

}
