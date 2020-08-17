package me.trqnquility.masterworks.utils;

import java.io.*;

public class Utils {

    public static String loadFileAsString(String path) {
        String content = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line + "\n");
            }
// delete the last new line separator
            reader.close();

             content = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }


    public static int parseInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
