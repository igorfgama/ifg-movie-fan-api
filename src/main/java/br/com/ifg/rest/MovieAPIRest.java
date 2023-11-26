package br.com.ifg.rest;

import br.com.ifg.model.dto.SearchAPI;
import br.com.ifg.model.dto.TitleAPI;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
/**
 * TODO: recurso para fazer requisição da API do IMDb
 *      - por título
 *      - por ano
 *      - por ID
 */

@RegisterRestClient
@Produces(MediaType.APPLICATION_JSON)
public interface MovieAPIRest {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    TitleAPI getMovieByTitle(@QueryParam("apikey") String apiKey, @QueryParam("t") String title);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    TitleAPI getMovieByTitle(@QueryParam("apikey") String apiKey, @QueryParam("t") String title, @QueryParam("y") String year);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    TitleAPI getMovieById(@QueryParam("apiKey") String apiKey, @QueryParam("i") String id);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    SearchAPI getMovieBySearch(@QueryParam("apikey") String apiKey, @QueryParam("s") String search);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    SearchAPI getMovieBySearch(@QueryParam("apikey") String apiKey, @QueryParam("s") String search, @QueryParam("y") String year);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    SearchAPI getMovieBySearch(@QueryParam("apikey") String apiKey, @QueryParam("s") String search, @QueryParam("page") Integer page);

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    SearchAPI getMovieByType(@QueryParam("apiKey") String apiKey, @QueryParam("s") String search, @QueryParam("type") String type);
}
