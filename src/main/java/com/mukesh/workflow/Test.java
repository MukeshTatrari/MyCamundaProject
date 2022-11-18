package com.mukesh.workflow;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    // arguments are passed using the text field below this editor
    public static void main(String[] args) {

        String s = new String("Someone I know :o) recently combined Maple Syrup :'D & buttered Popcorn 8~C thinking it would taste like caramel popcorn >;'@. It didn’t :-< and they don’t recommend anyone ;{ else do it either :o@ :o3.");

        System.out.println("found: " + countSmileys(s));

    }

    public static int countSmileys(String input) {
        int count = 0;
//        Pattern pattern = Pattern.compile(">?[:;8]'?[-~o]");
        Pattern pattern = Pattern.compile(">?[:;8]'?[-~o]?[({@C<]");

        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            count++;
        }

        return count;
    }
}
