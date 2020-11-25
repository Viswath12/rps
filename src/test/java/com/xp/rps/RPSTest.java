package com.xp.rps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPSTest {

    @Test
    void RockVsRock() {
        Result result = RPS.play(Throw.ROCK, Throw.ROCK);
        assertEquals(Result.DRAW, result);
    }

    @Test
    void PaperVsPaper() {
        Result result = RPS.play(Throw.PAPER, Throw.PAPER);
        assertEquals(Result.DRAW, result);
    }

    @Test
    void ScissorsVsScissors() {
        Result result = RPS.play(Throw.SCISSORS, Throw.SCISSORS);
        assertEquals(Result.DRAW, result);
    }

    @Test
    void RockVsPaper() {
        Result result = RPS.play(Throw.ROCK, Throw.PAPER);
        assertEquals(Result.P2_WINS, result);
    }

    @Test
    void PaperVsRock() {
        Result result = RPS.play(Throw.PAPER, Throw.ROCK);
        assertEquals(Result.P1_WINS, result);
    }

    @Test
    void RockVsScissors() {
        Result result = RPS.play(Throw.ROCK, Throw.SCISSORS);
        assertEquals(Result.P1_WINS, result);
    }

    @Test
    void ScissorsVsRock() {
        Result result = RPS.play(Throw.SCISSORS, Throw.ROCK);
        assertEquals(Result.P2_WINS, result);
    }

    @Test
    void ScissorsVsPaper() {
        Result result = RPS.play(Throw.SCISSORS, Throw.PAPER);
        assertEquals(Result.P1_WINS, result);
    }

    @Test
    void PaperVsScissors() {
        Result result = RPS.play(Throw.PAPER, Throw.SCISSORS);
        assertEquals(Result.P2_WINS, result);
    }

}