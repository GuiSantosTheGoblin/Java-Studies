package entities;

import java.util.TreeSet;

public class Teacher extends Person {
    public Teacher(int code) {
        super(code);
    }

    public TreeSet<Student> getAllStudents() {
        TreeSet<Student> allStudents = new TreeSet<>();
        for (Course course : this.getCourses()) {
            allStudents.addAll(course.getStudents());
        }
        return allStudents;
    }

    public int getNumberOfStudents() {
        TreeSet<Student> allStudents = new TreeSet<>();
        for (Course course : this.getCourses()) {
            allStudents.addAll(course.getStudents());
        }
        return allStudents.size();
    }

    public Student findStudent(Student student) {
        Student closestFoundStudent = this.getAllStudents().ceiling(student); 
        //ceiling retorna um elemento igual ou maior que o elemento passado como parâmetro, se não tiver, retorna null
        if (closestFoundStudent != null && closestFoundStudent.equals(student)) { 
            //precisa verificar se não é null primeiro, porque ceiling pode retornar null, e o equals pode tertar fazer null.equals(), que vai dar erro
            return closestFoundStudent;            
        }
        return null;
    }
}
