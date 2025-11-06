package com.practice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductDto {
    @JsonProperty("product_id")
    private Long id;
    @JsonProperty("product_name")
    private String name;
    @JsonProperty("product_price")
    private Double price;
}
