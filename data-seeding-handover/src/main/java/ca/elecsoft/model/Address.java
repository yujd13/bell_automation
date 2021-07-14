package ca.elecsoft.model;

public class Address {
    public String streetNo;
    public String streetOne;
    public String streetTwo;
    public String city;
    public String postalCode;
    public String province;
    public String nearestIntersection;
    public String mapLink;

    public Address() {
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public String getStreetOne() {
        return streetOne;
    }

    public void setStreetOne(String streetOne) {
        this.streetOne = streetOne;
    }

    public String getStreetTwo() {
        return streetTwo;
    }

    public void setStreetTwo(String streetTwo) {
        this.streetTwo = streetTwo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getNearestIntersection() {
        return nearestIntersection;
    }

    public void setNearestIntersection(String nearestIntersection) {
        this.nearestIntersection = nearestIntersection;
    }

    public String getMapLink() {
        return mapLink;
    }

    public void setMapLink(String mapLink) {
        this.mapLink = mapLink;
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetNo='" + streetNo + '\'' +
                ", streetOne='" + streetOne + '\'' +
                ", streetTwo='" + streetTwo + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", province='" + province + '\'' +
                ", nearestIntersection='" + nearestIntersection + '\'' +
                ", mapLink='" + mapLink + '\'' +
                '}';
    }
}
