package com.ats.plane_microservice.repository;

import com.ats.plane_microservice.entity.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface PlaneRepository extends JpaRepository<Plane,String> {


}
