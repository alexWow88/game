package com.company;

import java.io.Console;
import java.util.concurrent.TimeUnit;

public class TypeWriter {

    public static void type(String message) throws InterruptedException {
        // in here you will flush and then type it slowly....
       for (char c: message.toCharArray()
             ) {
            System.out.print(c);
            Thread.sleep(10);
        }
//        System.out.println(" ");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
