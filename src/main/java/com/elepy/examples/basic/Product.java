package com.elepy.examples.basic;

import com.elepy.annotations.Number;
import com.elepy.annotations.*;
import com.elepy.models.TextType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;


@RestModel(name = "Products", slug = "/products")//The only necessary annotation for Elepy
@JsonIgnoreProperties(ignoreUnknown = true) //You must have this annotated if you use generated fields.
public class Product {

    @Identifier // All elepy models must have atleast 1 identifying field. By default it can be a 'String productId;'
    @PrettyName("Product ID") // A nice name to be used in Elepy error messages and such
    @JsonProperty("productId")
    private String productId;


    @PrettyName("Short Description")
    @Text(value = TextType.TEXTAREA, maximumLength = 100) //Textarea with a maximum of 100 characters

    //How elepy orders fields. By default all fields have a default of 0. negative fields don't get shown in the main admin table
    @Importance(-5)
    private String shortDescription;

    @PrettyName("Long Description")
    @Text(TextType.HTML)//WYSIWYG editor
    @Importance(-10)
    private String htmlDescription;

    @PrettyName("Product Name")
    @Required // All products must have a name
    @Uneditable // You can't edit the product's name after it has been set
    @Unique // Product  names must be unique
    private String name;

    @PrettyName("Product Price")
    @Number(minimum = 0)
    private BigDecimal price;

    @PrettyName("Amount of stock left")
    @Number(minimum = 0)
    private int stockLeft;

    @PrettyName("Amount sold")
    @Number(minimum = 0)
    private int amountSold;

    @Generated
    @JsonProperty("revenue")
    //Automatically generate the revenue of a product and display it in Elepy
    public BigDecimal getRevenue() {
        return price.multiply(BigDecimal.valueOf(amountSold));
    }

    //Getters and Setters. I like to use Lombok to automate this :D

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStockLeft() {
        return stockLeft;
    }

    public void setStockLeft(int stockLeft) {
        this.stockLeft = stockLeft;
    }

    public int getAmountSold() {
        return amountSold;
    }

    public void setAmountSold(int amountSold) {
        this.amountSold = amountSold;
    }
}
