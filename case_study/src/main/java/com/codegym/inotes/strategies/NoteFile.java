package com.codegym.inotes.strategies;

import com.codegym.inotes.common.FuncWriteAndReadFileCSV;
import com.codegym.inotes.model.Note;
import com.codegym.inotes.repository.NoteRepository;

public class NoteFile implements NoteStrategy {
    @Override
    public void save(Note note, NoteRepository noteRepository) {
        System.out.println("Save by file");
        //Write to CSV
        FuncWriteAndReadFileCSV.writeNoteToFileCsv(note);
        System.out.println("--- Add Note for : " + note.getId() + " Successfully !!!");
    }

    @Override
    public void delete() {
        System.out.println("Delete by file");
    }
}
