package com.nazarvladyka.guessNumber.wire;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.nazarvladyka.guessNumber.service.GameManager;
import org.springframework.http.HttpHeaders;

public class GameResponse {
    private HttpHeaders responseHeaders;
    private String json;

    public GameResponse(GameManager gameManager) {
        responseHeaders = new HttpHeaders();
        convert(gameManager);
    }

    private void convert(GameManager gameManager) {
        responseHeaders.add("Content-Type", "application/json;charset=UTF-8");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        try {
            json = ow.writeValueAsString(gameManager);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public HttpHeaders getResponseHeaders() {
        return responseHeaders;
    }

    public String getJson() {
        return json;
    }
}