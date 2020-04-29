package com.bridgelabze.service;

import com.bridgelabze.controller.AddressBookController;

public class AddressBookFactory {
    public static AddressBookControllerInterface createControlerInterface() {
        return new AddressBookController();
    }
    public static AddressBookInterface createAddressBookInterface() {
        return new AddressBook();
    }
}
