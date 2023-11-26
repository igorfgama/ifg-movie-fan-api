package br.com.ifg.resource;

import br.com.ifg.model.dto.SearchAPI;
import br.com.ifg.model.dto.TitleAPI;
import br.com.ifg.model.dto.UserMovieDTO;
import br.com.ifg.service.MovieService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.JsonWebToken;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/movie")
public class MovieResource {

    @Inject
    MovieService movieService;

    @Inject
    JsonWebToken jwt;

    @Operation(summary = "Método para buscar lista de filmes")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = SearchAPI.class, type = SchemaType.ARRAY)))
    @Tag(name = "movie search")
    @POST
    @Path("/search/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchAPI search(@PathParam("title") String title) {
        return movieService.search(title);
    }

    @Operation(summary = "Método para buscar lista de filmes com ano definido")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = SearchAPI.class, type = SchemaType.ARRAY)))
    @Tag(name = "movie by year")
    @POST
    @Path("/search/{title}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchAPI searchYear(@PathParam("title") String title, @PathParam("year") String year) {
        return movieService.searchYear(title, year);
    }

    @Operation(summary = "Método para buscar lista de filmes filtrados por tipo")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = SearchAPI.class, type = SchemaType.ARRAY)))
    @Tag(name = "movie by year")
    @POST
    @Path("/search/{title}/{type}")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchAPI searchType(@PathParam("title") String title, @PathParam("type") String type) {
        return movieService.searchType(title, type);
    }

    @Operation(summary = "Método para buscar a quantidade de filmes de um search")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = String.class, type = SchemaType.ARRAY)))
    @Tag(name = "movie quantity")
    @POST
    @Path("/search/qtd/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public String qtd(@PathParam("title") String title) {
        return movieService.qtdMovies(title);
    }

    @Operation(summary = "Método para buscar a filme por título")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = TitleAPI.class, type = SchemaType.ARRAY)))
    @Tag(name = "movie title")
    @POST
    @Path("/title/{title}")
    @Produces(MediaType.APPLICATION_JSON)
    public TitleAPI searchTitle(@PathParam("title") String param) {
        return movieService.searchTitle(param);
    }

    @Operation(summary = "Método para buscar a filme por id")
    @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON, schema = @Schema(implementation = TitleAPI.class, type = SchemaType.ARRAY)))
    @Tag(name = "movie id")
    @POST
    @Path("/title/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public TitleAPI searchTitleId(@PathParam("id") String param) {
        return movieService.searchTitleId(param);
    }

    @POST
    @Path("/title/{param}/{year}")
    @Produces(MediaType.APPLICATION_JSON)
    public TitleAPI searchTitle(@PathParam("param") String param, @PathParam("year") String year) {
        return movieService.searchTitle(param, year);
    }

    @Operation(summary = "Método para salvar filme no repositório")
    @Tag(name = "movie save")
    @POST
    @Path("/save/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response saveMovie(@PathParam("id") String id) {
        return  Response.ok(movieService.saveMovie(id)).build();
    }

    @Operation(summary = "Método para avaliar um filme")
    @Tag(name = "movie rate")
    @POST
    @RolesAllowed("User")
    @Path("/rating")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response rating(UserMovieDTO userMovie) {
        String email = jwt.getName();
        return Response.ok(movieService.rating(userMovie, email)).build();
    }

    @Operation(summary = "Método para avaliar um filme")
    @Tag(name = "movie rate")
    @GET
    @RolesAllowed("User")
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response allMoviesByUser() {
        String email = jwt.getName();
        return Response.ok(movieService.listAllMovies(email)).build();
    }

    @Operation(summary = "Método para retonar lista de filmes")
    @Tag(name = "movie list")
    @GET
    @Path("/list/{title}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response allMovies(@PathParam("title") String title) {
        return Response.ok(movieService.searchResponse(title)).build();
    }
}
