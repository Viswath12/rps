package com.xp.rps;

public class TestUtil {

    private TestUtil() {
    }

    public static Round getRound() {
        Round r = new Round();
        r.setThrow1(Throw.ROCK);
        r.setThrow2(Throw.PAPER);
        r.setResult(Result.P2_WINS);
        return r;
    }

    public static Game getGame() {
        Game game = new Game();
        game.setDecision("TestD");
        game.setPlayer1("p1");
        game.setPlayer2("p2");
        game.setRoundNo(1);
        return game;
    }

}
