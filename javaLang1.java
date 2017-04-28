/**
 * Created by Admin on 22-04-2017.
 */
public class javaLang1 {
    public static void main(String[] args){
        Double d1=new Double(1.0/0.0);
        Double d2=new Double(0.0/0.0);
        System.out.println("d1 - "+d1+"\nd2 - "+d2);
        System.out.println(d1 + ": " + d1.isInfinite() + ", " + d1.isNaN());
        System.out.println(d2 + ": " + d2.isInfinite() + ", " + d2.isNaN());
    }
}