package com.xp.rps;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Game {

    int id;
    String player1;
    String player2;
    String decision;
    int roundNo;
    List<Round> roundList;

    public Game() {
        roundList = new ArrayList<>();
    }

    public Game(int id, String player1, String player2, int roundNo, String decision) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.decision = decision;
        this.roundNo = roundNo;
        this.roundList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public int getRoundNo() {
        return roundNo;
    }

    public void setRoundNo(int roundNo) {
        this.roundNo = roundNo;
    }

    public List<Round> getRoundList() {
        return roundList;
    }

    public void setRoundList(List<Round> roundList) {
        this.roundList = roundList;
    }

    public Result getResult() {
        int p1 = 0;
        int p2 = 0;
        Result result;
        for(Round round: roundList) {
            if(Result.P1_WINS.equals(round.getResult())) {
                p1++;
            } else if(Result.P2_WINS.equals(round.getResult())) {
                p2++;
            }
        }
        if(p1 > p2) {
            result = Result.P1_WINS;
        } else if (p2 > p1) {
            result = Result.P2_WINS;
        } else {
            result = Result.DRAW;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id &&
                roundNo == game.roundNo &&
                Objects.equals(player1, game.player1) &&
                Objects.equals(player2, game.player2) &&
                Objects.equals(decision, game.decision) &&
                Objects.equals(roundList, game.roundList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, player1, player2, decision, roundNo, roundList);
    }
}
