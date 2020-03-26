package com.codegym.inotes.strategies;

import com.codegym.inotes.common.Constants.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class NoteManagement {
//    private NoteStrategy noteStrategy;

    public static NoteStrategy getNoteStrategy() {
        Properties prop = new Properties();
        InputStream input = null;
        try {

            input = new FileInputStream("src/main/resources/application.properties");
            // load a properties file
            prop.load(input);

            // get the database value
            String database = prop.getProperty("store.type");
            if (database.equals("1")) {
                return new NoteDB();
            }
            if (database.equals("2")) {
                return new NoteFile();
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

//    public boolean changeNoteStore(StoreType storeType) {
//        if (storeType == StoreType.FILE) {
//            this.noteStrategy = new NoteFile();
//            return true;
//        }
//        if (storeType == StoreType.DB) {
//            this.noteStrategy = new NoteDB();
//            return true;
//        }
//        return false;
//    }
//
//    public void addNote(String title, String content, String typeId) {
//        noteStrategy.save();
//    }
//
//    public void removeNote(String noteId) {
//        noteStrategy.delete();
//    }
}
