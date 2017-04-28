import java.net.InetAddress;

/**
 * Created by Admin on 22-04-2017.
 */
public class Networking1 {
    public static void main(String[] args) throws Exception{
        InetAddress add1=InetAddress.getLocalHost();
        System.out.println(add1);
        InetAddress add2=InetAddress.getByName("google.com");
        System.out.println(add2);
        byte[] temp={127, 0, 0, 1};
        InetAddress add3=InetAddress.getByAddress(temp);
        System.out.println(add3);
    }
}
