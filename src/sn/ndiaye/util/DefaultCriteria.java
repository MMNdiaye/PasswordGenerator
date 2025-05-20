package sn.ndiaye.util;

import java.util.Random;

public class DefaultCriteria extends PasswordCriteria{

    private final int MIN_CODE = 97;
    private final int MAX_CODE = 122;

    public DefaultCriteria() {
        super("Simple characters");
    }

    @Override
    public String generate(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char generatedChar = (char) random.nextInt(MIN_CODE, MAX_CODE + 1);
            stringBuilder.append(generatedChar);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
