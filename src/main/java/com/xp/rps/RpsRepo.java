package com.xp.rps;


public interface RpsRepo {
    int createGame(Game game);
    int addRound(int gameID, Round round);
    Game getGame(int gameID);
}
