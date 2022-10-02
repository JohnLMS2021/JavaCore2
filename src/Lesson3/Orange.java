package Lesson3;

public class Orange extends Fruit{
    float weight;

    public Orange(float weight) {
        this.weight = weight;
    }

    @Override
    public float getWeight() {
        return weight;
    }
}
