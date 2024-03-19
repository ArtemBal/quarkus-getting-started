package org.artem.balan.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import org.artem.balan.model.Book;

import java.util.stream.Stream;

import static io.quarkus.panache.common.Parameters.with;

@ApplicationScoped
public class BookRepository implements PanacheRepository<Book> {
    public Stream<Book> findBy(String query) {
        return find("author like :query or title like :query", with("query", "%"+query+"%")).stream();
    }
}
