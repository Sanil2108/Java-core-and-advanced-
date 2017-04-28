/**
 * Created by Admin on 14-04-2017.
 */
public class MultiThreading3 {

    public static void main(String[] args){
        Thread.currentThread().setName("MainThread");
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    System.out.println(i+" from "+this.getClass().getName());
                    try{
                        Thread.sleep(10);
                    }catch (Exception e){

                    }
                }
            }
        }, "Thread1");
        t1.start();
        for(int i=0;i<5;i++){
            System.out.println(i+" from "+Thread.currentThread().getName());
            try{
                Thread.sleep(10);
            }catch (Exception e){

            }
        }
    }



}
