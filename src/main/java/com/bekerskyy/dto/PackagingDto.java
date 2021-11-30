package com.bekerskyy.dto;

public class PackagingDto {


    private int id;


    private String name;


    private Boolean for_a_gift;

    public PackagingDto(int id, String name, Boolean for_a_gift) {
        this.id = id;
        this.name = name;
        this.for_a_gift = for_a_gift;
    }

    public PackagingDto(String name, Boolean for_a_gift) {
        this(-1, name, for_a_gift);

    }

    public PackagingDto() {

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

    public Boolean getFor_a_gift() {
        return for_a_gift;
    }

    public void setFor_a_gift(Boolean for_a_gift) {
        this.for_a_gift = for_a_gift;
    }
}
