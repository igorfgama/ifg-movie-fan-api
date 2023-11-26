package br.com.ifg.model.dto;

import jakarta.json.bind.annotation.JsonbProperty;

import java.util.ArrayList;
import java.util.List;

public class SearchAPI {
    @JsonbProperty("Search")
    private List<MovieAPI> movies = new ArrayList<>();
    @JsonbProperty("totalResults")
    private String totalResults;
    @JsonbProperty("Response")
    private String response;

    public List<MovieAPI> getMovies() {
        return movies;
    }

    public void setMovies(List<MovieAPI> movies) {
        this.movies = movies;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
