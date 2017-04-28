/**
 * Created by Admin on 14-04-2017.
 */
public class MultiThreading2 {

    static MyThread t;

    public static class MyThread implements Runnable{
        @Override
        public void run() {
            System.out.println("Thread up and running");
        }
    }

    public static void main(String[] args){
        t=new MyThread();
        Thread actualThread=new Thread(t, "Thread1");
        actualThread.start();
    }

}
