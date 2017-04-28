import java.io.File;

/**
 * Created by Admin on 22-04-2017.
 */
public class javaLang4 {
    public static void main(String[] args){
        ProcessBuilder builder=new ProcessBuilder("explorer.exe");
        try{
            builder.start();
        }catch (Exception e){

        }
    }
}