package com.ats.plane_microservice.service;

import com.ats.plane_microservice.model.PlaneDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneServiceRepo {
    PlaneDTO getPlaneById(String planeId);
    String createPlane(PlaneDTO planeDetailFromUser);
    String deletePlane(PlaneDTO planeDetailToBeDeleted);
}
