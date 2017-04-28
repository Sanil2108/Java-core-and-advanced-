import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 18-04-2017.
 */
public class MultiThreading_IO {
    public static double factorial(long n){
        if(n==0 || n==1){
            return 1;
        }
        double total = 1;
        for(long i=n;i>=2;i--){
            total*=i;
        }
        return total;
    }

    public static boolean isPrime(long n){
        long i=1;
        for(;i<n/2;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter 1 to calculate if a number is prime, enter 2 to calculate factorial of a number, followed by the number, 3 to exit\n");
        int temp;
        do{
            temp=Integer.parseInt(br.readLine());
            long n=Integer.parseInt(br.readLine());
            switch (temp){
                case 1:
                    Thread thread=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            boolean isPrime=isPrime(n);
                            if(isPrime){
                                System.out.println(n+" is a prime number");
                            }else{
                                System.out.println(n+" is not a prime number");
                            }
                        }
                    });
                    thread.start();
                    break;
                case 2:
                    Thread thread1=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            System.out.println("Factorial of "+n+" is "+factorial(n));
                        }
                    });
                    thread1.start();
                    break;
            }
            System.out.println("Your result is being prepared, enter the next operation");
        }while (temp!=3);
    }
}