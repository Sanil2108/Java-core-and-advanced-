import java.net.*;
import java.util.*;

class CustomNetworking4{
    public static void main(String[] args) throws Exception{
        Enumeration<NetworkInterface> networkInterfaces= NetworkInterface.getNetworkInterfaces();
        
        for(NetworkInterface net : Collections.list(networkInterfaces)){
            System.out.println("Display name :"+net.getDisplayName());
            System.out.println("Name :"+net.getName());
            displaySubInterfaces(net);
        }
    }

    public static void displaySubInterfaces(NetworkInterface net){
        Enumeration<NetworkInterface> nets=net.getSubInterfaces();

        for(NetworkInterface sub : Collections.list(nets)){
            System.out.println("\tSub interface display name :"+sub.getDisplayName());
            System.out.println("\tSub interface Name :"+sub.getName());
        }
    }
}