package Lesson3;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    ArrayList<T> someFruit;

    public Box(ArrayList<T> someFruit) {
        this.someFruit = someFruit;
    }


    public float getBoxWeight() {
        float result = 0.0f;
        for (Fruit fruit: getSomeFruit()) {
            float value = fruit.getWeight();
            result = result + value;
        }
        return result;
    }


    public boolean compare(Box<?> box) {
        if (getBoxWeight() == box.getBoxWeight()) {
            return true;
        } else return false;
    }

    public void moveFruit (Box<T> box) {
        box.addSomeFruit(this.someFruit);
        someFruit.clear();
    }

    private void addSomeFruit(ArrayList<T> someFruit) {
    }

    public ArrayList<T> getSomeFruit() {
        return someFruit;
    }

}
