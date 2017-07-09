import java.net.*;

//Works alongside UDP2.java which acts as a server
class UDP1{
    public static void main(String[] args) throws Exception{
        DatagramSocket socket=new DatagramSocket();
        System.out.println("datagramsocket is connected to port no" + socket.getPort());
        socket.setSoTimeout(30000);
        InetAddress host=InetAddress.getLocalHost();
        
        //the packet to be sent
        byte[] data="Hello world".getBytes();
        DatagramPacket request=new DatagramPacket(data, data.length, host, 4242);

        try{
            socket.send(request);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(socket!=null){
                socket.close();
            }
        }
    }
}