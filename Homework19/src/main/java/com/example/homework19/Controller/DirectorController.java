package com.example.homework19.Controller;

import com.example.homework19.Model.Director;
import com.example.homework19.Service.DirectorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/directors")
@AllArgsConstructor
public class DirectorController {
    
    private final DirectorService directorService;


    @GetMapping("")
    public ResponseEntity getDirector(){
        List<Director> Directors= directorService.getDirectors();

        return ResponseEntity.status(200).body(Directors);
    }


    @PostMapping("")
    public ResponseEntity addDirector(@Valid @RequestBody Director Director){
        directorService.addDirector(Director);
        return ResponseEntity.status(200).body("Director has been added Successfully");
    }


    @PutMapping("/{id}")
    public ResponseEntity updateDirector(@PathVariable Integer id, @Valid @RequestBody Director Director){

        directorService.updateDirector(id,Director);
        return ResponseEntity.status(200).body("Director has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteDirector(@PathVariable Integer id){
        directorService.deleteDirector(id);
        return ResponseEntity.status(200).body("Director has been deleted Successfully");
    }
    
    
}
