package br.com.ifg.repository;

import br.com.ifg.model.entity.Movie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class MovieRepository implements PanacheRepository<Movie> {

    public Optional<Movie> findMovieById(String imdbId) {
        return find("imdbId", imdbId).firstResultOptional();
    }

    public void save(Movie movie) {
        persist(movie);
    }
}
