package br.com.ifg.service;

import br.com.ifg.enums.TypeEnum;
import br.com.ifg.model.dto.MovieListResponse;
import br.com.ifg.model.dto.SearchAPI;
import br.com.ifg.model.dto.TitleAPI;
import br.com.ifg.model.dto.UserMovieDTO;
import br.com.ifg.model.entity.Movie;
import br.com.ifg.model.entity.User;
import br.com.ifg.model.entity.UserMovie;
import br.com.ifg.model.entity.UserMoviePK;
import br.com.ifg.repository.MovieRepository;
import br.com.ifg.repository.UserMovieRepository;
import br.com.ifg.repository.UserRepository;
import br.com.ifg.rest.MovieAPIRest;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotAuthorizedException;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class MovieService {
    @ConfigProperty(name = "param.id")
    String id;

    @ConfigProperty(name = "param.apikey")
    String apiKey;

    @Inject
    MovieRepository movieRepository;

    @Inject
    UserRepository userRepository;

    @Inject
    UserMovieRepository userMovieRepository;

    @Inject
    @RestClient
    MovieAPIRest client;

    public SearchAPI search(String title) {
        return client.getMovieBySearch(apiKey, title);
    }

    public SearchAPI searchYear(String title, String year) {
        return client.getMovieBySearch(apiKey, title, year);
    }

    public SearchAPI searchType(String search, String type) {
        switch (TypeEnum.valueOf(type)) {
            case MOVIE, EPISODE, SERIES -> {
                return client.getMovieByType(apiKey, search, type);
            }
            default -> throw new RuntimeException("TIPO NÃO DEFINIDO: movie, series OU episode");
        }
    }

    public TitleAPI searchTitleId(String id) {
        return client.getMovieById(apiKey, id);
    }

    public TitleAPI searchTitle(String param) {
        return client.getMovieByTitle(apiKey, param);
    }

    public TitleAPI searchTitle(String param, String year) {
        return client.getMovieByTitle(apiKey, param, year);
    }

    public String qtdMovies(String title) {
        SearchAPI searchAPI = client.getMovieBySearch(apiKey, title);

        return "{\"totalMovies\":" + Integer.parseInt(searchAPI.getTotalResults()) + "}";
    }

    @Transactional
    public Movie saveMovie(String imdbId) {
        if (imdbId != null) {
            Optional<Movie> movieOptional = movieRepository.findMovieById(imdbId);

            if (movieOptional.isPresent()) {
                return movieOptional.get();
            } else {
                TitleAPI title = searchTitleId(imdbId);

                if (title != null) {
                    Movie movie = new Movie();
                    movie.setImdbId((title.getImdbId()));
                    movie.setPoster(title.getPoster());
                    movie.setTitle(title.getTitle());
                    movie.setType(title.getType());
                    movie.setYear(Integer.parseInt(title.getYear()));

                    movieRepository.save(movie);
                    return movie;
                }
            }
        }
        return null;
    }

    @Transactional
    public Movie rating(UserMovieDTO userMovieDTO, String email) {
        if(userMovieDTO.getRate() < 0 || userMovieDTO.getRate() > 10) {
            throw new RuntimeException("Valor de nota inválido!");
        }

        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()) {
            throw new NotAuthorizedException("Usuário não encontrado!");
        }

        if(!userMovieDTO.getWatched()) {
            throw new RuntimeException("Avaliação apenas possível para obras já assistidas!");
        }

        Optional<Movie> movie = movieRepository.findMovieById(userMovieDTO.getImdbId());

        if(movie.isEmpty()) {
            movie = Optional.ofNullable(saveMovie(userMovieDTO.getImdbId()));
        }

        if(movie.isPresent()) {
            UserMoviePK userMoviePK = new UserMoviePK();
            userMoviePK.setMovieId(movie.get().getId());
            userMoviePK.setUserId(user.get().getId());

            UserMovie userMovie = new UserMovie();
            userMovie.setMovie(movie.get());
            userMovie.setUserMoviePK(userMoviePK);
            userMovie.setRate(userMovieDTO.getRate());
            userMovie.setWatched(userMovieDTO.getWatched());
            userMovie.setWatchlist(userMovieDTO.getWatchlist());

            userMovieRepository.getEntityManager().merge(userMovie);

            return movie.get();
        }

        return null;
    }

    public List<MovieListResponse> listAllMovies(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if(user.isEmpty()) {
            throw new NotAuthorizedException("Usuário não encontrado!");
        }

        List<MovieListResponse> list = userMovieRepository.findAllMovieByUser(user.get().getId());

        if(list == null) {
            throw new RuntimeException("Nenhum filme assistido");
        }

        return list;
    }
}
