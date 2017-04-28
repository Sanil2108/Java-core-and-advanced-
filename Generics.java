import com.sun.istack.internal.NotNull;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by Admin on 12-04-2017.
 */
public class Generics<T> {
    private final int DEFAULT_SIZE=10;
    private final int INCREASE_IN_SIZE=5;
    Object[] ts;
    int size=DEFAULT_SIZE;
    int currentSize;

    public Generics(){
        ts=new Object[DEFAULT_SIZE];
        currentSize=0;
    }

    public void add(@NotNull T t){
        if(currentSize<size){
            ts[currentSize++] = t;
        }else{
            Object[] ts_new=new Object[size+INCREASE_IN_SIZE];
            for(int i=0;i<size;i++){
                ts_new[i]=ts[i];
            }
            ts=ts_new;
            size+=INCREASE_IN_SIZE;
            ts[currentSize++] = t;
        }

    }

    public void print(){
        for(int i=0;i<currentSize;i++){
            System.out.println(ts[i].toString());
        }
    }

    public static void main(String[] args){
        Generics<Integer> generics=new Generics<>();
        for(int i=0;i<100;i++){
            generics.add(new Integer(i));
        }
        generics.print();
    }

}
