package com.bridgelabze.service;

import com.bridgelabze.model.Person;
import java.io.IOException;

public class AddressBookMain {

    public String addressBook(Person person, String file_path, String create_file) throws IOException {
        AddressBookControllerInterface controller = AddressBookFactory.createControlerInterface();
        AddressBookInterface addressBook = AddressBookFactory.createAddressBookInterface();
        switch (create_file){
            case "addressBook":
                return controller.createNewAddressBook(file_path);
        }
        return null;
    }
}
