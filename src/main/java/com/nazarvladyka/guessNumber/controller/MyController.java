package com.nazarvladyka.guessNumber.controller;

import com.nazarvladyka.guessNumber.service.GameManager;
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

    private final GameManager gameManager;

    @Autowired
    public MyController(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> play(@PathVariable String number) {
        gameManager.isGameWon(number);
        GameResponse response = new GameResponse(gameManager);

        return new ResponseEntity<>(response.getJson(), response.getResponseHeaders(), HttpStatus.OK);
    }
}