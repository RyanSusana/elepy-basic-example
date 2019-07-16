package com.elepy.examples.basic;

import com.elepy.annotations.Number;
import com.elepy.annotations.*;
import com.elepy.models.TextType;

import java.math.BigDecimal;
import java.util.Date;

@RestModel(slug = "/products", name = "Products")
public class Product {

    @Identifier
    private String id;

    @Number(minimum = 0)
    private BigDecimal price;

    @Unique
    @Searchable
    @PrettyName("Product Name")
    private String name;

    @DateTime(maximumDate = "2050-01-01")
    private Date expirationDate;

    @Text(TextType.TEXTAREA)
    private String shortDescription;

    @Text(TextType.HTML)
    @PrettyName("This is a detailed description of the Product")
    private String longDescription;


    // Getters and setters. I like to use Project Lombok to automate this :D


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}