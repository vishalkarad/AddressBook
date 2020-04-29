package com.bridgelabz.service;

import com.bridgelabz.controller.AddressBookController;
import com.bridgelabz.interfaces.AddressBookControllerInterface;

public class AddressBookFactory {

    // Return Object Of AddressBookController
    public static AddressBookControllerInterface createControlerInterface() {
        return new AddressBookController();
    }
}
