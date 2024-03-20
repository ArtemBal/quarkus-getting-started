package org.artem.balan.utils;

import javax.annotation.PostConstruct;
import javax.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Alternative;
import org.artem.balan.model.Book;
import org.artem.balan.repositories.BookRepository;

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
