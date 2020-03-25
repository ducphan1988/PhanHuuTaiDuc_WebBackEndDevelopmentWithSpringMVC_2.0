package com.codegym.inotes.repository;

import com.codegym.inotes.model.NoteType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTypeRepository extends CrudRepository<NoteType, Integer> {
}
