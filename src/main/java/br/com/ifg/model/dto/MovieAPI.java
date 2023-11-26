package br.com.ifg.model.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public class MovieAPI {
    @JsonbProperty("Title")
    private String title;
    @JsonbProperty("Year")
    private String year;
    @JsonbProperty("imdbID")
    private String imdbId;
    @JsonbProperty("Type")
    private String type;
    @JsonbProperty("Poster")
    private String poster;

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

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }
}
