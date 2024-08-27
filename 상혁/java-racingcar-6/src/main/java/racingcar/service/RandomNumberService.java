package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberService {

    public boolean pickNumberInRange() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        return randomNum >= 4;
    }
}
