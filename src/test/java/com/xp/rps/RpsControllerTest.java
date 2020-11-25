package com.xp.rps;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RpsControllerTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    RpsInMemoryRepo rpsInMemoryRepo;

    @Test
    void play() {
        ResponseEntity<Round> responseEntity = restTemplate.postForEntity("/play", new Round(Throw.ROCK, Throw.PAPER), Round.class);
        assertEquals(Result.P2_WINS, responseEntity.getBody().getResult());
    }

    @Test
    void test_saveGame() {
        // when
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity("/game", TestUtil.getGame(), Integer.class);
        int result = responseEntity.getBody();
        // then
        assertTrue(result > 0);
        Game savedGame = rpsInMemoryRepo.getGame(result);
        Game testGame = TestUtil.getGame();
        testGame.setId(result);
        assertEquals(testGame, savedGame);
    }

    @Test
    void test_getGame() {
        // setup
        int gameId = rpsInMemoryRepo.createGame(TestUtil.getGame());
        // when
        ResponseEntity<Game> responseEntity = restTemplate.getForEntity("/game/{id}", Game.class, gameId);
        // then
        Game testGame = TestUtil.getGame();
        testGame.setId(gameId);
        assertEquals(testGame, responseEntity.getBody());
    }

    @Test
    void test_saveRound() {
        // setup
        int gameId = rpsInMemoryRepo.createGame(TestUtil.getGame());
        // when
        ResponseEntity<Integer> responseEntity = restTemplate.postForEntity("/game/{id}/round", TestUtil.getRound(), Integer.class, gameId);
        // then
        int result = responseEntity.getBody();
        assertTrue(result > 0);
        Game savedGame = rpsInMemoryRepo.getGame(gameId);
        assertEquals(1, savedGame.getRoundList().size());
        Round savedRound = savedGame.getRoundList().get(0);
        Round testRound = TestUtil.getRound();
        testRound.setId(result);
        assertEquals(testRound, savedRound);
    }

}