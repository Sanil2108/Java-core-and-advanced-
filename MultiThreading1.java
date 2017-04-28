/**
 * Created by Admin on 14-04-2017.
 */
public class MultiThreading1 {

    public static void main(String[] args){
        Thread t=Thread.currentThread();
        System.out.println(t);
        t.setName("Main thread hai yeh");
        System.out.println(t);
        try {
            for(int i=1;i<10;i++) {
                System.out.println(i);
                t.sleep(1000);
            }
        }catch (Exception e){

        }
    }

}
