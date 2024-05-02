package org.projet.projetWeb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GeocodeResponse {
    private String address;
    private double latitude;
    private double longitude;

    // Constructor, getters, and setters

    // Default constructor
    public GeocodeResponse() {
    }

    // Parameterized constructor
    public GeocodeResponse(String address, double latitude, double longitude) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    @JsonProperty("position")
    public void setPosition(Position position) {
        this.latitude = position.getLatitude();
        this.longitude = position.getLongitude();
    }

    // Other getters and setters as needed

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    // Nested class to represent position
    private static class Position {
        private double lat;
        private double lon;

        // Default constructor
        public Position() {
        }

        // Parameterized constructor
        public Position(double lat, double lon) {
            this.lat = lat;
            this.lon = lon;
        }

        // Getters and setters for latitude and longitude
        public double getLatitude() {
            return lat;
        }

        public void setLatitude(double lat) {
            this.lat = lat;
        }

        public double getLongitude() {
            return lon;
        }

        public void setLongitude(double lon) {
            this.lon = lon;
        }
    }
}
