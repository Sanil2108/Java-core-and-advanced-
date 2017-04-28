public class MultiThreading6 {

    public static  class MyThread implements Runnable{
        Thread t;
        long click=0;

        private volatile boolean running=true;

        @Override
        public void run() {
            while(running){
                click++;
            }
        }

        MyThread(){
            t=new Thread(this);
        }
    }

    public static void main(String[] args){
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();

        t1.t.setPriority(Thread.NORM_PRIORITY);
        t2.t.setPriority(Thread.NORM_PRIORITY);

        t1.t.start();
        t2.t.start();

        try{
            Thread.sleep(1000);
        }catch (Exception e){

        }

        t1.running=false;
        t2.running=false;

        try {
            t1.t.join();
            t2.t.join();
        }catch (Exception e){

        }

        System.out.println(String.format("t1 - %d\nt2 - %d", t1.click, t2.click));

    }
}