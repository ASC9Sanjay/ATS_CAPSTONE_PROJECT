package com.ats.plane_microservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PlaneDTO {

    private String id;
    private String planeName;
    private int capacity;
    private String airwaysName;


    PlaneDTO(){
    }

    public static PlaneDTO getInstance() {
        return new PlaneDTO();
    }

    @Override
    public String toString(){
        return "Plane{ id:"+this.id+", name:"+this.planeName+",capacity:"+this.capacity+",airwaysName:"+this.capacity+"};";
    }
}
