package com.codegym.inotes.strategies;

import com.codegym.inotes.model.Note;
import com.codegym.inotes.repository.NoteRepository;
import com.codegym.inotes.service.impl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

public class NoteDB implements NoteStrategy {

    @Override
    public void save(Note note, NoteRepository noteRepository) {
        System.out.println("Save by DB");
        noteRepository.save(note);
    }

    @Override
    public void delete() {
        System.out.println("Delete by DB");
    }
}
