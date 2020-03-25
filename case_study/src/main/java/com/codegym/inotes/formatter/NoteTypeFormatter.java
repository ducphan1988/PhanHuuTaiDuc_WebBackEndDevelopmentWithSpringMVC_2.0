package com.codegym.inotes.formatter;

import com.codegym.inotes.model.NoteType;
import com.codegym.inotes.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

public class NoteTypeFormatter implements Formatter<Optional<NoteType>> {
    private NoteTypeService noteTypeService;

    @Autowired
    public NoteTypeFormatter(NoteTypeService noteTypeService) {
        this.noteTypeService = noteTypeService;
    }

    @Override
    public Optional<NoteType> parse(String s, Locale locale) throws ParseException {
        return noteTypeService.findById(Integer.parseInt(s));
    }

    @Override
    public String print(Optional<NoteType> noteType, Locale locale) {
        return "["+noteType.get()+"]";
    }
}
