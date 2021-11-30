package com.bekerskyy.dto;

public class GoodDto {


    private int id;


    private String name;


    private String firm;


    private String description;


    private String guarantee_in_months;


    private String response;


    private Boolean in_stock;


    public GoodDto(int id, String name, String firm, String description, String guarantee_in_months,
                String response, Boolean in_stock ) {
        this.id = id;
        this.name = name;
        this.firm = firm;
        this.description = description;
        this.guarantee_in_months = guarantee_in_months;
        this.response = response;
        this.in_stock = in_stock;
    }

    public GoodDto(String name, String firm, String description, String guarantee_in_months,
                String response, Boolean in_stock) {
        this(-1, name, firm, description, guarantee_in_months, response, in_stock);
    }

    public GoodDto() {

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

    public String getFirm() {
        return firm;
    }
    public void setFirm(String firm) {
        this.firm = firm;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGuarantee_in_months() {
        return guarantee_in_months;
    }

    public void setGuarantee_in_months(String guarantee_in_months) {
        this.guarantee_in_months = guarantee_in_months;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Boolean getIn_Stock() {
        return in_stock;
    }

    public void setIn_stock(Boolean in_stock) {
        this.in_stock = in_stock;
    }

}
