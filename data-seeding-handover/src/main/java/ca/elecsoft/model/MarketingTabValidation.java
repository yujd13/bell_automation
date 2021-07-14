package ca.elecsoft.model;

public class MarketingTabValidation {
    public String source; //opportunity overview
    public String program; // opportunity overview
    public String creditDate;
    public String time_zone;
    public String firstName; //Lead fName
    public String lastName; // Lead lName
    public String streetNoOne; //opportunity address tab
    public String streetOne;// opportunity address tab
    public String city; // opportunity address tab
    public String postalCode; // opportunity address tab
    public String phone;
    public String email;

    public String getB1Number() {
        return B1Number;
    }

    public void setB1Number(String b1Number) {
        B1Number = b1Number;
    }

    public String getMobileTelephone() {
        return MobileTelephone;
    }

    public void setMobileTelephone(String mobileTelephone) {
        MobileTelephone = mobileTelephone;
    }

    public String getMobileAccount() {
        return MobileAccount;
    }

    public void setMobileAccount(String mobileAccount) {
        MobileAccount = mobileAccount;
    }

    public String B1Number;
    public String MobileTelephone;
    public String MobileAccount;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String phone2;
    public String dob;
    public String province;
    public String country;

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return "MarketingTabValidation{" +
                "source='" + source + '\'' +
                ", program='" + program + '\'' +
                ", creditDate='" + creditDate + '\'' +
                ", time_zone='" + time_zone + '\'' +
                ", firstName='" + firstName + '\'' +
                ", streetNoOne='" + streetNoOne + '\'' +
                ", lastName='" + lastName + '\'' +
                ", streetOne='" + streetOne + '\'' +
                ", city='" + city + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", phone='" + phone + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", dob='" + dob + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public MarketingTabValidation() {
    }


    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(String creditDate) {
        this.creditDate = creditDate;
    }

    public String getTime_zone() {
        return time_zone;
    }

    public void setTime_zone(String time_zone) {
        this.time_zone = time_zone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getStreetNoOne() {
        return streetNoOne;
    }

    public void setStreetNoOne(String streetNoOne) {
        this.streetNoOne = streetNoOne;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetOne() {
        return streetOne;
    }

    public void setStreetOne(String streetOne) {
        this.streetOne = streetOne;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
