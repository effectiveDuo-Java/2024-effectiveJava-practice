package racingcar.controller;

import racingcar.service.RacingGameService;

public class RacingController {
    private final RacingGameService racingGameService;

    public RacingController(RacingGameService racingGameService) {
        this.racingGameService = racingGameService;
    }

    public void run() {
        racingGameService.run();
    }
}
