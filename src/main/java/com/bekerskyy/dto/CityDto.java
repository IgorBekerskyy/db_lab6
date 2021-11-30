package com.bekerskyy.dto;

public class CityDto {


    private int id;


    private String name;


    private String region_name;

    public CityDto(int id, String name, String region_name) {
        this.id = id;
        this.name = name;
        this.region_name = region_name;
    }

    public CityDto(String name, String region_name) {
        this(-1, name, region_name);

    }

    public CityDto() {

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

    public String getRegion_name() {
        return region_name;
    }

    public void setRegion_name(String region_name) {
        this.region_name = region_name;
    }


}
