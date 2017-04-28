import java.io.IOException;

/**
 * Created by Admin on 22-04-2017.
 */
public class javaLang2 {
    public static void main(String[] args) throws IOException{
        Runtime currentRuntime=Runtime.getRuntime();
        System.out.println("Total memory - "+currentRuntime.totalMemory());
        long mem1=currentRuntime.freeMemory();
        System.out.println("Current free memory - "+mem1);
        int[] temp1=new int[10000];
        for(int i=0;i<10000;i++){
            temp1[i] = i;
        }
        long mem2=currentRuntime.freeMemory();
        System.out.println("Current free memory - "+mem2);
        System.out.println("Memory used by allocation - "+(mem2-mem1));
        currentRuntime.gc();
        System.out.println("Free memory after garbage collection -"+currentRuntime.freeMemory());
    }

}
