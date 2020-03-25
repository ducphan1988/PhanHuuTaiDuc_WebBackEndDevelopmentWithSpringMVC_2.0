package com.codegym.inotes.service;

import com.codegym.inotes.model.NoteType;

import java.util.Optional;

public interface NoteTypeService {
    Iterable<NoteType> findAll();

    void save(NoteType noteType);

    void remove(int id);

    Optional<NoteType> findById(Integer id);
}
