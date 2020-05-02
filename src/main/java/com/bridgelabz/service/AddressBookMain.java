package com.bridgelabz.service;
import com.bridgelabz.exception.AddressBookException;
import com.bridgelabz.interfaces.AddressBookControllerInterface;
import com.bridgelabz.interfaces.AddressBookInterface;
import com.bridgelabz.model.Person;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class AddressBookMain {

    // Variable
    private static String path = "F:\\bridgelabze\\addressBook\\addressBook\\";
    private static String filepath = null;

    // Object
    public static AddressBookControllerInterface controller = AddressBookFactory.createControllerInterface();
    public static AddressBookInterface addressBook = addressBook = AddressBookFactory.createAddressBookInterface();

    // function address Book to provide service.
    public String addressBook(Person person, String... stringArg) throws AddressBookException, IOException {
        switch (stringArg[1]) {
            case "addressBook":
                return controller.createNewAddressBook(stringArg[0]);
            case "addRecord":
                return addressBook.addPersonRecord(person, stringArg[0]);
            case "deleteRecord":
                return addressBook.deleteRecord(stringArg[0], stringArg[2]);
            case "sortListByName":
                return addressBook.sortListByName(stringArg[0]);
            case "sortListByZip":
                return addressBook.sortListByZip(stringArg[0]);
            case "printRecords":
                addressBook.printEntries(stringArg[0]);
                return "printAll";
            default:
                throw new AddressBookException(AddressBookException.MyException_Type.WRONG_CHOICE, "Enter Right Choice");
        }
    }
}
