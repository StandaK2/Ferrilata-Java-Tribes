package com.greenfox.javatribes.javatribes.restcontrollers;

import com.greenfox.javatribes.javatribes.model.Building;
import com.greenfox.javatribes.javatribes.repositories.BuildingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class BuildingController {

    @Autowired
    BuildingRepository buildingRepository;

    @PostMapping("/save")
    public ResponseEntity<Object> saveBuilding(@RequestBody Building building) {
        buildingRepository.save(building);
        return ResponseEntity.ok().body(building);
    }
}

