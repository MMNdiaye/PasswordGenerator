package sn.ndiaye;

import sn.ndiaye.logic.PasswordAnalyzer;
import sn.ndiaye.logic.PasswordGenerator;

public class Main {
    public static void main(String[] args) {
        PasswordGenerator pG = new PasswordGenerator();
        String password = pG.generate();
        System.out.println("Password: " +password);
        PasswordAnalyzer pA = new PasswordAnalyzer();
        String analysis = pA.analyze(password);
        System.out.println(analysis);
    }
}
