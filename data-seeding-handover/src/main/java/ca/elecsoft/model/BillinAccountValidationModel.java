package ca.elecsoft.model;

public class BillinAccountValidationModel {
    public String cdeal_id; // AF
    public String deal_id; // AF
    public String userId; // CRMDT
    public String acc_no; // 395848
    public String s_lang; // 8
    public String sub_type; // res
    public String cur; // curr
    public String lastName; // Last Name
    public String firstName; // First Name
    public String city; // Toronto
    public String zip; // M1M 1W8
    public String state; // ON
    public String phone; //Home Phone
    public String phone2; // Mobile Phone
    public String cross_street;
    public String country; // CA
    public String email; // ai@gmail.com
    public String street1;
    public String street1no1;
    public String province;

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet1no1() {
        return street1no1;
    }

    public void setStreet1no1(String street1no1) {
        this.street1no1 = street1no1;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCdeal_id() {
        return cdeal_id;
    }

    public void setCdeal_id(String cdeal_id) {
        this.cdeal_id = cdeal_id;
    }

    public String getDeal_id() {
        return deal_id;
    }

    public void setDeal_id(String deal_id) {
        this.deal_id = deal_id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAcc_no() {
        return acc_no;
    }

    public void setAcc_no(String acc_no) {
        this.acc_no = acc_no;
    }

    public String getS_lang() {
        return s_lang;
    }

    public void setS_lang(String s_lang) {
        this.s_lang = s_lang;
    }

    public String getSub_type() {
        return sub_type;
    }

    public void setSub_type(String sub_type) {
        this.sub_type = sub_type;
    }

    public String getCur() {
        return cur;
    }

    public void setCur(String cur) {
        this.cur = cur;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public String getCross_street() {
        return cross_street;
    }

    public void setCross_street(String cross_street) {
        this.cross_street = cross_street;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "BillinAccountValidationModel{" +
                "cdeal_id='" + cdeal_id + '\'' +
                ", deal_id='" + deal_id + '\'' +
                ", userId='" + userId + '\'' +
                ", acc_no='" + acc_no + '\'' +
                ", s_lang='" + s_lang + '\'' +
                ", sub_type='" + sub_type + '\'' +
                ", cur='" + cur + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", state='" + state + '\'' +
                ", phone='" + phone + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", cross_street='" + cross_street + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
