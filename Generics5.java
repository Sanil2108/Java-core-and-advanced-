/**
 * Created by Admin on 18-04-2017.
 */
public class Generics5 {
    public static class Info<T, V>{
        T t;
        V v;

        Info(T t, V v){
            this.t=t;
            this.v=v;
        }

        void printType(){
            System.out.println(t.getClass().getName());
            System.out.println(v.getClass().getName());
        }
    }

    public static void main(String[] args){
        Info<Integer, String> info=new Info<>(3, "12ads");
        info.printType();
    }
}
