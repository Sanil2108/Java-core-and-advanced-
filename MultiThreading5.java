/**
 * Created by Admin on 14-04-2017.
 */
public class MultiThreading5{

    public static void main(String[] args){
        MyThread thread1=new MyThread();
        MyThread thread2=new MyThread();
        MyThread thread3=new MyThread();

        System.out.println("thread1 is alive "+thread1.t.isAlive());
        System.out.println("thread2 is alive "+thread2.t.isAlive());
        System.out.println("thread3 is alive "+thread3.t.isAlive());

        try {
            thread1.t.join();
            thread2.t.join();
            thread3.t.join();
        }catch (Exception e){

        }


        System.out.println("thread1 is alive "+thread1.t.isAlive());
        System.out.println("thread2 is alive "+thread2.t.isAlive());
        System.out.println("thread3 is alive "+thread3.t.isAlive());

    }

    public static class MyThread implements Runnable{
        Thread t;

        MyThread(){
            t=new Thread(this);
            t.start();
        }

        @Override
        public void run() {
            for(int i=0;i<100;i++){
                try{
                    Thread.sleep(10);
                }catch (Exception e){

                }
            }
        }
    }
}
