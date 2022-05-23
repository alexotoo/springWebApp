package com.alexooodev.springWebApp.bootstrap;

import com.alexooodev.springWebApp.domain.Author;
import com.alexooodev.springWebApp.domain.Book;
import com.alexooodev.springWebApp.domain.Publisher;
import com.alexooodev.springWebApp.repositories.AuthorRepository;
import com.alexooodev.springWebApp.repositories.BookRepository;
import com.alexooodev.springWebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private  final BookRepository bookRepository;

    private  final PublisherRepository publisherRepository;

    public bootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("General PG");
        publisher.setCity("Accra");
        publisher.setState("Greater Accra");

        publisherRepository.save(publisher);

        Author alex = new Author("Alex", "Doe");
        Book coded = new Book("coding power","123123");


        alex.getBooks().add(coded);
        coded.getAuthors().add(alex);
        coded.setPublisher(publisher);
        publisher.getBooks().add(coded);

        authorRepository.save(alex);
        bookRepository.save(coded);
        publisherRepository.save(publisher);

        Author ama = new Author("ama", "Doe");
        Book methods = new Book("methods of coding power","12231223");
        ama.getBooks().add(methods);
        methods.getAuthors().add(ama);
        methods.setPublisher(publisher);
        publisher.getBooks().add(methods);

        authorRepository.save(ama);
        bookRepository.save(methods);
        publisherRepository.save(publisher);

        System.out.println("start ----Bootstrap");
        System.out.println("Number of Books:- " + bookRepository.count());
        System.out.println("Publisher of Books:- " + publisher.getBooks().size());


    }
}
