package com.ats.schedule_microservice.utils;

public class IdGenerator {

        private static final String PREFIX = "S";
        private static final int MAX_ID = 9999;
        private static int currentId = 0;

        public static String generateId() {
            if (currentId >= MAX_ID) {
                throw new IllegalStateException("Maximum ID limit reached");
            }

            currentId++;
            return String.format("%s%04d", PREFIX, currentId);
        }

        public static void setCurrentId(String lastId) {
            if (lastId != null && lastId.matches(PREFIX + "\\d{4}")) {
                currentId = Integer.parseInt(lastId.substring(1)) - 1;
            }
        }
    }

