import java.util.Calendar;

/**
 * Created by Admin on 12-04-2017.
 */
public class Generics3 {
    public static <T> void print(T t){
        System.out.println(((Object)t).toString());
    }

    public static void main(String[] args){
        print("abc");
        print(2);
        print(new Runnable() {
            @Override
            public void run() {

            }
        });
        print(new Calendar() {
            @Override
            protected void computeTime() {

            }

            @Override
            protected void computeFields() {

            }

            @Override
            public void add(int field, int amount) {

            }

            @Override
            public void roll(int field, boolean up) {

            }

            @Override
            public int getMinimum(int field) {
                return 0;
            }

            @Override
            public int getMaximum(int field) {
                return 0;
            }

            @Override
            public int getGreatestMinimum(int field) {
                return 0;
            }

            @Override
            public int getLeastMaximum(int field) {
                return 0;
            }
        });
        print(new Integer(1));
    }
}
