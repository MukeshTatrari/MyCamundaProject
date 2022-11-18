package com.mukesh.workflow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Test1 {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        while ((line = in.readLine()) != null) {
            if (line.length() > 2) {
                System.out.println("Error");
            } else {
                if (line.charAt(0) > 'f' || line.charAt(1) > '8') {
                    System.out.println("Error");
                } else {
                    boolean x = checkSquare(line);
                    if (x) {
                        System.out.println("White");
                    } else {
                        System.out.println("Black");
                    }
                }
            }
        }
    }

    public static boolean checkSquare(String coordinates) {
        if ((coordinates.charAt(0) + coordinates.charAt(1) - '0') % 2 == 0) {
            return false;
        } else {
            return true;
        }
    }
}

