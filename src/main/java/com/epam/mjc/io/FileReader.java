package com.epam.mjc.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class FileReader {

    public Profile getDataFromFile(File file) {
        BufferedReader inputStream = null;
        Profile profile = new Profile();

        try {
            inputStream = new BufferedReader(new java.io.FileReader(file));
            String str;
            Map<String, String> map = new HashMap<>();

            while ((str = inputStream.readLine()) != null) {
                String[] tokens = str.split(": ");
                map.put(tokens[0], tokens[1]);
            }

            for (String s : map.keySet()) {
                switch (s) {
                    case "Name":
                        profile.setName(map.get(s));
                        break;
                    case "Email":
                        profile.setEmail(map.get(s));
                        break;
                    case "Age":
                        profile.setAge(Integer.parseInt(map.get(s)));
                        break;
                    case "Phone":
                        profile.setPhone(Long.parseLong(map.get(s)));
                        break;
                    default:
                        System.out.println("Illegal input!");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return profile;
    }

}
