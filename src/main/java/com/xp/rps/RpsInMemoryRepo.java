package com.xp.rps;

import java.util.HashMap;
import java.util.Map;

public class RpsInMemoryRepo implements RpsRepo {

    private static int SEQUENCE = 0;
    private static int ROUND_SEQUNCE = 0;
    private static Map<Integer, Game> gameMap = new HashMap<>();

    public int createGame(Game g) {
        SEQUENCE++;
        g.setId(SEQUENCE);
        gameMap.put(g.getId(), g);
        return g.getId();
    }

    public int addRound(int gameId, Round r) {
        Game game = getGame(gameId);
        if(game == null) {
            return -1;
        }
        ROUND_SEQUNCE++;
        r.setId(ROUND_SEQUNCE);
        game.getRoundList().add(r);
        gameMap.put(gameId, game);
        return r.getId();
    }

    public Game getGame(int gameId) {
        return gameMap.get(gameId);
    }

}
