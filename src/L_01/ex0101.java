package L_01;

import L_01.lect1.StringUtils;

import java.util.Scanner;

public class ex0101 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("String: ");
        StringUtils s = new StringUtils(sc.nextLine());
        System.out.println("Number of Digits: " + s.getNumberDigits());
        System.out.println("Is lowercase: " + s.isLowerCase());
        System.out.println("Is uppercase: " + s.isUpperCase());
        System.out.println("Words: " + String.join(" | ", s.getWords()));
        System.out.println("Number of words: " + s.getNumberWords());
        System.out.println("String switched 2 by 2: " + s.getSwitched2by2());
    }
}
