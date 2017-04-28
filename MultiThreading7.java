/**
 * Created by Admin on 15-04-2017.
 */
public class MultiThreading7 {
    //An example of race condition in which all the threads are trying to complete their output
    //since none of them waits for any other, they all race to the end and the outputs gets mixed
    //up. using 'synchronized' in Callme.callMe can stop this problem

    static class Callme{
        synchronized void callMe(String msg){
            char[] chars = msg.toCharArray();
            for (char c : chars) {
                System.out.print(c);
            }
        }
    }

    static class Caller implements Runnable{
        String msg;
        Callme callme;
        Thread t;

        Caller(Callme callme, String msg){
            this.msg=msg;
            t=new Thread(this);
            this.callme=callme;
        }

        @Override
        public void run() {
            callme.callMe(msg);
        }
    }

    public static void main(String[] args){
        Callme callme=new Callme();
        Caller caller1=new Caller(callme, "ABCD");
        Caller caller2=new Caller(callme, "EFGH");
        Caller caller3=new Caller(callme, "IJKL");

        caller1.t.start();
        caller2.t.start();
        caller3.t.start();
    }
}
