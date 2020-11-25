package com.xp.rps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RpsInMemoryRepoTest {

    private RpsInMemoryRepo rpsInMemoryRepo;



    @BeforeEach
    public void setup() {
        rpsInMemoryRepo = new RpsInMemoryRepo();
    }

    @Test
    public void test_createGame() {
        // when
        int savedGameId = rpsInMemoryRepo.createGame(TestUtil.getGame());
        // then
        Game savedGame = rpsInMemoryRepo.getGame(savedGameId);
        assertEquals(TestUtil.getGame().getRoundNo(), savedGame.getRoundNo());
        assertEquals(TestUtil.getGame().getDecision(), savedGame.getDecision());
        assertEquals(TestUtil.getGame().getPlayer1(), savedGame.getPlayer1());
        assertEquals(TestUtil.getGame().getPlayer2(), savedGame.getPlayer2());
    }

    @Test
    public void test_getGame() {
        // when
        int savedGameId = rpsInMemoryRepo.createGame(TestUtil.getGame());
        // then
        Game savedGame = rpsInMemoryRepo.getGame(savedGameId);
        assertEquals(savedGameId, savedGame.getId());
        assertEquals(TestUtil.getGame().getRoundNo(), savedGame.getRoundNo());
        assertEquals(TestUtil.getGame().getDecision(), savedGame.getDecision());
        assertEquals(TestUtil.getGame().getPlayer1(), savedGame.getPlayer1());
        assertEquals(TestUtil.getGame().getPlayer2(), savedGame.getPlayer2());
    }

    @Test
    public void test_getGame_InvalidId() {
        // when
        Game game = rpsInMemoryRepo.getGame(-1);
        assertNull(game);
    }

    @Test
    public void test_addRound() {
        // when
        int savedGameId = rpsInMemoryRepo.createGame(TestUtil.getGame());
        int savedRoundId = rpsInMemoryRepo.addRound(savedGameId, TestUtil.getRound());
        // then
        Game savedGame = rpsInMemoryRepo.getGame(savedGameId);
        assertEquals(savedGameId, savedGame.getId());
        assertEquals(TestUtil.getGame().getRoundNo(), savedGame.getRoundNo());
        assertEquals(TestUtil.getGame().getDecision(), savedGame.getDecision());
        assertEquals(TestUtil.getGame().getPlayer1(), savedGame.getPlayer1());
        assertEquals(TestUtil.getGame().getPlayer2(), savedGame.getPlayer2());
        assertEquals(1, savedGame.getRoundList().size());
        Round savedRound = savedGame.getRoundList().get(0);
        assertEquals(savedRoundId, savedRound.getId());
        assertEquals(TestUtil.getRound().getP1(), savedRound.getP1());
        assertEquals(TestUtil.getRound().getP2(), savedRound.getP2());
        assertEquals(TestUtil.getRound().getResult(), savedRound.getResult());
    }

    @Test
    public void test_addRound_InvalidId() {
        // when
        int id = rpsInMemoryRepo.addRound(-1, TestUtil.getRound());
        assertEquals(-1, id);
    }

}
