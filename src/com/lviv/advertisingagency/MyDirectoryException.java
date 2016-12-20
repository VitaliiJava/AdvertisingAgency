package com.lviv.advertisingagency;

/**
 * Created by Vitalik on 28.09.2016.
 */
public class MyDirectoryException extends MyObjectException {

    private String newMessage;

    public MyDirectoryException(String message) {
        super(message);
        this.newMessage = "You got MyDirectoryException! Check if the directory was created and path for it.Be carefull";
    }

    public void print() {
        System.out.println("I'm from MyDirectoryException method ".concat(newMessage));
    }
}