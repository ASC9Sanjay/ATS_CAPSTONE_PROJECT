package com.ats.plane_microservice.service;
import com.ats.plane_microservice.entity.Plane;
import com.ats.plane_microservice.model.PlaneDTO;
import com.ats.plane_microservice.repository.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneServiceRepoImpl implements PlaneServiceRepo{

    private final PlaneRepository planeRepository;

    @Autowired
    PlaneServiceRepoImpl(PlaneRepository plane){
        this.planeRepository = plane;
    }

    @Override
    public PlaneDTO getPlaneById(String planeId) {
        // create dto
        // transfer dto
        Plane planeDetailFromDB = planeRepository.findById(planeId).get();
        PlaneDTO planeDTO = PlaneDTO.getInstance();
        planeDTO.setId(planeDetailFromDB.getId());
        planeDTO.setCapacity(planeDetailFromDB.getCapacity());
        planeDTO.setPlaneName(planeDetailFromDB.getPlaneName());
        planeDTO.setAirwaysName(planeDetailFromDB.getAirwaysName());
        return planeDTO;
    }

    @Override
    public String createPlane(PlaneDTO planeDetailFromUser) {
        Plane plane = Plane.getInstance();
        plane.setId(planeDetailFromUser.getId());
        plane.setPlaneName(planeDetailFromUser.getPlaneName());
        plane.setCapacity(planeDetailFromUser.getCapacity());
        plane.setAirwaysName(planeDetailFromUser.getAirwaysName());
        planeRepository.save(plane);
        return "successfully created " ;
    }

    @Override
    public String deletePlane(PlaneDTO planeDetailToBeDeleted) {
        Plane plane = Plane.getInstance();
        plane.setId(planeDetailToBeDeleted.getId());
        plane.setCapacity(planeDetailToBeDeleted.getCapacity());
        plane.setPlaneName(planeDetailToBeDeleted.getPlaneName());
        plane.setAirwaysName(planeDetailToBeDeleted.getAirwaysName());
        planeRepository.delete(plane);
        return "successfully deleted";
    }
}
