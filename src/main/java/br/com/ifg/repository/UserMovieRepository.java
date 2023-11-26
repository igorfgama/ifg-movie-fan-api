package br.com.ifg.repository;

import br.com.ifg.model.dto.MovieListResponse;
import br.com.ifg.model.entity.Movie;
import br.com.ifg.model.entity.UserMovie;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@ApplicationScoped
public class UserMovieRepository implements PanacheRepository<UserMovie> {

    public List<MovieListResponse> findAllMovieByUser(Long id) {
        List<MovieListResponse> list = new ArrayList<>();
        listAll().forEach(m -> {
                    if (m.getUserMoviePK().getUserId().equals(id)) {
                        MovieListResponse l = new MovieListResponse();
                        l.setId(m.getMovie().getId());
                        l.setPoster(m.getMovie().getPoster());
                        l.setRate(m.getRate());
                        l.setYear(m.getMovie().getYear());
                        l.setTitle(m.getMovie().getTitle());
                        l.setImdbId(m.getMovie().getImdbId());

                        list.add(l);
                    }
                }
         );

        list.sort(Comparator.comparing(MovieListResponse::getRate).reversed());
        return list;
    }
}
