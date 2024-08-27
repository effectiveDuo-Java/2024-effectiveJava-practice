package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.CommonUtil;
import racingcar.util.Validator;
import racingcar.util.ValidatorImpl;

import java.util.HashMap;
import java.util.Map;

public class RacingGameService {
    private final Validator validator = new ValidatorImpl();
    private final Map<String, String> gameStatus = new HashMap<>();
    private final RandomNumberService randomNumberService = new RandomNumberService();

    public void run() {
        try {
            initializeGame();
            int cnt = gameTryCnt();
            startRace(cnt);
            printWinner();
        } catch (Exception e) {
            throw new IllegalArgumentException(CommonUtil.EXCEPTION_WRONG_INPUT);
        }
    }

    private void initializeGame() {
        System.out.println(CommonUtil.INPUT_RACING_CAR_NAME);
        String[] cars = validator.nameValidator(Console.readLine()).split(",");

        for (String car : cars) {
            gameStatus.put(car, "");
        }
    }

    private int gameTryCnt() {
        System.out.println(CommonUtil.INPUT_TRY_CNT);
        return Integer.parseInt(Console.readLine());
    }

    private void startRace(int cnt) {
        System.out.println();
        System.out.println(CommonUtil.RESULT);

        for (int i = 0; i < cnt; i++) {
            raceRound();
            printResult();
        }
    }

    private void raceRound() {
        for (String car : gameStatus.keySet()) {
            if (randomNumberService.pickNumberInRange()) {
                gameStatus.put(car, gameStatus.get(car) + "-");
            }
        }
    }

    private void printResult() {
        gameStatus.forEach((car, progress) -> System.out.printf("%s : %s\n", car, progress));
        System.out.println();
    }

    private void printWinner() {
        int maxLength = gameStatus.values().stream()
                .mapToInt(String::length)
                .max()
                .orElse(0);

        String winners = gameStatus.entrySet().stream()
                .filter(entry -> entry.getValue().length() == maxLength)
                .map(Map.Entry::getKey)
                .reduce((car1, car2) -> car1 + ", " + car2)
                .orElse("");

        System.out.println(CommonUtil.FINAL_WINNER + " : " + winners);
    }
}
