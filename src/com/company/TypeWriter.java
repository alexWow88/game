package com.company;

public class TypeWriter {

    public static void type(String message) throws InterruptedException {
        // slowly print text
       for (char c: message.toCharArray()
             ) {
            System.out.print(c);
            Thread.sleep(10);
        }
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
