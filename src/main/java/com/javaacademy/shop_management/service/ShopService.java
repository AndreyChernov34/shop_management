package com.javaacademy.shop_management.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaacademy.shop_management.dto.StatusDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ShopService {
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Value("${server.shop.shop_seven.url}")
    private String url_seven;

    @Value("${server.shop.shop_nine.url}")
    private String url_nine;

    public List<StatusDto> getShopStatus() throws IOException {
        List<StatusDto> result = List.of(getRequestShopStatus(url_seven)
                , getRequestShopStatus(url_nine));
        log.info(result.toString());
        return result;
    }

    public StatusDto getRequestShopStatus(String shop_url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().get().url(shop_url).build();
        log.info(request.toString());
        String responseBody = okHttpClient.newCall(request).execute().body().string();
        log.info(responseBody);
        try {
            StatusDto statusDto = objectMapper.readValue(responseBody, StatusDto.class);
            log.info(statusDto.toString());
            return statusDto;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
