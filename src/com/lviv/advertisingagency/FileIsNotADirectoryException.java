package com.lviv.advertisingagency;

/**
 * Created by Vitalik on 28.09.2016.
 */
public class FileIsNotADirectoryException extends MyFileException {

    private String newMessage;

    public FileIsNotADirectoryException(String message) {
        super(message);
        this.newMessage = "File is not a directory Exception!. Be carefull";
    }

    public void print() {
        System.out.println("I'm from FileIsNotADirectoryException method ".concat(newMessage));
    }
}
