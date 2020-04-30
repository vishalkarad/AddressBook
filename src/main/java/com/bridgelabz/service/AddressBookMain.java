package com.bridgelabz.service;

import com.bridgelabz.exception.AddressBookException;
import com.bridgelabz.interfaces.AddressBookControllerInterface;
import com.bridgelabz.interfaces.AddressBookInterface;
import com.bridgelabz.model.Person;
import org.junit.Before;

public class AddressBookMain {

    // Object reference
    AddressBookControllerInterface controller;
    AddressBookInterface addressBook;

    @Before
    public void setUp() {
        controller = AddressBookFactory.createControlerInterface();
        addressBook = AddressBookFactory.createAddressBookInterface();
    }

    // function address Book to provide service.
    public String addressBook(Person person, String file_path, String choice) throws AddressBookException {
        switch (choice) {
            case "addressBook":
                return controller.createNewAddressBook(file_path);
            case "addRecord":
                return addressBook.addPersonRecord(person, file_path);
            default: {
                throw new AddressBookException(AddressBookException.MyException_Type.WRONG_CHOICE, "Enter Right Choice");
            }
        }
    }
}
