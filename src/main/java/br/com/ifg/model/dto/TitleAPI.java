package br.com.ifg.model.dto;

import jakarta.json.bind.annotation.JsonbProperty;

import java.util.List;


public class TitleAPI {
    @JsonbProperty("Title")
    private String title;
    @JsonbProperty("Year")
    private String year;
    @JsonbProperty("Rated")
    private String rated;
    @JsonbProperty("Released")
    private String released;
    @JsonbProperty("Runtime")
    private String runtime;
    @JsonbProperty("Genre")
    private String genre;
    @JsonbProperty("Director")
    private String director;
    @JsonbProperty("Writer")
    private String writer;
    @JsonbProperty("Actors")
    private String actors;
    @JsonbProperty("Plot")
    private String plot;
    @JsonbProperty("Language")
    private String language;
    @JsonbProperty("Country")
    private String country;
    @JsonbProperty("Awards")
    private String awards;
    @JsonbProperty("Poster")
    private String poster;
    @JsonbProperty("Ratings")
    private List<Rating> rantings;
    @JsonbProperty("Metascore")
    private String metascore;
    @JsonbProperty("imdbRating")
    private String imdbRating;
    @JsonbProperty("imdbVotes")
    private String imdbVotes;
    @JsonbProperty("imdbID")
    private String imdbId;
    @JsonbProperty("Type")
    private String type;
    @JsonbProperty("totalSeasons")
    private String seasons;
    @JsonbProperty("Response")
    private String response;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAwards() {
        return awards;
    }

    public void setAwards(String awards) {
        this.awards = awards;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<Rating> getRantings() {
        return rantings;
    }

    public void setRantings(List<Rating> rantings) {
        this.rantings = rantings;
    }

    public String getMetascore() {
        return metascore;
    }

    public void setMetascore(String metascore) {
        this.metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeasons() {
        return seasons;
    }

    public void setSeasons(String seasons) {
        this.seasons = seasons;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
