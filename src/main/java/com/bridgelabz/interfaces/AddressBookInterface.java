package com.bridgelabz.interfaces;
import com.bridgelabz.model.Person;
import java.io.IOException;

public interface AddressBookInterface {

    public String addPersonRecord(Person person, String file_path);
    public String deleteRecord(String... strings) throws IOException;
    public String  sortListByName(String file_path) throws IOException;
    public String sortListByZip(String file_path) throws IOException;
    public void printEntries(String file_path) throws IOException;
    public String updatePersonData(String... strings) throws IOException;
}
