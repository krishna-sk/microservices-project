package com.krishna.model;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductModel {

    @NotNull(message = "Name can't be null")
    @NotBlank(message = "Name can't be blank")
    private String name;

    @NotNull(message = "Description can't be null")
    @NotBlank(message = "Description can't be blank")
    private String description;

    @Digits(integer = 6, fraction = 2, message = "price must be between 0 and 999999 with 2 precession")
    private BigDecimal price;
}