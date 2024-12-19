package com.javaacademy.shop_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_management.dto.StatusDto;
import lombok.RequiredArgsConstructor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class ShopService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Value("${server.shop.shop_seven.status.url}")
    private String urlSeven;

    @Value("${server.shop.shop_nine.status.url}")
    private String urlNine;

    public List<StatusDto> getShopStatus() throws IOException {
        List<StatusDto> statusDtoList = new ArrayList<StatusDto>();
        statusDtoList.add(getRequestShopStatus(urlSeven));
        statusDtoList.add(getRequestShopStatus(urlNine));
        return statusDtoList;
    }

    private StatusDto getRequestShopStatus(String shopUrl) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().get().url(shopUrl).build();
        try {
            Response response = okHttpClient.newCall(request).execute();
            if (response.isSuccessful() && response.body() != null) {
                return objectMapper.readValue(response.body().string(), StatusDto.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
