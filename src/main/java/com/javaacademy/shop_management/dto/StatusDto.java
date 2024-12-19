package com.javaacademy.shop_management.dto;

import lombok.Data;

@Data
public class StatusDto {
    private String name;
    private String shopStatus;
    private String time_open;
    private String time_close;
}
