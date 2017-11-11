import java.net.*;
import java.util.*;

class CustomNetworking5{
    public static void main(String[] args) throws Exception{
        Enumeration<NetworkInterface> nets=NetworkInterface.getNetworkInterfaces();
        for(NetworkInterface n : Collections.list(nets)){
            displayNetworkInterfaceInfo(n);
        }
    }

    public static void displayNetworkInterfaceInfo(NetworkInterface n){
        System.out.println("Display name :"+n.getDisplayName());
        System.out.println("Name :"+n.getName());

        Enumeration<InetAddress> inetAddresses=n.getInetAddresses();
        for(InetAddress i:Collections.list(inetAddresses)){
            System.out.println(i);
        }
    }
}