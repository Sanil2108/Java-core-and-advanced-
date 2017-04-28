import java.net.InetAddress;

/**
 * Created by Admin on 27-04-2017.
 */
public class Networking8 {

    public static void main(String[] args) throws Exception{
        InetAddress a1=InetAddress.getLocalHost();
        byte[] temp={127, 0, 0, 1};
        InetAddress a2=InetAddress.getByAddress(temp);
        InetAddress a3=InetAddress.getByName("google.com");
        InetAddress[] a4=InetAddress.getAllByName("nba.com");

        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);

        for(int i=0;i<a4.length;i++){
            System.out.println(a4[i]);
        }
    }

}