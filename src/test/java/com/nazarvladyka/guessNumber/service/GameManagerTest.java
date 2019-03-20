package com.nazarvladyka.guessNumber.service;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;

import static org.mockito.Mockito.when;

public class GameManagerTest {
    private static GameManager gameManager;
    static Random randomNumberMock = Mockito.mock(Random.class);

    @BeforeClass
    public static void setUp() {
        gameManager = new GameManager();
    }

    @Test
    public void isGameWon() {
        //given
        String guess = "0";
        when(randomNumberMock.nextInt()).thenReturn(0);
        gameManager.setRandom(randomNumberMock);

        //when
        gameManager.isGameWon(guess);

        //then
        Assert.assertEquals("Congrats, you win!", gameManager.getMessage());
    }
}