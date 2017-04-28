/**
 * Created by Admin on 14-04-2017.
 */
public class MultiThreading4 {
    static int threadsRunning=0;

    public static void startKarThread(){
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                MultiThreading4.runWaalaMethod();
            }
        });
        t.start();
    }

    public static void runWaalaMethod(){
        for(int i=0;i>-1;i++){
            try{
                Thread.sleep(10);
            }catch (Exception e){

            }
        }
    }

    public static void main(String[] args){
        for(int i=0;i<3000;i++){
            threadsRunning++;
            startKarThread();

            System.out.println("Threads running - "+threadsRunning);
        }

        try{
            Thread.sleep(100000);
        }catch (Exception e){

        }
    }
}
