import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by Admin on 22-04-2017.
 */
public class test2 {
    public static void main(String[] args) throws Exception{
        String command = "cmd /c start cmd.exe";
        Runtime.getRuntime().exec(command);
    }
}
