package Lesson4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private HashMap<String, String> phoneBook = new HashMap<>();

    public void add(String p, String n) {
        phoneBook.put(p, n);
    }

    public String get(String n) {
        if (phoneBook.containsValue(n)) {
            String result = "Номера телефонов для имени " + n + ":" + '\n';
            for (Map.Entry<String, String> s : phoneBook.entrySet()) {
                if (n == s.getValue()) {
                    result += s.getKey() + '\n';
                }
            }
            return result;
        } else
            return "Номер не найден";
    }
}


