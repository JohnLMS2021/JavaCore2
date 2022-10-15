package Lesson5;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class main {
    static String value = "Value 1;, Value 2;, Value 3;" + System.getProperty("line.separator");
    static ArrayList<Numbers> numbersArray = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        createNum();
        writer();
        readApp();




    }
    public static void createNum() {
        Random random = new Random();
        for (int i = 9; i < 1000; i++) {
            numbersArray.add(new Numbers (i, random.nextInt(100), random.nextInt(1000)));
        }

    }
    public static void writer() throws IOException {
        try (FileWriter ignored = new FileWriter("src/Lesson5/test.csv")){
            ignored.write(value);
            for(Numbers numbers : numbersArray) {
                ignored.write(numbers.getColumn1() + ";" + numbers.getColumn2()
                        + ";" + numbers.getColumn3() + ";"+ System.getProperty("line.separator"));
            }
        }
    }

    public static void readApp() throws IOException {
        AppData appData = new AppData();
        List<List<String>> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/Lesson5/test.csv"))){
            String line = br.readLine();
            appData.setHeader(line.split(";"));
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                records.add(Arrays.asList(values));
            }

        };
        int[][] resultData = new int[records.size()][3];

        for(int i=0; i<records.size(); i++){
            for(int j=0; j < records.get(i).size(); j++){
                resultData[i][j] = Integer.parseInt(records.get(i).get(j));
            }
        }
        appData.setData(resultData);

    }

}

