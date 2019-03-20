package com.nazarvladyka.guessNumber.controller;

import com.nazarvladyka.guessNumber.service.GameService;
import com.nazarvladyka.guessNumber.wire.GameResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    private final GameService gameService;

    @Autowired
    public MyController(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> play(@PathVariable String number) {
        gameService.isGameWon(number);
        GameResponse response = new GameResponse(gameService);

        return new ResponseEntity<>(response.getJson(), response.getResponseHeaders(), HttpStatus.OK);
    }
}