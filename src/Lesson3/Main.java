package Lesson3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[5];
        array[0] = "123";
        array[1] = "sss";
        array[2] = "eee";
        array[3] = "ooo";
        array[4] = "555";
        Swap<String> massive = new Swap<>(array);
        massive.swapValue(0, 1);
        System.out.println(massive.getElement(0) + " " + massive.getElement(1));

        Apple apple = new Apple(1f);
        Apple apple1 = new Apple(1.7f);
        Apple apple2 = new Apple(22.2f);
        Orange orange = new Orange(2.7f);
        Orange orange1 = new Orange(3.3f);
        Orange orange2 = new Orange(6.7f);
        Orange orange3 = new Orange(50f);
        Orange orange4 = new Orange(35f);
        Orange orange5 = new Orange(23.4f);
        ArrayList<Apple> arrayApples = new ArrayList<>();
        arrayApples.add(apple);
        arrayApples.add(apple1);
        arrayApples.add(apple2);
        ArrayList<Orange> arrayOrange = new ArrayList<>();
        arrayOrange.add(orange);
        arrayOrange.add(orange1);
        arrayOrange.add(orange2);
        ArrayList<Orange> arrayOrange2 = new ArrayList<>();
        arrayOrange2.add(orange3);
        arrayOrange2.add(orange4);
        arrayOrange2.add(orange5);
        Box<Apple> appleBox = new Box<>(arrayApples);
        Box<Orange> orangeBox = new Box<>(arrayOrange);
        Box<Orange> orangeBox1 = new Box<>(arrayOrange2);
        System.out.println(appleBox.getBoxWeight());
        System.out.println(orangeBox.getBoxWeight());
        System.out.println(appleBox.compare(orangeBox));
        System.out.println(orangeBox.compare(appleBox));
        orangeBox.moveFruit(orangeBox1);
        System.out.println(orangeBox.getSomeFruit().isEmpty());

    }
}
