package com.epam.mjc.io;

import java.io.*;
import java.util.Arrays;


public class FileReader {

    public Profile getDataFromFile(File file) {
        String fileContent = "";
        try (FileInputStream input = new FileInputStream(file)) {
            int ch;
            while ((ch=input.read()) != -1) {
                fileContent = fileContent + (char)ch;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(fileContent);
        String[] abc = fileContent.split("\n");

        String nameValue = abc[0].substring(abc[0].indexOf(" ") + 1, abc[0].indexOf("\r"));
        int ageValue = Integer.parseInt(abc[1].substring(abc[1].indexOf(" ") + 1, abc[1].indexOf("\r")));
        String emailValue = abc[2].substring(abc[2].indexOf(" ") + 1, abc[2].indexOf("\r"));
        long phoneValue = Long.parseLong(abc[3].substring(abc[3].indexOf(" ") + 1, abc[3].indexOf("\r")));
        return new Profile(nameValue, ageValue, emailValue, phoneValue);
    }
}
