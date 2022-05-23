package com.alexooodev.springWebApp.repositories;

import com.alexooodev.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
