package com.bridgelabz.service;

import com.bridgelabz.exception.AddressBookException;
import com.bridgelabz.interfaces.AddressBookInterface;
import com.bridgelabz.model.Person;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class AddressBook implements AddressBookInterface {

    // class objects
    File file;
    ObjectMapper mapper = new ObjectMapper();

    // Add Record In file
    @Override
    public String addPersonRecord(Person person, String file_path) {
        try {
            this.file = new File(file_path);
            List<Person> list = new ArrayList<>();
            if (file.length() > 0)
                list = readFile(file_path);
            list.add(person);
            saveRecord(list);
            return "Add Records Successfully";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Delete A Particular Record
    @Override
    public String deleteRecord(String... strings) throws IOException {
        int position = Integer.parseInt(strings[1]);
        List arrayList = new ArrayList();
        arrayList = readFile(strings[0]);
        arrayList.remove(arrayList.get(position - 1));
        if (arrayList.size() > 0)
            saveRecord(arrayList);
        return "Delete Record";
    }

    // Save Records In File
    public void saveRecord(List<Person> list) throws IOException {
        mapper.writeValue(file, list);
    }

    // Read Address book
    public List<Person> readFile(String file_path) {
        try {
            this.file = new File(file_path);
            if (file.length() == 0)
                throw new AddressBookException(AddressBookException.MyException_Type.FILE_EMPTY, "File is Empty");
            return mapper.readValue(file, new TypeReference<ArrayList<Person>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Sort List By Last Name
    @Override
    public String sortListByName(String file_path) throws IOException {
        List arrayList = new ArrayList();
        arrayList = readFile(file_path);
        Collections.sort(arrayList, Comparator.comparing(Person::getLastName));
        List<Person> sortList = Arrays.asList(mapper.readValue(new File(file_path), Person[].class));
        sortList.stream().forEach(value -> System.out.println(value.getFirstName() + " " + value.getLastName() + " " + value.getState()
                + " " + value.getCity() + " " + value.getZip() + " " + value.getPhoneNumber()));
        return "Sort Records ByName";
    }

    // Sort List By Zip Code
    @Override
    public String sortListByZip(String file_path) throws IOException {
        List arrayList = new ArrayList();
        arrayList = readFile(file_path);
        Collections.sort(arrayList, Comparator.comparing(Person::getZip));
        List<Person> sortList = Arrays.asList(mapper.readValue(new File(file_path), Person[].class));
        sortList.stream().forEach(value -> System.out.println(value.getFirstName() + " " + value.getLastName() + " " +
                value.getState() + " " + value.getCity() + " " + value.getZip() + " " + value.getPhoneNumber()));
        return "Sort Records ByZip";
    }

    @Override
    // Print All Records In File
    public void printEntries(String file_path) throws IOException {
        AtomicInteger rowNumber = new AtomicInteger(1);
        List<Person> sortList = Arrays.asList(mapper.readValue(new File(file_path), Person[].class));
        sortList.stream().forEach(value -> System.out.println(rowNumber.getAndIncrement() + " " + value.getFirstName() + " "
                + value.getLastName() + " " + value.getState() + " " + value.getCity() + " " + value.getZip() + " " + value.getPhoneNumber()));
    }

    public String updatePersonData(String... strings) throws IOException {
        int position = Integer.parseInt(strings[1]); //strings[1]=position of record
        List<Person> arrayList = new ArrayList();
        arrayList = readFile(strings[0]); //strings[0]=file path of address book
        switch (strings[2]){ //strings[2]= choice of which property update of person
            case "CITY":
                arrayList.get(position-1).setCity(strings[3]); //strings[3]=set value
                break;
            case "STATE":
                arrayList.get(position-1).setState(strings[3]);
                break;
            case "ZIP":
                arrayList.get(position-1).setZip(strings[3]);
                break;
            case "PHONENUMBER":
                arrayList.get(position).setPhoneNumber(strings[3]);
                break;
            default:
                System.out.println("Enter A Write property Name");
        }
            saveRecord(arrayList);
        return "Update Record";
    }
}
