package com.example.homework19.Controller;

import com.example.homework19.Model.Movie;
import com.example.homework19.Service.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;


    @GetMapping("")
    public ResponseEntity getMovie(){
        List<Movie> Movies= movieService.getMovies();

        return ResponseEntity.status(200).body(Movies);
    }


    @PostMapping("")
    public ResponseEntity addMovie(@Valid @RequestBody Movie Movie){
        movieService.addMovie(Movie);
        return ResponseEntity.status(200).body("Movie has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateMovie(@PathVariable Integer id, @Valid @RequestBody Movie Movie){

        movieService.updateMovie(id,Movie);
        return ResponseEntity.status(200).body("Movie has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteMovie(@PathVariable Integer id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie has been deleted Successfully");
    }

    @GetMapping("/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name){
        Movie movie= movieService.getByName(name);
        return ResponseEntity.status(200).body(movie);
    }

    @GetMapping("/{name}/duration")
    public ResponseEntity getMovieDuration(@PathVariable String name){
        int duration= movieService.getMovieDuration(name);
        return ResponseEntity.status(200).body("Movie's duration is: " + duration);
    }

    @GetMapping("/{name}/director")
    public ResponseEntity getMovieDirector(@PathVariable String name){
        String director= movieService.getDirectorName(name);
        return ResponseEntity.status(200).body("Movie's director is: " + director);
    }

    @GetMapping("/director/{id}/movies")
    public ResponseEntity getMoviesByDirector(@PathVariable Integer id){
        List<Movie> movies = movieService.getMovieByDirector(id);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/{name}/rating")
    public ResponseEntity getMovieRating(@PathVariable String name){
        int rating = movieService.getMovieRating(name);
        return ResponseEntity.status(200).body("Movie's rating is: " + rating);
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity getMoviesAboveRating(@PathVariable int rating){
        List<Movie> movies = movieService.getMoviesAboveRating(rating);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity getMovieByGenre(@PathVariable String genre){
        List<Movie> movies = movieService.getMoviesByGenre(genre);
        return ResponseEntity.status(200).body(movies);
    }

    
}
