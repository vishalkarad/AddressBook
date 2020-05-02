package com.bridgelabz.service;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileMenuOptions {

    // Display the all address book
    public List<String> displayTheContentsOfADirectory(){
        String filePath ="F:\\bridgelabze\\addressBook\\addressBook";
        File directory = new File(filePath);
        File[] fileOfDirectory = directory.listFiles();
        return Arrays.stream(fileOfDirectory).map(k -> k.getName()).collect(Collectors.toList());
    }

    // Print all address book file
    public void printContaintListInDirectory(){
        List list = displayTheContentsOfADirectory();
        System.out.println("List Of Files");
        list.stream().forEach(k -> System.out.println(k));
    }
}