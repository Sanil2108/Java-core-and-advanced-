import java.util.ArrayList;

/**
 * Created by Admin on 14-04-2017.
 */
public class Exception2 {
    public static void throwExceptions() throws ClassNotFoundException{
        try{
            throw new NullPointerException("ABC");
//            new Exception2.throwsNestedException(){
//                @Override
//                public void throwsNestedException() {
//                    throw new NullPointerException("ABC");
//                }
//            };
        }catch (NullPointerException e){
            if(true) {
                throw new ClassNotFoundException();
            }
            System.out.println(e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try {
            throwExceptions();
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();

        }

    }

    public static interface throwsNestedException{
        public void throwsNestedException();
    }
}
