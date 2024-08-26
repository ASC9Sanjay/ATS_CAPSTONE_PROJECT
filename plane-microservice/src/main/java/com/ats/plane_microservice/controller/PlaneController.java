package com.ats.plane_microservice.controller;


import com.ats.plane_microservice.entity.Plane;
import com.ats.plane_microservice.model.PlaneDTO;
import com.ats.plane_microservice.repository.PlaneRepository;
import com.ats.plane_microservice.service.PlaneServiceRepo;
import com.ats.plane_microservice.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PlaneController {

    private final PlaneServiceRepo planeServiceRepo;

    @Autowired
    public PlaneController(PlaneServiceRepo planeServiceRepo) {
        this.planeServiceRepo = planeServiceRepo;
    }

    @PostMapping("/CreatePlane")
    public String createPlane(@RequestBody PlaneDTO planeDetailFromCilent){
        planeDetailFromCilent.setId(IdGenerator.generateId());
        return planeServiceRepo.createPlane(planeDetailFromCilent);
    }

    @GetMapping("/plane/{planeId}")
    public PlaneDTO getPlaneDetails(@PathVariable(value = "planeId") String planeId){
        return planeServiceRepo.getPlaneById(planeId);
    }

    @DeleteMapping("/deletePlane")
    public  String deletePlane(@RequestBody PlaneDTO planeDetailFromCilent){
        return planeServiceRepo.deletePlane(planeDetailFromCilent);
    }
}
