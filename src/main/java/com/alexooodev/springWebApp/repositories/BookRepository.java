package com.alexooodev.springWebApp.repositories;

import com.alexooodev.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
