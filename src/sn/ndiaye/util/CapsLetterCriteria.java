package sn.ndiaye.util;

import java.util.Random;

public class CapsLetterCriteria extends PasswordCriteria{
    private final int MIN_CODE = 65;
    private final int MAX_CODE = 90;

    CapsLetterCriteria() {
        super("Capitalized letters");
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

    public static void main(String[] args) {
        CapsLetterCriteria criteria = new CapsLetterCriteria();
        System.out.println(criteria.generate(5));
    }

}
