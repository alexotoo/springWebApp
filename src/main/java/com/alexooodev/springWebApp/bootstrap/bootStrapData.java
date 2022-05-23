package com.alexooodev.springWebApp.bootstrap;

import com.alexooodev.springWebApp.domain.Author;
import com.alexooodev.springWebApp.domain.Book;
import com.alexooodev.springWebApp.repositories.AuthorRepository;
import com.alexooodev.springWebApp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;

    public bootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author alex = new Author("Alex", "Doe");
        Book coded = new Book("coding power","123123");
        alex.getBooks().add(coded);
        coded.getAuthors().add(alex);

        authorRepository.save(alex);
        bookRepository.save(coded);

        Author ama = new Author("ama", "Doe");
        Book methods = new Book("methods of coding power","12231223");
        alex.getBooks().add(methods);
        coded.getAuthors().add(ama);

        authorRepository.save(ama);
        bookRepository.save(methods);

        System.out.println("start ----Bootstrap");
        System.out.println("Number of Books:- " + bookRepository.count());


    }
}
