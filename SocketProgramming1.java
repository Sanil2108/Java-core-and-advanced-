import java.net.*;

public class SocketProgramming1{

    public static void main(String[] args) throws Exception{
        InetAddress localHost=InetAddress.getLocalHost();
        System.out.println("Local Host\n"+localHost.getHostName()+"\n"+localHost.getHostAddress());

        for(int i=0;i<args.length;i++){
            InetAddress[] all=InetAddress.getAllByName(args[i]);
            System.out.println();
            for(int j=0;j<all.length;j++){
                System.out.println("Address : "+j+"\n"+all[j].getHostName()+"\n"+all[j].getHostAddress());
            }
        }
    }
}