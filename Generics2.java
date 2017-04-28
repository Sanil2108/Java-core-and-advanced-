/**
 * Created by Admin on 12-04-2017.
 */
public class Generics2 {
    private static class OrderedPair<K, V>{
        K k;
        V v;

        OrderedPair(K k ,V v){
            this.k=k;
            this.v=v;
        }

        public K getKey(){
            return k;
        }

        public V getV(){
            return v;
        }
    }

    public static void main(String[ ] args){
        OrderedPair<Integer, String> pair1=new OrderedPair<>(1, "abcd");
        OrderedPair<Integer, String> pair2=new OrderedPair<>(new Integer(3), "efg?");
        OrderedPair pair3=new OrderedPair("abcd", "efg?");
        System.out.println(pair3.getKey());
    }
}
