package br.com.ifg.model.entity;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "usr_movie", schema = "moviefan")
public class UserMovie implements Serializable {
    @EmbeddedId
    protected UserMoviePK userMoviePK;
    @Column(name = "rate")
    private int rate;
    @Column(name = "watchlist")
    private boolean watchlist;
    @Column(name = "watched")
    private boolean watched;
    @ManyToOne
    @JoinColumn(name = "movie_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public UserMoviePK getUserMoviePK() {
        return userMoviePK;
    }

    public void setUserMoviePK(UserMoviePK userMoviePK) {
        this.userMoviePK = userMoviePK;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public boolean isWatchlist() {
        return watchlist;
    }

    public void setWatchlist(boolean watchlist) {
        this.watchlist = watchlist;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }
}
