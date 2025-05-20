package sn.ndiaye.util;

import java.util.Random;

public class NumbersCriteria extends PasswordCriteria{
    private final int MAX_NUMBER = 9;

    NumbersCriteria() {
        super("Numbers");
    }

    @Override
    public String generate(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++)
            stringBuilder.append(random.nextInt(MAX_NUMBER + 1));

        return stringBuilder.toString();
    }
}
