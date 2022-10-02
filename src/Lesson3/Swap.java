package Lesson3;

public class Swap<T> {
    private T[] array;

    public Swap(T[] array) {
        this.array = array;
    }

    public void swapValue(int j, int k) {
        T value1 = array[j];
        array[j] = array[k];
        array[k] = value1;


    }
    public T getElement (int i) {
        return array[i];
    }

}
