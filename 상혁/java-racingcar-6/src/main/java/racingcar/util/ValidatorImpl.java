package racingcar.util;

public class ValidatorImpl implements Validator{
    private static final String NAME_VALIDATOR = "^([a-zA-Z가-힣0-9]{1,5})(,([a-zA-Z가-힣0-9]{1,5}))*$";

    @Override
    public String nameValidator(String name) {
        if (!name.matches(NAME_VALIDATOR)) {
            throw new IllegalArgumentException(CommonUtil.EXCEPTION_WRONG_INPUT);
        }
        return name;
    }
}
