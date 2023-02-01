package com.example.homework19.Service;

import com.example.homework19.Exception.ApiException;
import com.example.homework19.Model.Director;
import com.example.homework19.Repository.DirectorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DirectorService {
    
    private final DirectorRepository directorRepository;

    public List<Director> getDirectors(){
        return directorRepository.findAll();
    }


    public Director getDirector(Integer id){
        Director director = directorRepository.findDirectorById(id);
        if(director==null){
            throw new ApiException("Director not found");
        }

        return director;
    }
    public void addDirector(Director Director){
        directorRepository.save(Director);
    }
    public void updateDirector(Integer id, Director Director){
        Director currentDirector = directorRepository.findDirectorById(id);
        if(currentDirector==null){
            throw new ApiException("Director not found");
        }

        Director.setId(currentDirector.getId());
        directorRepository.save(Director);
    }

    public void deleteDirector(Integer id){
        Director currentDirector = directorRepository.findDirectorById(id);

        if(currentDirector == null){
            throw new ApiException("Director not found");
        }
        directorRepository.deleteById(id);
    }
}
