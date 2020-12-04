package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static List<Integer> createIntListFromFile(String file) {
        List<Integer> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String test;
            while ((test = br.readLine()) != null) {
                content.add(Integer.valueOf(test));
            }
        } catch (IOException e) {
            //Some error logging
        }
        return content;
    }

    public static List<String> createStringListFromFile(String file) {
        List<String> content = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String test;
            while ((test = br.readLine()) != null) {
                content.add((test));
            }
        } catch (IOException e) {
            //Some error logging
        }
        return content;
    }

    public static String convertFileToString(String path) throws IOException {
        File file = new File(path);
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        String two = "";
        while ((st = br.readLine()) != null) {
            two += st + "\n";
        }
        return two;
    }
}
