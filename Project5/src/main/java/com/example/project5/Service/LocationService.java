package com.example.project5.Service;


import com.example.project5.Exception.ApiException;
import com.example.project5.Model.Location;
import com.example.project5.Model.Store;
import com.example.project5.Repository.LocationRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LocationService {


    private final LocationRepository locationRepository;
    private final StoreService storeService;


    public List<Location> getLocations(){
        return locationRepository.findAll();
    }


    public Location getLocation(Integer id){
        Location Location = locationRepository.findLocationById(id);
        if(Location==null){
            throw new ApiException("Location not found");
        }

        return Location;
    }
    public void addLocation(ObjectNode objectNode){
        Integer storeId= objectNode.get("storeId").asInt();
        Store store = storeService.getStore(storeId);
        if(store.getLocation() != null){
            throw new ApiException("A different object with the same identifier value was already associated with the store");
        }

        String area = objectNode.get("area").asText();
        String street = objectNode.get("street").asText();

        Location location = new Location(null, area, street, store);
        locationRepository.save(location);
    }

    public void updateLocation(Integer id, Location location){
        Location currentLocation = locationRepository.findLocationById(id);
        if(currentLocation==null){
            throw new ApiException("Location not found");
        }

        location.setId(currentLocation.getId());
        locationRepository.save(location);
    }

    public void deleteLocation(Integer id){
        Location currentLocation = locationRepository.findLocationById(id);

        if(currentLocation == null){
            throw new ApiException("Location not found");
        }
        locationRepository.deleteById(id);
    }
}
