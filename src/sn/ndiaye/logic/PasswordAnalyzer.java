package sn.ndiaye.logic;

import sn.ndiaye.util.Criteria;

public class PasswordAnalyzer {
    private final String WEAK_PASSWORD = "This password is weak";
    private final String CORRECT_PASSWORD = "This password is strong enough";
    private final String STRONG_PASSWORD = "This password is strong";

    public String analyze(String password) {
        int activeCriterion = 0;
        for (Criteria criteria : Criteria.values())
            if (password.matches(criteria.getPattern()))
                activeCriterion++;

    if (password.length() < 8)
        return WEAK_PASSWORD;
    if (activeCriterion < 1)
        return WEAK_PASSWORD;
    else if (activeCriterion <= 2)
        return CORRECT_PASSWORD;
    else
        return STRONG_PASSWORD;
    }
}
