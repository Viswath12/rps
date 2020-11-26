package com.xp.rps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@JdbcTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Import(JDBCRepo.class) //Somehow @JdbcTest not able to load @Repository, Import to force it happen
@Transactional //This will cause each test rollback after testing, also rollback the beforeTestRun.sql
public class RpsRepoTest {

    @Autowired
    private RpsRepo rpsRepo;

    @Test
    public void test_createGame() {
        // when
        int savedGameId = rpsRepo.createGame(TestUtil.getGame());
        // then
        Game savedGame = rpsRepo.getGame(savedGameId);
        assertEquals(TestUtil.getGame().getRoundNo(), savedGame.getRoundNo());
        assertEquals(TestUtil.getGame().getDecision(), savedGame.getDecision());
        assertEquals(TestUtil.getGame().getPlayer1(), savedGame.getPlayer1());
        assertEquals(TestUtil.getGame().getPlayer2(), savedGame.getPlayer2());
    }

    @Test
    public void test_getGame() {
        // when
        int savedGameId = rpsRepo.createGame(TestUtil.getGame());
        // then
        Game savedGame = rpsRepo.getGame(savedGameId);
        assertEquals(savedGameId, savedGame.getId());
        assertEquals(TestUtil.getGame().getRoundNo(), savedGame.getRoundNo());
        assertEquals(TestUtil.getGame().getDecision(), savedGame.getDecision());
        assertEquals(TestUtil.getGame().getPlayer1(), savedGame.getPlayer1());
        assertEquals(TestUtil.getGame().getPlayer2(), savedGame.getPlayer2());
    }

    @Test
    public void test_addRound() {
        // when
        int savedGameId = rpsRepo.createGame(TestUtil.getGame());
        int savedRoundId = rpsRepo.addRound(savedGameId, TestUtil.getRound());
        // then
        Game savedGame = rpsRepo.getGame(savedGameId);
        assertEquals(savedGameId, savedGame.getId());
        assertEquals(TestUtil.getGame().getRoundNo(), savedGame.getRoundNo());
        assertEquals(TestUtil.getGame().getDecision(), savedGame.getDecision());
        assertEquals(TestUtil.getGame().getPlayer1(), savedGame.getPlayer1());
        assertEquals(TestUtil.getGame().getPlayer2(), savedGame.getPlayer2());
        assertEquals(1, savedGame.getRoundList().size());
        Round savedRound = savedGame.getRoundList().get(0);
        assertEquals(savedRoundId, savedRound.getId());
        assertEquals(TestUtil.getRound().getThrow1(), savedRound.getThrow1());
        assertEquals(TestUtil.getRound().getThrow2(), savedRound.getThrow2());
        assertEquals(TestUtil.getRound().getResult(), savedRound.getResult());
    }

}