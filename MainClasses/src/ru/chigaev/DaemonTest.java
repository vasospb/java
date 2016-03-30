package ru.chigaev;

/**
 * Created by vchigaev on 3/30/2016.
 */
public class DaemonTest {

    public static void main(String[] args) {
        new WorkerThread().start() ;
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {}
        System.out.println("Main Thread ending") ;
    }

}
class WorkerThread extends Thread {

    /**
     * Попробуйте установить флаг daemon в true или false и посмотрите,
     * как будет меняться поведение.
     */
    public WorkerThread() {
      //  setDaemon(true) ;
    }

    public void run() {
        int count=0 ;
        while (true) {
            System.out.println("Hello from Worker "+count++) ;
            try {
                sleep(5000);
            } catch (InterruptedException e) {}
        }
    }
}
