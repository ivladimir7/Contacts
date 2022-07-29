package com.telran.contacts.models;

public class Contact {
    private String name;
    private String lastName;
    private String tel;
    private String email;
    private String city;
    private String description;

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

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }

    public Contact setCity(String city) {
        this.city = city;
        return this;
    }

    public Contact setDescription(String description) {
        this.description = description;
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

    public String getCity() {
        return city;
    }

    public String getDescription() {
        return description;
    }
}
