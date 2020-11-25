package com.xp.rps;

import java.util.Objects;

public class Round {

    int id;
    Throw p1;
    Throw p2;
    Result result;

    public Round() {
    }

    public Round(Throw p1, Throw p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Throw getP1() {
        return p1;
    }

    public void setP1(Throw p1) {
        this.p1 = p1;
    }

    public Throw getP2() {
        return p2;
    }

    public void setP2(Throw p2) {
        this.p2 = p2;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return id == round.id &&
                p1 == round.p1 &&
                p2 == round.p2 &&
                result == round.result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, p1, p2, result);
    }
}
