package com.javaacademy.shop_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Schema(description = "Продукт ДТО")
public class GoodDto {
    @Schema (description = "Название")
    private String name;
    @JsonProperty("new_price")
    @Schema(description = "Цена")
    private BigDecimal price;
}
