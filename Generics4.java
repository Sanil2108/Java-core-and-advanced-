import java.util.Comparator;
import java.util.Objects;

/**
 * Created by Admin on 14-04-2017.
 */
public class Generics4 {
    //Using bounded generics by 'extends'
    public static class NaturalNumber<U extends Number>{
        U number;
        NaturalNumber(U u){
            number=u;
        }
        //Now, I can use methods of Number class
        public boolean isEven(){
            return number.intValue()%2==0;
        }
    }

    public static void main(String[] args){
        NaturalNumber<Float> naturalNumber=new NaturalNumber<>(3f);
        System.out.println(naturalNumber.isEven());
    }
}
