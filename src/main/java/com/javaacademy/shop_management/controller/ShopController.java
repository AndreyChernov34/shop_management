package com.javaacademy.shop_management.controller;

import com.javaacademy.shop_management.dto.StatusDto;
import com.javaacademy.shop_management.service.ShopService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Shop Controller", description = "Контроллер для работы с магазинами")
public class ShopController {
    private final ShopService shopService;

    @GetMapping("/shop/status")
    public ResponseEntity<List<StatusDto>> getShopStatus() throws IOException {
        return ResponseEntity.ok(shopService.getShopStatus());
    }

}
