package org.artem.balan.utils;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import org.artem.balan.model.Book;
import org.artem.balan.repositories.BookRepository;

import javax.annotation.Priority;

@Priority(1)
@Alternative
@ApplicationScoped
public class TestBookRepository extends BookRepository {
    @PostConstruct
    public void init() {
        persist(new Book("Dune", "Frank Herbert"),
                new Book("Foundation", "Isaac Asimov"));
    }
}
