package sn.ndiaye.util;

import java.util.Random;

public class SpecialCharsCriteria extends PasswordCriteria{
    private final int[][] CODE_RANGES = {{33, 47}, {58, 64},
            {91, 95}, {123, 126}};
    private final int RANGES_COUNT = CODE_RANGES.length;


    SpecialCharsCriteria() {
        super("Special characters");
    }

    @Override
    public String generate(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int rangeChoice = random.nextInt(RANGES_COUNT);
            int minCode = CODE_RANGES[rangeChoice][0];
            int maxCode = CODE_RANGES[rangeChoice][1];
            char generatedChar = (char) random.nextInt(minCode, maxCode + 1);
            stringBuilder.append(generatedChar);
        }
        return stringBuilder.toString();
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
