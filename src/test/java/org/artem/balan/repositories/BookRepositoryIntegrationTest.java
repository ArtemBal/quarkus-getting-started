package org.artem.balan.repositories;

import jakarta.inject.Inject;
import org.artem.balan.utils.QuarkusTransactionalTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTransactionalTest
public class BookRepositoryIntegrationTest {

    @Inject
    BookRepository bookRepository;

    @Test
    void givenBookInRepository_whenFindByAuthor_thenShouldReturnBookFromRepository() {
        assertTrue(bookRepository.findBy("Herbert").findAny().isPresent());
    }
}
