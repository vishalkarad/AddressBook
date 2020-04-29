package com.bridgelabz.service;
import com.bridgelabz.exception.AddressBookException;
import com.bridgelabz.interfaces.AddressBookControllerInterface;
import com.bridgelabz.model.Person;


public class AddressBookMain {

    // function address Book to provide service.
    public String addressBook(Person person, String file_path, String create_file) throws AddressBookException {
        AddressBookControllerInterface controller = AddressBookFactory.createControlerInterface();
        switch (create_file) {
            case "addressBook":
                return controller.createNewAddressBook(file_path);
            default: {
                throw new AddressBookException(AddressBookException.MyException_Type.WRONG_CHOICE, "Enter Right Choice");
            }
        }
    }
}
