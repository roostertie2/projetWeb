package org.projet.projetWeb.model;

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

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public static class Summary {
        private String query;
        private String queryType;
        private int queryTime;
        private int numResults;
        private int offset;
        private int totalResults;
        private int fuzzyLevel;

        public String getQuery() {
            return query;
        }

        public void setQuery(String query) {
            this.query = query;
        }

        public String getQueryType() {
            return queryType;
        }

        public void setQueryType(String queryType) {
            this.queryType = queryType;
        }

        public int getQueryTime() {
            return queryTime;
        }

        public void setQueryTime(int queryTime) {
            this.queryTime = queryTime;
        }

        public int getNumResults() {
            return numResults;
        }

        public void setNumResults(int numResults) {
            this.numResults = numResults;
        }

        public int getOffset() {
            return offset;
        }

        public void setOffset(int offset) {
            this.offset = offset;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public int getFuzzyLevel() {
            return fuzzyLevel;
        }

        public void setFuzzyLevel(int fuzzyLevel) {
            this.fuzzyLevel = fuzzyLevel;
        }
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

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public MatchConfidence getMatchConfidence() {
            return matchConfidence;
        }

        public void setMatchConfidence(MatchConfidence matchConfidence) {
            this.matchConfidence = matchConfidence;
        }

        public Viewport getViewport() {
            return viewport;
        }

        public void setViewport(Viewport viewport) {
            this.viewport = viewport;
        }

        public AddressRanges getAddressRanges() {
            return addressRanges;
        }

        public void setAddressRanges(AddressRanges addressRanges) {
            this.addressRanges = addressRanges;
        }
    }

    public static class MatchConfidence {
        private double score;

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }
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

        public String getStreetNumber() {
            return streetNumber;
        }

        public void setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
        }

        public String getStreetName() {
            return streetName;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public String getMunicipality() {
            return municipality;
        }

        public void setMunicipality(String municipality) {
            this.municipality = municipality;
        }

        public String getCountrySubdivision() {
            return countrySubdivision;
        }

        public void setCountrySubdivision(String countrySubdivision) {
            this.countrySubdivision = countrySubdivision;
        }

        public String getCountrySubdivisionName() {
            return countrySubdivisionName;
        }

        public void setCountrySubdivisionName(String countrySubdivisionName) {
            this.countrySubdivisionName = countrySubdivisionName;
        }

        public String getCountrySubdivisionCode() {
            return countrySubdivisionCode;
        }

        public void setCountrySubdivisionCode(String countrySubdivisionCode) {
            this.countrySubdivisionCode = countrySubdivisionCode;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getExtendedPostalCode() {
            return extendedPostalCode;
        }

        public void setExtendedPostalCode(String extendedPostalCode) {
            this.extendedPostalCode = extendedPostalCode;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getCountryCodeISO3() {
            return countryCodeISO3;
        }

        public void setCountryCodeISO3(String countryCodeISO3) {
            this.countryCodeISO3 = countryCodeISO3;
        }

        public String getFreeformAddress() {
            return freeformAddress;
        }

        public void setFreeformAddress(String freeformAddress) {
            this.freeformAddress = freeformAddress;
        }

        public String getLocalName() {
            return localName;
        }

        public void setLocalName(String localName) {
            this.localName = localName;
        }
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

        public Position getTopLeftPoint() {
            return topLeftPoint;
        }

        public void setTopLeftPoint(Position topLeftPoint) {
            this.topLeftPoint = topLeftPoint;
        }

        public Position getBtmRightPoint() {
            return btmRightPoint;
        }

        public void setBtmRightPoint(Position btmRightPoint) {
            this.btmRightPoint = btmRightPoint;
        }
    }

    public static class AddressRanges {
        private String rangeLeft;
        private String rangeRight;
        private Position from;
        private Position to;

        public String getRangeLeft() {
            return rangeLeft;
        }

        public void setRangeLeft(String rangeLeft) {
            this.rangeLeft = rangeLeft;
        }

        public String getRangeRight() {
            return rangeRight;
        }

        public void setRangeRight(String rangeRight) {
            this.rangeRight = rangeRight;
        }

        public Position getFrom() {
            return from;
        }

        public void setFrom(Position from) {
            this.from = from;
        }

        public Position getTo() {
            return to;
        }

        public void setTo(Position to) {
            this.to = to;
        }
    }
}
