package com.bridgelabz.controller;
import com.bridgelabz.exception.AddressBookException;
import com.bridgelabz.interfaces.AddressBookControllerInterface;
import java.io.File;

public class AddressBookController implements AddressBookControllerInterface {

    // Creating a new address book
    @Override
    public String createNewAddressBook(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists() == true) {
                throw new AddressBookException(AddressBookException.MyException_Type.FILE_ALREADY_EXISTS, "This File Already Exists");
            }else file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "File Created Successfully";
    }

}
