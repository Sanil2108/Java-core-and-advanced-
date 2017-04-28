/**
 * Created by Admin on 22-04-2017.
 */
public class test1 {
    static class A{

        int a;

        private A(){
            a=1;
        }
    }

    static class B extends A{
        B(){
        }

        void print(){
            System.out.println(a);
        }
    }

    public static void main(String[] a){
        B b=new B();
        b.print();
    }
}
