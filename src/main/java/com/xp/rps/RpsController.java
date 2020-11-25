package com.xp.rps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RpsController {

    @Autowired
    private RpsInMemoryRepo rpsRepo;

    @PostMapping("/play")
    Round play(@RequestBody Round round) {
        Result r = RPS.play(round.p1, round.p2);
        round.setResult(r);
        return round;
    }

    @PostMapping("/game")
    int saveGame(@RequestBody Game game) {
        return rpsRepo.createGame(game);
    }

    @PostMapping("/game/{id}/round")
    int saveRound(@PathVariable int id, @RequestBody Round round) {
        Result result = RPS.play(round.getP1(), round.getP2());
        round.setResult(result);
        return rpsRepo.addRound(id, round);
    }

    @GetMapping("/game/{id}")
    Game getGame(@PathVariable int id) {
        return rpsRepo.getGame(id);
    }

}