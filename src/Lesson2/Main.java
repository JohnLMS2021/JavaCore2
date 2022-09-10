package Lesson2;

public class Main {
    public static void main(String[] args) throws MyArraySizeException, MyArrayDataException {
        String[][] successfulArray = {{"1", "2", "3", "4"}, {"11", "12", "13", "14"}, {"21", "22", "23", "24"}, {"31", "32", "33", "34"}};
        String[][] sizeExceptionArray = {{"21", "22", "23"}, {"21", "22", "23", "24"}, {"21", "22", "23", "24"}, {"31", "32", "33", "34"}};
        String[][] dataExceptionArray = {{"1", "2", "3", "4"}, {"11", "12", "aa", "14"}, {"21", "22", "23", "24"}, {"31", "32", "33", "34"}};

        try {
            System.out.println("Сумма массива: " + sumUp(successfulArray));
        } catch (MyArraySizeException | MyArrayDataException s){
            System.out.println(s.getMessage());
        }

        try {
            System.out.println("Сумма массива: " + sumUp(sizeExceptionArray));
        } catch (MyArraySizeException | MyArrayDataException s){
            System.out.println(s.getMessage());
        }
        try {
            System.out.println("Сумма массива: " + sumUp(dataExceptionArray));
        } catch (MyArraySizeException | MyArrayDataException s){
            System.out.println(s.getMessage());
        }


    }
    public static void checkIndexOutOfBounds (String[][] array) throws MyArraySizeException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
    }

    public static int sumUp (String[][] array) throws MyArraySizeException, MyArrayDataException {
        checkIndexOutOfBounds(array);
        int result = 0;
        int i = 0;
        int j = 0;
        try {
            for (i = 0; i < array.length; i++) {
                for (j = 0; j < array[i].length; j++) {
                    result = result + Integer.parseInt(array[i][j]);
                }
            }
        } catch (NumberFormatException s) {
            throw new MyArrayDataException("Ошибка в ячейке (" + i + ") (" + j +")");
        }
        return result;


    }



}
