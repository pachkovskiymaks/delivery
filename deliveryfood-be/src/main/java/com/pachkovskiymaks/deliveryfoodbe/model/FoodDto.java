package com.pachkovskiymaks.deliveryfoodbe.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
    private Long id;
    private BigDecimal price;
    private String name;
    private String image;
}
