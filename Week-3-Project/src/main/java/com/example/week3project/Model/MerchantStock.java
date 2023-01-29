package com.example.week3project.Model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class MerchantStock {

    @NotEmpty(message = "The Id shouldn't be empty")
    @Size(min = 3, max = 3 , message = "Id length should be 3 characters")
    private String id;

    @NotEmpty(message = "The product id shouldn't be empty")
    @Size(min = 3, max = 3 , message = "The product id length should be 3 characters")
    private String productId;
    @NotEmpty(message = "The merchant id shouldn't be empty")
    @Size(min = 3, max = 3 , message = "The merchant id length should be 3 characters")
    private String merchantId;

    @NotNull(message = "The stock shouldn't be empty")
    @Min(value = 10, message = "Stock value should be at least 10")
    private int stock;

}
