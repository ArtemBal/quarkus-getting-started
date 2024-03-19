package org.artem.balan;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import org.artem.balan.services.LibraryService;


import java.util.Set;

@Path("/library")
public class LibraryResource {

    @Inject
    private LibraryService libraryService;

    @GET
    @Path("/book")
    public Set findBooks(@QueryParam("query") String query) {
        return libraryService.find(query);
    }
}
