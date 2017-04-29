import java.lang.*;
class StringBuilder1{
    public static void main(String[] args){
        StringBuilder stringBuilder=new StringBuilder("abcd");
        stringBuilder.insert(1, "ancd");
        System.out.println(stringBuilder);
    }
}