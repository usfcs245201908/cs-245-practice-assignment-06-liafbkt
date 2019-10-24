import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayQueue<T> implements Queue<T> {
    private T[] a = (T[]) new Object[DEFAULT_CAPACITY];
    private int start = 0;
    private int end = 0;

    private static final int DEFAULT_CAPACITY = 10;
    /*public ArrayQueue(){
        this.a = (T[]) new Object[DEFAULT_CAPACITY];
        this.start = 0;
        this.end = 0;
    }*/
    @Override
    public T dequeue() throws EmptyStackException{
        if( empty()){
            throw new EmptyStackException();
        }
        T item = a[start];
        start = (start+1)%a.length;
        return item;
    }

    @Override
    public void enqueue(T item) {
        if( start == (end+1)%a.length){
            grow_array();
        }
        a[end++] = item;
        end = end%a.length;
    }

    @Override
    public boolean empty() {
        return start == end;
    }

    public void grow_array(){
        T[] temp = a;
        a = (T[]) new Object[a.length * 2];
        System.arraycopy(temp,start,a,0,temp.length - start);
        System.arraycopy(temp,0,a,temp.length - start, end);
        start = 0;
        end = temp.length - 1;
    }
}
