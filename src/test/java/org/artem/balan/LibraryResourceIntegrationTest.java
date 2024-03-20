package org.artem.balan;

import io.quarkus.test.common.http.TestHTTPResource;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.net.URL;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasItem;

@QuarkusTest
public class LibraryResourceIntegrationTest {

    @TestHTTPResource("/library/book")
    URL libraryEndpoint;

    @Test
    void whenGetBooksByTitle_thenBookShouldBeFound() {
        given().contentType(ContentType.JSON).param("query", "Dune")
                .when().get(libraryEndpoint)
                .then().statusCode(200)
                .body("size()", is(1))
                .body("title", hasItem("Dune"))
                .body("author", hasItem("Frank Herbert"));
    }
}
