package L_04;

import L_04.lect4.Subject;
import rjj.human.Professor;
import rjj.human.Researcher;
import rjj.human.Student;
import rjj.util.Date;

public class ex0401 {
    public static void main(String[] args) {
        Student est1 = new Student("Andreia", 9855678, new Date(18, 7, 1974));
        Student est2 = new Student("Monica", 75266454, new Date(11, 8, 1978));
        Student est3 = new Student("Jose", 85265426, new Date(15, 2, 1976));
        Student est4 = new Student("Manuel", 85153442, new Date(1, 3, 1973));
        Researcher bls1 = new Researcher("Maria", 8976543, new Date(12, 5, 1976));
        Researcher bls2 = new Researcher("Xico", 87235652, new Date(21, 4, 1975));
        Researcher bls3 = new Researcher("Duarte", 32423512, new Date(6, 1, 1976));
        bls1.setScholarship(745);
        bls2.setScholarship(845);
        bls3.setScholarship(745);
        Professor pf1 = new Professor("Jose Manuel", 11223344, new Date(11, 9, 1969));
        Subject dis = new Subject("P5", "Informatics", 6, pf1);
        dis.addStudent(est1);
        dis.addStudent(est2);
        dis.addStudent(bls1);
        if (dis.contains(est3.getNMec()))
            System.out.println("\n" + est3 + " \n\t-> IS registered in the subject.");
        else
            System.out.println("\n" + est3 + " \n\t-> IS NOT registered in the subject.");
        System.out.println("\nNº of students registered: " + dis.numStudents());
        dis.addStudent(est3);
        dis.addStudent(bls2);
        dis.addStudent(est4);
        dis.addStudent(bls3);
        if (!dis.addStudent(bls3))
            System.out.println(bls3.getNMec() + ", " + bls3.getName() + " is already registered in the subject!");
        if (dis.removeStudent(bls2.getNMec()))
            System.out.println(bls2.getName() + " Removed!");
        System.out.println("\nNº of students registered: " + dis.numStudents());
        System.out.println(dis + "\n");
        System.out.println("\nList of students:");
        for (Student e : dis.getStudents())
            System.out.println(e);
        System.out.println("\nList of Researchers:");
        for (Student e : dis.getStudents("Researcher"))
            System.out.println(e);

    }
}
