import java.io.*;
import java.lang.*;

public class MoreIO1{

    public static void main(String[] args) throws IOException{
        int a=33;
        OutputStream stream=System.out;
        while(a<256){
            stream.write(a);
            a++;
        }
    }

}