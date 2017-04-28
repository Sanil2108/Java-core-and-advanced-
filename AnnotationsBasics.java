/**
 * Created by Admin on 12-04-2017.
 */
public class AnnotationsBasics {

    @Deprecated
    public static void deprecatedMethod(){
        System.out.println("Deprecated hai yeh");
    }

    public void overridenMethod(){
        System.out.println("Yeh method overriden hai");
    }

    @SuppressWarnings({"deprecation", "unchecked"})
    public static void suppressedWarnings(){
        deprecatedMethod();
        System.out.println("IDE warnings nhi dikhayega");
    }

    public @interface YeBikGayiHaiGormint{
        int value();
    }

    @YeBikGayiHaiGormint(1)
    public static void main(String[] args){
        deprecatedMethod();
        new AnnotationsBasics().new NestedClass().overridenMethod();
    }

    class NestedClass extends  AnnotationsBasics{
        @Override
        public void overridenMethod(){
            System.out.println("Yeh method overriden hai");
        }
    }
}
