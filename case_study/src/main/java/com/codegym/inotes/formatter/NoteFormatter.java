package com.codegym.inotes.formatter;


import com.codegym.inotes.model.Note;
import com.codegym.inotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class NoteFormatter implements Formatter<Optional<Note>> {

    private NoteService noteService;

    @Autowired
    public NoteFormatter(NoteService noteService) {
        this.noteService = noteService;
    }


    @Override
    public Optional<Note> parse(String text, Locale locale) throws ParseException {
        return noteService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(Optional<Note> object, Locale locale) {
        return "["+object.get()+"]";
    }
}
