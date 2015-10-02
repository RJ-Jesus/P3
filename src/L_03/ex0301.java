package L_03;

import rjj.human.Researcher;
import rjj.human.Student;
import rjj.util.Date;

public class ex0301 {

    public static void main(String[] args) {
        Student stu = new Student("Andreia", 9855678, new Date(18, 7, 1974));
        Researcher res = new Researcher("Maria", 8976543, new Date(11, 5, 1976));
        res.setScholarship(745);
        System.out.println("Student: " + stu.getName());
        System.out.println(stu);
        System.out.println("Researcher: " + res.getName() + ", Nº Mec.: " + res.getNNec() + ", Scholarship: " + res.getScholarship());
        System.out.println(res);
    }
}
