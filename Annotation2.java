import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

/**
 * Created by Admin on 15-04-2017.
 */
public class Annotation2 {

    @Retention(RetentionPolicy.RUNTIME)
    @interface Anno1{}


    @Anno1
    public void method1(){

    }

    public static void main(String[] args){
        Annotation2 annotation2=new Annotation2();
        Class c = annotation2.getClass();
        try{
            Method m =c.getMethod("method1");
            System.out.print(String.format("Anno1 is %spresent", m.isAnnotationPresent(Anno1.class)?"":"not "));
        }catch (Exception e){

        }
    }
}
