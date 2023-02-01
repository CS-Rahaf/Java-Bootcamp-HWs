package com.example.homework19.Repository;

import com.example.homework19.Model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Movie findMovieById(Integer id);

    public Movie findMovieByName(String name);

    public List<Movie> findMovieByDirectorId(Integer id);

    @Query(value = "select u from Movie u where u.rating>=?1")
    public List<Movie> findMovieAboveRating(int rate);

    public List<Movie> findMovieByGenre(String genre);

}
