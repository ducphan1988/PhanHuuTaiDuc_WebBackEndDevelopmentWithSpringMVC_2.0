package com.codegym.inotes.strategies;

import com.codegym.inotes.model.Note;
import com.codegym.inotes.repository.NoteRepository;

public interface NoteStrategy {
    void save(Note note, NoteRepository noteRepository);
    void delete();
}
