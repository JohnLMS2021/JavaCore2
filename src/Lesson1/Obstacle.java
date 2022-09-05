package Lesson1;

public class Obstacle {
    private String nameObs;
    private int complexity;

    public Obstacle(String nameObs, int complexity) {
        this.nameObs = nameObs;
        this.complexity = complexity;
    }

    public String getNameObs() {
        return nameObs;
    }

    public int getComplexity() {
        return complexity;
    }
}
