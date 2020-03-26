package com.codegym.inotes.service.impl;

import com.codegym.inotes.service.NoteService;
import com.codegym.inotes.strategies.NoteManagement;
import com.codegym.inotes.strategies.NoteStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.codegym.inotes.model.Note;
import com.codegym.inotes.repository.NoteRepository;

import java.util.Optional;

//@Service("noteService")
@Service()
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    private NoteStrategy noteStrategy;

    public NoteServiceImpl() {
        this.noteStrategy = NoteManagement.getNoteStrategy();
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllByTitleContaining(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title, pageable);
    }

    @Override
    public Page<Note> findAllByTitleContainingAndNoteType_Id(String title, Integer noteTypeId, Pageable pageable) {
        return noteRepository.findAllByTitleContainingAndNoteType_Id(title, pageable);
    }

//    @Override
//    public void save(Note note) {
//        noteRepository.save(note);
//    }

    @Override
    public void remove(Integer id) {
        noteRepository.deleteById(id);
    }


    @Override
    public Optional<Note> findById(Integer id) {
        return noteRepository.findById(id);
    }

    @Override
    public void save(Note note) {
        noteStrategy.save(note, noteRepository);
    }

//    @Override
//    public void delete() {
//        noteStrategy.delete();
//    }
}
