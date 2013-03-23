package com.example.touristr.dto;

/**
 * Created with IntelliJ IDEA.
 * User: Maarten
 * Date: 23/03/13
 * Time: 11:51
 * To change this template use File | Settings | File Templates.
 */
public class SpotContact {
    private String name;
    private String personName;
    private String street;
    private String number;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
