import java.awt.*;

/**
 * Created by Admin on 18-04-2017.
 */
public class Generics6 {
    static interface Car{
        void start();
        void stop();
    }

    static abstract class Automobile{
        Color color;
        String plateNo;
    }

    //Really running out of names
    static class SuperCar extends Automobile implements Car{

        @Override
        public void start() {

        }

        @Override
        public void stop() {

        }
    }

    static class TheBatmobile<T extends Automobile & Car>{

    }

    public static void main(String[] args){
        TheBatmobile<SuperCar> batmobile=new TheBatmobile<>();
    }
}
