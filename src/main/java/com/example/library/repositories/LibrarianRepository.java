package com.example.library.repositories;

import com.example.library.model.Librarian;
import org.springframework.data.repository.CrudRepository;

public interface LibrarianRepository extends CrudRepository<Librarian, Long> {
}
