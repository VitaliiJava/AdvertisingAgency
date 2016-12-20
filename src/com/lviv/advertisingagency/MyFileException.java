package com.lviv.advertisingagency;

/**
 * Created by Vitalik on 28.09.2016.
 */
public class MyFileException extends MyObjectException {

    private String newMessage;

    public MyFileException(String message) {
        super(message);
        this.newMessage = "You got MyFileException! Check if the directory was created and path for it. Be carefull";
    }

    public void print() {
        System.out.println("I'm from MyFileException method ".concat(newMessage));
    }
}