package org.projet.projetWeb.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GeocodeResponse {

    private Summary summary;
    private List<Result> results;

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }



    public static class Summary {
        private String query;
        private String queryType;
        private int queryTime;
        private int numResults;
        private int offset;
        private int totalResults;
        private int fuzzyLevel;

        // Getters and setters for summary fields
    }

    public static class Result {
        private String type;
        private String id;
        private double score;
        private MatchConfidence matchConfidence;
        private Address address;
        private Position position;
        private Viewport viewport;
        private AddressRanges addressRanges;

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }

        public Position getPosition() {
            return position;
        }

        public void setPosition(Position position) {
            this.position = position;
        }

    }

    public static class MatchConfidence {
        private double score;

        // Getters and setters for matchConfidence field
    }

    public static class Address {
        private String streetNumber;
        private String streetName;
        private String municipality;
        private String countrySubdivision;
        private String countrySubdivisionName;
        private String countrySubdivisionCode;
        private String postalCode;
        private String extendedPostalCode;
        private String countryCode;
        private String country;
        private String countryCodeISO3;
        private String freeformAddress;
        private String localName;

    }

    public static class Position {
        private double lat;
        private double lon;

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLon() {
            return lon;
        }

        public void setLon(double lon) {
            this.lon = lon;
        }
    }

    public static class Viewport {
        private Position topLeftPoint;
        private Position btmRightPoint;

        // Getters and setters for viewport fields
    }

    public static class AddressRanges {
        private String rangeLeft;
        private String rangeRight;
        private Position from;
        private Position to;

        // Getters and setters for addressRanges fields
    }
}
