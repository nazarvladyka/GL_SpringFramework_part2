package com.nazarvladyka.guessNumber.service;

import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameManager {
    private Random random = new Random();
    private String message;

    public void isGameWon(String num) {
        int number = random.nextInt(2);
        int guess = Integer.parseInt(num);

        message = (guess == number) ? "Congrats, you win!" : "Sorry, but you lose(";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRandom(Random random) {
        this.random = random;
    }
}