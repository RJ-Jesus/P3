package L_09;

import L_09.ex01.ScannerAveirense;

import java.io.File;
import java.io.IOException;

public class ex0901 {
    public static void main(String[] args) {
        System.out.print("Please enter a String: ");
        System.out.printf("-> %s\n", (new ScannerAveirense(System.in)).nextLine());
/*        System.out.print("File to read: ");
        File f = new File((new Scanner(System.in)).nextLine());*/
        File f = new File("src/L_09/Static.d/Aveiro.txt");
        try (ScannerAveirense sca = new ScannerAveirense(f)) {
            while (sca.hasNext())
                System.out.println(sca.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
