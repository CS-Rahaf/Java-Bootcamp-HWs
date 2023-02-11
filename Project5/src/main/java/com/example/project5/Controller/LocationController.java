package com.example.project5.Controller;

import com.example.project5.Model.Location;
import com.example.project5.Service.LocationService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("apis/v1/locations")
public class LocationController {


    private final LocationService locationService;


    @GetMapping("")
    public ResponseEntity getLocations(){
        List<Location> locations= locationService.getLocations();

        return ResponseEntity.status(200).body(locations);
    }

    //First required endpoint
    @GetMapping("/{id}")
    public ResponseEntity getLocation(@PathVariable Integer id){
        Location locations= locationService.getLocation(id);

        return ResponseEntity.status(200).body(locations);
    }

    @PostMapping("")
    public ResponseEntity addLocation(@Valid @RequestBody ObjectNode objectNode) {
        locationService.addLocation(objectNode);
        return ResponseEntity.status(200).body("Address has been added Successfully");

    }


    @PutMapping("/{id}")
    public ResponseEntity updateLocation(@PathVariable Integer id, @Valid @RequestBody Location location){

        locationService.updateLocation(id,location);
        return ResponseEntity.status(200).body("Location has been updated Successfully");
    }


    @DeleteMapping ("/{id}")
    public ResponseEntity deleteLocation(@PathVariable Integer id){
        locationService.deleteLocation(id);
        return ResponseEntity.status(200).body("Location has been deleted Successfully");
    }
    
    
}
