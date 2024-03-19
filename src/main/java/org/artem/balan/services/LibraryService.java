package org.artem.balan.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import org.artem.balan.model.Book;
import org.artem.balan.repositories.BookRepository;

import javax.inject.Inject;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

@Transactional
@ApplicationScoped
public class LibraryService {

    @Inject
    BookRepository bookRepository;

    public Set<Book> find(String query) {
        if (query == null) {
            return bookRepository.findAll().stream().collect(toSet());
        }

        return bookRepository.findBy(query).collect(toSet());
    }

}
