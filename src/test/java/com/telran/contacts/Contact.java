package com.telran.contacts;

public class Contact {
    private String name;
    private String lastName;
    private String tel;
    private String email;
    private String email1;
    private String city;
    private String country;

    public Contact setName(String name) {
        this.name = name;
        return this;
    }

    public Contact setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Contact setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public Contact setEmail(String email) {
        this.email = email;
        return this;
    }

    public Contact setEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public Contact setCity(String city) {
        this.city = city;
        return this;
    }

    public Contact setCountry(String country) {
        this.country = country;
        return this;
    }



    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTel() {
        return tel;
    }

    public String getEmail() {
        return email;
    }

    public String getEmail1() {
        return email1;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
