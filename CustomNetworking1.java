import java.net.*;
import java.io.*;
class CustomNetworking1{
    static final String ADDRESS = "http://localhost:9999/Test1/Servlet1";
    static final String MESSAGE = "Hello world, from User";

    public static void main(String[] args) throws Exception{
        URL url=new URL(ADDRESS);
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", 
           "application/x-www-form-urlencoded");
			
        connection.setRequestProperty("Content-Length", "" + 
                Integer.toString(MESSAGE.getBytes().length));
        connection.setRequestProperty("Content-Language", "en-US");  
                
        connection.setUseCaches (false);
        connection.setDoInput(true);
        connection.setDoOutput(true);

        DataOutputStream dos=new DataOutputStream(connection.getOutputStream());
        dos.writeBytes(MESSAGE);
        dos.flush();
        dos.close();

        InputStream in=connection.getInputStream();
        int c;
        while((c=in.read()) != -1){
            System.out.print((char)c);
        }

    }

}