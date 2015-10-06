package L_04.lect4;

import rjj.human.Professor;
import rjj.human.Student;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Subject {
    private String name;
    private String field;
    private int ECTs;
    private Professor professor;
    private HashSet<Student> students;

    public Subject(final String name, final String field, final int ECTs, final Professor professor) {
        if (name == null)
            throw new IllegalArgumentException("Name is null.");
        if (field == null)
            throw new IllegalArgumentException("Field is null.");
        if (ECTs <= 0)
            throw new IllegalArgumentException("Number of ECTs must be positive.");
        if (professor == null)
            throw new IllegalArgumentException("Professor is null.");
        this.name = name;
        this.field = field;
        this.ECTs = ECTs;
        this.professor = professor;
        this.students = new HashSet<>();
    }

    public boolean addStudent(final Student stu) {
        return students.add(stu);
    }

    public boolean removeStudent(final int nMec) {
        Student stu = find(nMec);
        if (stu != null) {
            students.remove(stu);
            return true;
        }
        return false;
    }

    public boolean contains(final int nMec) {
        return find(nMec) != null;
    }

    public int numStudents() {
        return students.size();
    }

    public Student[] getStudents() {
        return students.toArray(new Student[students.size()]);
    }

    public Student[] getStudents(final String type) {
        try {
            LinkedList<Student> l = new LinkedList<>();
            Class c = Class.forName("rjj.human." + type);
            /*for(Student stu : students)
                if(c.isInstance(stu))
                    l.add(stu);*/
            l.addAll(students.stream().filter(c::isInstance).collect(Collectors.toList()));
            return l.toArray(new Student[l.size()]);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    private Student find(final int nMec) {
        for (Student stu : students)
            if (stu.getNMec() == nMec)
                return stu;
        return null;
    }

    @Override
    public String toString() {
        return "Subject: " + name + String.format(" (%d ECTS)", ECTs) + " of " + field +
                "\nProfessor: " + professor.toString() +
                "\nThere are " + numStudents() + " students registered";
    }
}
