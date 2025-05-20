package sn.ndiaye.util;

public enum Criteria {
    CAPS(new CapsLetterCriteria()),
    SPECIAL(new SpecialCharsCriteria()),
    NUMBERS(new NumbersCriteria());

    private PasswordCriteria criteria;

    Criteria(PasswordCriteria criteria) {
        this.criteria = criteria;
    }

    public PasswordCriteria getValue() {
        return criteria;
    }

    public String getPattern() {
        String pattern;
        switch (this) {
            case CAPS:
                pattern = ".*[A-Z].*";
                break;
            case NUMBERS:
                pattern = ".*\\d.*";
                break;
            case SPECIAL:
                pattern = ".*[^[A-Z][a-z]|\\d].*";
                break;
            default:
                pattern = "";
                break;
        }
        return pattern;
    }

}
