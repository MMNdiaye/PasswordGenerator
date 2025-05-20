package sn.ndiaye.util;

public enum Criteria {
    CAPS(new CapsLetterCriteria()),
    SPECIAL(new SpecialCharsCriteria());

    private PasswordCriteria criteria;

    Criteria(PasswordCriteria criteria) {
        this.criteria = criteria;
    }

    public PasswordCriteria getValue() {
        return criteria;
    }

}
