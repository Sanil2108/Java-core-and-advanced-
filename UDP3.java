//UDP port scanner
//It needs admin privilages on a UNIX based OS
import java.net.*;
class UDP3{
    public static void main(String[] args){
        for(int i=0;i<=65535;i++){
            try{
                DatagramSocket s=new DatagramSocket(i);
                s.close();
            }catch(Exception e){
                System.out.println("There is a server listening on port numebr - "+i);
            }
        }
    }
}