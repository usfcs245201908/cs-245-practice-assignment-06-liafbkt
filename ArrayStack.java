
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private int top = -1;
    private T[] a = (T[]) new Object[DEFAULT_CAPACITY];


    /*public ArrayStack(){
        this.a = (T[]) new Object[DEFAULT_CAPACITY];
        this.top = -1;
    }*/
    @Override
    public void push(T item) {
        if(top + 1 == a.length){
            grow_array();
        }
        a[++top] = item;
    }

    @Override
    public T pop()throws EmptyStackException{
        if(empty()){
            throw new EmptyStackException();
        }
        return a[top--];

    }

    @Override
    public T peek() throws Exception {
        if(empty()){
            throw new Exception();
        }
        return a[top];
    }

    @Override
    public boolean empty() {
        return top == -1;
    }

    private void grow_array(){
        T[] temp = a;
        a= (T[]) new Object[a.length*2];
        a = Arrays.copyOfRange(temp, 0 , top);
    }
}
