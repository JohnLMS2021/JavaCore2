package Lesson3;

public class Apple extends Fruit {
   float weight;

    public Apple(float weight) {
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
