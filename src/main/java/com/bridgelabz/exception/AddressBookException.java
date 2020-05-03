package com.bridgelabz.exception;

public class AddressBookException extends Exception{

    public enum MyException_Type{
        WRONG_CHOICE,FILE_ALREADY_EXISTS,FILE_EMPTY;
    }
    MyException_Type type;

    public AddressBookException(MyException_Type type,String message) {
        super(message);
        this.type = type;
    }
}
