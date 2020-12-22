package com.bekerskyy.dto;


import com.bekerskyy.DAO.implementation.BonusAccountDAO;

public class BonusAccountDto {

    private Integer id;
    private String type;
    private String promocode;

    public BonusAccountDto(Integer id, String type, String promocode) {
        this.id = id;
        this.type = type;
        this.promocode = promocode;
    }

    public BonusAccountDto(String type, String promocode) {
        this.type = type;
        this.promocode = promocode;
    }

    public BonusAccountDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPromocode() {
        return promocode;
    }

    public void setPromocode(String promocode) {
        this.promocode = promocode;
    }
}
