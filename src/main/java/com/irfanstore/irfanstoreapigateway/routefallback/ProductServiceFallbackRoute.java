package com.irfanstore.irfanstoreapigateway.routefallback;

import com.irfanstore.irfanstoreapigateway.routefallback.fallbackdto.ProductPriceDto;
import com.irfanstore.irfanstoreapigateway.routefallback.fallbackdto.ProductResponseDto;
import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
public class ProductServiceFallbackRoute implements ZuulFallbackProvider {
    @Override
    public String getRoute() {
        String routeId;
        routeId = "product-service";   //for product service

        return routeId;
    }

    @Override
    public ClientHttpResponse fallbackResponse() {
        return new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }

            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }

            @Override
            public void close() {

            }

            @Override
            public InputStream getBody() throws IOException {
                ProductResponseDto productResponseDto = new ProductResponseDto();
                ProductPriceDto productPriceDto = new ProductPriceDto();
                productResponseDto.setProductPrice(productPriceDto);
                return new ByteArrayInputStream(productResponseDto.toString().getBytes());
            }

            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
        };
    }
}

