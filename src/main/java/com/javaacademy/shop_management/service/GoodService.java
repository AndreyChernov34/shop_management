package com.javaacademy.shop_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_management.dto.GoodDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class GoodService {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Value("${server.shop.shop_seven.good.url}")
    private String urlSeven;

    @Value("${server.shop.shop_nine.good.url}")
    private String urlNine;

    @Operation(summary = "Обновить цену товара", description = "Обновляет цену указанного товара")
    public void updateGoodPriceInShop(GoodDto goodDto) throws IOException {
        updateFoodPriceRequest(goodDto, urlSeven);
        updateFoodPriceRequest(goodDto, urlNine);
    }

    @Operation(summary = "Обновить цену товара", description = "Метод запроса на изменение цен в заданном приложении")
    private void updateFoodPriceRequest(GoodDto goodDto, String goodUrl) throws IOException {
        log.info(goodDto.toString() + "  - " + goodUrl);
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request request = new Request.Builder()
                    .patch(RequestBody.create(objectMapper.writeValueAsBytes(goodDto)))
                    .url(goodUrl)
                    .addHeader("Content-Type", "application/json")
                    .build();
            okHttpClient.newCall(request).execute().close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
