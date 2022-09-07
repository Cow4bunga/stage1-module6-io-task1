package com.epam.mjc.io;

import java.io.*;


public class FileReader {
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        try (BufferedReader inputStream = new BufferedReader(new java.io.FileReader(file))) {
            profile.setName(inputStream.readLine().substring(6));
            profile.setAge(Integer.parseInt(inputStream.readLine().substring(5)));
            profile.setEmail(inputStream.readLine().substring(7));
            profile.setPhone(Long.parseLong(inputStream.readLine().substring(7)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return profile;
    }
}
