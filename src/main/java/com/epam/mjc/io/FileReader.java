package com.epam.mjc.io;

import java.io.*;

public class FileReader {
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader inputStream = new BufferedReader(new java.io.FileReader(file))) {
            String str;
            String[] tokens;
            while ((str = inputStream.readLine()) != null) {
                tokens = str.split(": ");
                switch (tokens[0]) {
                    case "Name":
                        profile.setName(tokens[1]);
                        break;
                    case "Email":
                        profile.setEmail(tokens[1]);
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(tokens[1]));
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(tokens[1]));
                        break;
                    default:
                        System.out.println("Illegal input!");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
