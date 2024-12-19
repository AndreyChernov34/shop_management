package com.javaacademy.shop_management.controller;

import com.javaacademy.shop_management.dto.GoodDto;
import com.javaacademy.shop_management.service.GoodService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@Tag(name = "Good Controller", description = "Контроллер для работы с товарами")
public class GoodController {
    private final GoodService goodService;

    @PatchMapping("/shop/good")
    @Operation(tags = "Обновление цен в магазинах")
    public void updateGoodPrice(@RequestBody GoodDto goodDto) throws IOException {
        goodService.updateGoodPriceInShop(goodDto);
    }
}
