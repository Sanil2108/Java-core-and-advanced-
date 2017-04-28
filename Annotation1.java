import com.sun.istack.internal.NotNull;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Annotation1{

    @Retention(RetentionPolicy.RUNTIME)
    @interface Info{
        String name() default "N/A";
        int age();
    }

    @Info(name="Sanil Khurana", age=18)
    Annotation1(@NotNull String a){

    }

    @Info(name="Sanil2", age = 21)
    public void getAnnotationsUsingReflections(){
        try{
            Class c=this.getClass();
            Info info=c.getMethod("getAnnotationsUsingReflections").getAnnotation(Info.class);
            System.out.print(info);
        }catch (Exception e){

        }
    }

    public static void main(String[] args){
        Annotation1 annotation1 = new Annotation1(null);
        annotation1.getAnnotationsUsingReflections();
    }

}