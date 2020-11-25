package com.xp.rps;

public class RPS {

    public static Result play(Throw p1, Throw p2) {
        if(p1.equals(p2)) {
            return Result.DRAW;
        }
        if(Throw.ROCK.equals(p1) && Throw.PAPER.equals(p2)) {
            return Result.P2_WINS;
        }
        if(Throw.PAPER.equals(p1) && Throw.ROCK.equals(p2)) {
            return Result.P1_WINS;
        }
        if(Throw.ROCK.equals(p1) && Throw.SCISSORS.equals(p2)) {
            return Result.P1_WINS;
        }
        if(Throw.SCISSORS.equals(p1) && Throw.ROCK.equals(p2)) {
            return Result.P2_WINS;
        }
        if(Throw.SCISSORS.equals(p1) && Throw.PAPER.equals(p2)) {
            return Result.P1_WINS;
        }
        if(Throw.PAPER.equals(p1) && Throw.SCISSORS.equals(p2)) {
            return Result.P2_WINS;
        }
        return Result.DRAW;
    }
}