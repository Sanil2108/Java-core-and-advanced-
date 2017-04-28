/**
 * Created by Admin on 18-04-2017.
 */
public class Generics8 {

    public static <T, V extends T> boolean isIn(T[] arr, V data){
        for(int i=0;i<arr.length;i++){
            if(arr[i].equals(data)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args){
        Number[] arr={
                1, 4.2, 5
        };
        Integer a=4;
        System.out.println(isIn(arr, a));
    }

}
