package com.bridgelabz.service;
import com.bridgelabz.controller.AddressBookController;
import com.bridgelabz.interfaces.AddressBookControllerInterface;
import com.bridgelabz.interfaces.AddressBookInterface;

public class AddressBookFactory {

    // Return Object Of AddressBookController
    public static AddressBookControllerInterface createControllerInterface() {
        return new AddressBookController();
    }

    // Return Object Of AddressBookController
    public static AddressBookInterface createAddressBookInterface() {
        return new AddressBook();
    }
}
