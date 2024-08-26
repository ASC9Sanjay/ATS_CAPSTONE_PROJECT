package com.ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class TravelInfoRequest {

        private String email;
        private String password;
        private int noOfSeats;
        private String source;
        private String destination;
        private String dateTime;

        // Getters and setters

}
