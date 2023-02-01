package com.example.homework19.Service;

import com.example.homework19.Exception.ApiException;
import com.example.homework19.Model.Movie;
import com.example.homework19.Repository.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final DirectorService directorService;

    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }

    public void addMovie(Movie Movie){
        movieRepository.save(Movie);
    }
    public void updateMovie(Integer id, Movie Movie){
        Movie currentMovie = movieRepository.findMovieById(id);
        if(currentMovie==null){
            throw new ApiException("Movie not found");
        }

        Movie.setId(currentMovie.getId());
        movieRepository.save(Movie);
    }

    public void deleteMovie(Integer id){
        Movie currentMovie = movieRepository.findMovieById(id);

        if(currentMovie == null){
            throw new ApiException("Movie not found");
        }
        movieRepository.deleteById(id);
    }

    public Movie getByName(String name){
        Movie movie = movieRepository.findMovieByName(name);
        if(movie == null){
            throw new ApiException("Movie not found");
        }
        return movie;
    }

    public int getMovieDuration(String movieName){
        Movie movie = movieRepository.findMovieByName(movieName);
        if(movie == null){
            throw new ApiException("Movie not found");
        }
        return movie.getDuration();
    }

    public String getDirectorName(String movieName){
        Movie movie = movieRepository.findMovieByName(movieName);
        if(movie == null){
            throw new ApiException("Movie not found");
        }
        Integer directorId= movie.getDirectorId();
        String directorName= directorService.getDirector(directorId).getName();
        return directorName;
    }

    public List<Movie> getMovieByDirector(Integer directorId){
        List<Movie> movies = movieRepository.findMovieByDirectorId(directorId);
        return movies;
    }

    public int getMovieRating(String movieName){
        Movie movie = movieRepository.findMovieByName(movieName);
        if(movie == null){
            throw new ApiException("Movie not found");
        }
        return movie.getRating();
    }

    public List<Movie> getMoviesAboveRating(int rating){
        List<Movie> movies = movieRepository.findMovieAboveRating(rating);

        return movies;
    }

    public List<Movie> getMoviesByGenre(String genre){
        List<Movie> movies = movieRepository.findMovieByGenre(genre);
        return movies;
    }

}
