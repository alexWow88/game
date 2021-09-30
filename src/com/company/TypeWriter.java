package com.company;

import java.io.Console;

public class TypeWriter {

    public static void type(String message) {
        // in here you will flush and then type it slowly....
        Console cnsl
                = System.console();
        cnsl.flush();
        System.out.println(
                message);
        return;
    }
}
