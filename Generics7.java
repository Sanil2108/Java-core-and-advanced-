/**
 * Created by Admin on 18-04-2017.
 */
public class Generics7 {

    public static class Stats<T extends Number>{
        T[] t;

        Stats(T[] t){
            this.t=t;
        }

        public double getAvg(){
            double avg=0;
            for(int i=0;i<t.length;i++){
                avg+=t[i].doubleValue();
            }
            return avg/t.length;
        }

        public boolean isAvgSame(Stats<?> t){
            if(this.getAvg() == t.getAvg()){
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args){
        Integer[] arr={1, 4, 2, 5, 6};
        Stats<Integer> stats=new Stats<>(arr);
        Double[] arr2={1.0, 23.0, 5.1};
        Stats<Double> stats2=new Stats<>(arr2);
        System.out.println(stats.getAvg());
        System.out.println(stats.isAvgSame(stats2));
    }

}
