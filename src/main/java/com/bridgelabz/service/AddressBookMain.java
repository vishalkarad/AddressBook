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

    // Declare main method
    public static void main(String[] args) throws IOException, AddressBookException {
        FileMenuOptions disc = new FileMenuOptions();
        System.out.println("Enter A Choice \n1) Create New Address Book File \n2) Open File\n3) Close Program");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String fileName = null;
        switch (choice) {
            case 1:
                System.out.println("Enter file name");
                fileName = scanner.nextLine();
                controller.createNewAddressBook(path + fileName + ".json");
                break;
            case 2:
                while (true) {
                    Scanner scanner1 = new Scanner(System.in);
                    try {
                        disc.printContaintListInDirectory();
                        System.out.println("\nEnter File Name :");
                        fileName = scanner1.nextLine();
                        filepath = path + fileName + ".json";
                        addressBook.printEntries(filepath);
                    } catch (FileNotFoundException e) {
                        System.out.println("Enter a write file name");
                        break;
                    }
                    System.out.println("\nIndex \n1) Add Person \n2) Delete a Person " + "\n3) Sort Entries by Name " +
                            "\n4) Sort Entries by ZIP \n5) Print Entries \n6) Quit Program");
                    System.out.println("\nEnter a choice :");
                    choice = scanner.nextInt();
                    if (choice > 1 && filepath == null) choice = 7;
                    switch (choice) {
                        case 1:
                            System.out.println("Enter First Name, Last Name, City, State, Zip, Mobile Number ");
                            String firstName, lastName, city, state, zip, mobileNumber;
                            addressBook.addPersonRecord(new Person(firstName = scanner1.nextLine(), lastName = scanner1.nextLine(),
                                    city = scanner1.nextLine(), state = scanner1.nextLine(), zip = scanner1.nextLine(),
                                    mobileNumber = scanner1.nextLine()), filepath);
                            break;
                        case 2:
                            System.out.println("Enter A Row Number");
                            String position = scanner1.nextLine();
                            addressBook.deleteRecord(filepath, position);
                            break;
                        case 3:
                            System.out.println("List Sort By Name ");
                            addressBook.sortListByName(filepath);
                            break;
                        case 4:
                            System.out.println("List Sort By Zip ");
                            addressBook.sortListByZip(filepath);
                            break;
                        case 5:
                            System.out.println("print All Entries");
                            addressBook.printEntries(filepath);
                            break;
                        case 6:
                            System.exit(0);
                        case 7:
                            System.out.println("First Open a file : ");

                    }
                }
            case 3:
                System.exit(0);
            default:
                throw new AddressBookException(AddressBookException.MyException_Type.WRONG_CHOICE, "Enter Right Choice");
        }
    }
}
