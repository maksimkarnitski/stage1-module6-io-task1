package com.epam.mjc.io;

import java.io.*;


public class FileReader {

    public Profile getDataFromFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();

        try (FileInputStream input = new FileInputStream(file)) {
            int ch;
            while ((ch=input.read()) != -1) {
                stringBuilder.append((char)ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] abc = stringBuilder.toString().split("\r\n");

        String nameValue = abc[0].substring(abc[0].indexOf(" ") + 1);
        int ageValue = Integer.parseInt(abc[1].substring(abc[1].indexOf(" ") + 1));
        String emailValue = abc[2].substring(abc[2].indexOf(" ") + 1);
        long phoneValue = Long.parseLong(abc[3].substring(abc[3].indexOf(" ") + 1));

        return new Profile(nameValue, ageValue, emailValue, phoneValue);
    }
}
