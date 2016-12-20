package com.lviv.advertisingagency;


public class MyObjectException extends Exception {

    private String newMessage;

    public MyObjectException(String message) {
        super(message);
        this.newMessage = "You got MyObjectException! Check directories and files and path for it.Be carefull";
    }

    public void print() {
        System.out.println("I'm from MyObjectException method ".concat(newMessage));
    }
}