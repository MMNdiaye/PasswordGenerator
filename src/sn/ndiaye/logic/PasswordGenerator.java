import sn.ndiaye.util.Criteria;
import sn.ndiaye.util.DefaultCriteria;
import sn.ndiaye.util.PasswordCriteria;

import java.util.*;

public class PasswordGenerator {
    private int passwordLength;
    private final PasswordCriteria defaultCriteria = new DefaultCriteria();
    private List<PasswordCriteria> bonusCriterion;
    private HashMap<PasswordCriteria, Boolean> criterionEnabling;
    private int activeCriterionCount;
    private Scanner scanner;

    public PasswordGenerator() {
        bonusCriterion = new ArrayList<>();
        for (Criteria criteria : Criteria.values())
            bonusCriterion.add(criteria.getValue());
        criterionEnabling = new HashMap<>();
        criterionEnabling.put(defaultCriteria, true);
        activeCriterionCount = 1;
        scanner = new Scanner(System.in);
    }

    public String generate() {
        askCriterion();
        askLength();
        showCriterion();
        StringBuilder password = new StringBuilder();
        int remainingLength = passwordLength;
        int minCriteriaLength = passwordLength / activeCriterionCount;
        for (PasswordCriteria criteria : bonusCriterion) {
            if (criterionEnabling.get(criteria)){
                String gen = criteria.generate(minCriteriaLength);
                password.append(gen);
                remainingLength -= minCriteriaLength;
            }
        }
        String gen = defaultCriteria.generate(remainingLength);
        password.append(gen);

        return shufflePassword(password.toString());
    }

    private String shufflePassword(String password) {
        String[] pwChars = password.split("");
        int len = pwChars.length;
        Random rand = new Random();
        //Shuffling random positions
        for (int i = 0; i < (len * len) ; i++) {
            int id1 = rand.nextInt(len);
            int id2 = rand.nextInt(len);
            String temp =  pwChars[id1];
            pwChars[id1]= pwChars[id2];
            pwChars[id2] = temp;
        }
        // Recomposing
        StringBuilder shuffledPw = new StringBuilder();
        for (int i = 0; i < len; i++)
            shuffledPw.append(pwChars[i]);

        return shuffledPw.toString();
    }

    private void askLength() {
        while (true) {
            try {
                System.out.println("Length: ");
                passwordLength = Integer.valueOf(scanner.next());
                if (passwordLength == 0)
                    throw new IllegalArgumentException("Please enter a length > 0");
                if (passwordLength < activeCriterionCount) {
                    throw new IllegalArgumentException("Not long enough to include every" +
                            " criteria. Please chose a length >= " + (activeCriterionCount));
                }
                break;
            } catch(NumberFormatException e) {
                System.out.println("Please enter a number");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

    }

    private void askCriterion() {
        activeCriterionCount = 1;
        for (PasswordCriteria criteria : bonusCriterion) {
            System.out.println("Would you like to add this criteria : " +
                    criteria + " ? yes/no");
            boolean isCriteriaEnabled = scanner.next().toLowerCase().equals("yes");
            if (isCriteriaEnabled)
                activeCriterionCount ++;
            criterionEnabling.put(criteria, isCriteriaEnabled);
        }
    }

    private void showCriterion() {
        System.out.println("Length: " + passwordLength);
        System.out.println(criterionEnabling);
    }

    public static void main(String[] args) {
        PasswordGenerator pg = new PasswordGenerator();
        String password = pg.generate();
        System.out.println("Password: " + password);
    }


}
