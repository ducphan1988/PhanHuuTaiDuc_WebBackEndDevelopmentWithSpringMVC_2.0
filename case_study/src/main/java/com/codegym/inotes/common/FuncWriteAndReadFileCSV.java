package com.codegym.inotes.common;

import com.codegym.inotes.model.Note;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

public class FuncWriteAndReadFileCSV {
    // the delimiter to use for separating entries
    public static final char DEFAULT_SEPARATOR = ',';
    // the character to use for quoted elements
    public static final char DEFAULT_QUOTE = '"';

    // the line number to skip for start reading
    public static final int NUM_OF_LINE_SKIP = 1;

    // path file Villa
    public static final String pathVilla = "src/Data/Note.csv";

    // path file Room.csv
    public static final String pathRoom = "src/Data/Room.csv";

    // path file House
    public static final String pathHouse = "src/Data/House.csv";

    // path file House
    public static final String pathCustomer = "src/Data/Customer.csv";

    // path file Note
    public static final String pathNote = "src/Data/Note.csv";

    // path file Employee
    public static final String pathEmployee = "src/Data/Employee.csv";

    // header Note.csv
    public static String[] headerRecordVilla = new String[]{"id", "serviceName", "areaUsed", "rentalCosts", "maxNumberOfPeople", "rentType", "roomStandard", "convenientDescription", "areaPool", "numberOfFloors"};

    // header Room.csv
    public static String[] headerRecordRoom = new String[]{"id", "serviceName", "areaUsed", "rentalCosts", "maxNumberOfPeople", "rentType", "freeService"};

    // header House.csv
    public static String[] headerRecordHouse = new String[]{"id", "serviceName", "areaUsed", "rentalCosts", "maxNumberOfPeople", "rentType", "roomStandard", "convenientDescription", "numberOfFloors"};

    // header House.csv
    public static String[] headerRecordCustomer = new String[]{"fullName", "birthday", "gender", "idCard", "phone", "email", "customerType", "address"};

    // header Employee.csv
    public static String[] headerRecordEmployee = new String[]{"id", "fullName", "age", "address"};

    //header Booking.csv
    public static String[] headerRecordBooking = new String[]{"fullName", "birthday", "gender", "idCard", "phone", "email", "customerType", "address",
            "id", "serviceName", "areaUsed", "rentalCosts", "maxNumberOfPeople", "rentType"};

    //write Note to File CSV
    public static void writeNoteToFileCsv(Note note) {
        try (Writer writer = new FileWriter(pathNote);
             CSVWriter csvWriter = new CSVWriter(writer,
                     CSVWriter.DEFAULT_SEPARATOR,
                     CSVWriter.NO_QUOTE_CHARACTER,
                     CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                     CSVWriter.DEFAULT_LINE_END);) {

            //add Header of File
            csvWriter.writeNext(headerRecordBooking);
            if (note != null) {
                csvWriter.writeNext(new String[]
                        {String.valueOf(note.getId()), note.getTitle(), note.getContent()
                        });
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
