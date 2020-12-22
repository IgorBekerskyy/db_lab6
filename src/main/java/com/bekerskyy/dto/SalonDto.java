package com.bekerskyy.dto;

public class SalonDto {


    private int id;

    private String name;


    private String phone;


    private String salon_head;

    private String city_id;

    private String street_adress;

    public SalonDto(int id, String name, String phone, String salon_head, String city_id, String street_adress) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.salon_head = salon_head;
        this.city_id = city_id;
        this.street_adress=street_adress;
    }

    public SalonDto(String name, String phone, String salon_head, String city_id, String street_adress) {
        this(-1, name, phone, salon_head, city_id, street_adress);
    }
    public SalonDto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalon_head() {
        return salon_head;
    }

    public void setSalon_head(String salon_head) {
        this.salon_head = salon_head;
    }

    public String getCity_id() {
        return city_id;
    }

    public void setCity_id(String city_id) {
        this.city_id = city_id;
    }

    public String getStreet_adress() {
        return street_adress;
    }

    public void setStreet_adress(String street_adress) {
        this.street_adress = street_adress;
    }
}
