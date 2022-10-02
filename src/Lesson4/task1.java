package Lesson4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class task1 {
    public static void main(String[] args) {
        String[] name = new String[8];
        name[0] = "Вася";
        name[1] = "Петя";
        name[2] = "Катя";
        name[3] = "Коля";
        name[4] = "Вася";
        name[5] = "Оля";
        name[6] = "Катя";
        name[7] = "Федя";

        HashSet<String> uniqueName = new HashSet<>(Arrays.asList(name));
        System.out.println(uniqueName);


        HashMap<String, Integer> amountName = new HashMap<>();
        Integer i = 1;
        for (String str: name) {
            if(amountName.containsKey(str)){
                amountName.put(str, amountName.get(str)+1);
            }
            else amountName.put(String.valueOf(str), i);
        }
        System.out.println(amountName);
    }
}
