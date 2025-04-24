package co.edu.umanizales.myfirstap.controller;

import co.edu.umanizales.myfirstap.model.Location;
import co.edu.umanizales.myfirstap.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path ="/Location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping(path = "/code/{code}")
    public Location getLocationByCode(@PathVariable String code){
        return locationService.getLocationByCode(code);
    }

    @GetMapping(path ="framen/{code}" )
    public List<Location> getFramenCode(@PathVariable String code) {
      return locationService.getFramenCode(code);
    }


    @GetMapping(path = "/description/{desc}")
    public ArrayList<Location> getLocalizationByDesc(@PathVariable String desc){
        return locationService.getLocationByDesc(desc);
    }

    @GetMapping(path = "/initial_letters/{letters}")
    public ArrayList<Location> getLocationByInitialLetters(@PathVariable String letters){
        return locationService.getLocationByInitials(letters);
    }
    @GetMapping(path = "/initial_end_letters/{letters}")
    public ArrayList<Location> getLocationByInitialAndEndDate(@PathVariable String letters){
        return locationService.getLocationByKeyLetters(letters);
    }



}

