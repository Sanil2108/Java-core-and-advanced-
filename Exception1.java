/**
 * Created by Admin on 14-04-2017.
 */
public class Exception1 {
    public static void main(String[] args) throws  Exception{
        int a=0;
        try{
//            System.out.println(4/a);
            Exception e2 =new Exception("a");
            throw e2;
        }catch (NullPointerException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
