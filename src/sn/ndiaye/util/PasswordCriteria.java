package sn.ndiaye.util;

public abstract class PasswordCriteria {
    private final String criteriaName;

    PasswordCriteria(String name) {
        criteriaName = name;
    }
    public abstract String generate(int length);

    @Override
    public String toString() {
        return criteriaName;
    }
}
