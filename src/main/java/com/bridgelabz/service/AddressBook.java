package com.bridgelabz.service;


import com.bridgelabz.interfaces.AddressBookInterface;
import com.bridgelabz.model.Person;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddressBook implements AddressBookInterface {

    // Add Record in json file
    @Override
    public String addPersonRecord(Person person, String file_path) {
        try {
            File file = new File(file_path);
            FileWriter printWriter = new FileWriter(file,true);
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(person.toString());
            printWriter.write(jsonString);
            printWriter.flush();
            return "Add Records Successfully";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List readFile(String file_path) throws IOException {
        FileReader file = new FileReader(new File(file_path));
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(file);
        List ar = new ArrayList();
        ar.add(jsonNode);
        return ar;
    }
}
