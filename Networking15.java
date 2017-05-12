import java.net.*;
import java.io.*;
import java.*;

class Networking15{

    public static void main(String[] args){
        try{
            URL u=new URL(args[0]);
            Object o=u.getContent();
            System.out.println(o.getClass().getName());
        }catch(ArrayIndexOutOfBoundsException e){
            throw new RuntimeException("All you had to do was follow the damn format, CJ");
        }catch(Exception e){

        }
    }

}