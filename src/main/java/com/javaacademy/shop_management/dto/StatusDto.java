package com.javaacademy.shop_management.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Магазин ДТО")
public class StatusDto {
    @Schema(description = "Название магазина")
    private String name;
    @Schema(description = "Статус магазина")
    private String shopStatus;
    @JsonProperty("time_open")
    @Schema(description = "Время открытия")
    private String timeOpen;
    @JsonProperty("time_close")
    @Schema(description = "Время закрытия")
    private String timeClose;
}
