package entities;

import java.util.TreeSet;

public class Course implements Comparable<Course> {
    private String name;
    private Teacher teacher;
    private TreeSet<Student> students = new TreeSet<>();

    public Course() {}

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, Teacher teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return this.name;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public TreeSet<Student> getStudents() {
        return this.students;
    }

    @Override
    public int compareTo(Course other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Course other = (Course) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}