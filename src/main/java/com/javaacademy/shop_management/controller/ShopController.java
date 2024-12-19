package com.javaacademy.shop_management.controller;

import com.javaacademy.shop_management.dto.StatusDto;
import com.javaacademy.shop_management.service.ShopService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import okhttp3.ResponseBody;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ShopController {
    private final ShopService shopService;


    @GetMapping("/shop/status")
    public ResponseEntity<List<StatusDto>> getShopStatus() throws IOException {
        List<StatusDto> result = shopService.getShopStatus();
        log.info(result.toString());
        return ResponseEntity.ok(result);
    }

}
