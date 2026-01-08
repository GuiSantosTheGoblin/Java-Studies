package entities;

import java.util.TreeSet;

public abstract class Person implements Comparable<Person> {
    private Integer code;
    private TreeSet<Course> courses = new TreeSet<>();

    public Person(int code) {
        this.code = code;
    }

    public void addCourses(Course course) {
        this.courses.add(course);
    }

    public Integer getCode() {
        return this.code;
    }

    public TreeSet<Course> getCourses() {
        return this.courses;
    }
    
    public void removeCourses(Course course) {
        this.courses.remove(course);
    }

    public int getNumberOfCourses() {
        return this.courses.size();
    }

    @Override
    public int compareTo(Person other) {
        return this.getCode().compareTo(other.getCode());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((code == null) ? 0 : code.hashCode());
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
        Person other = (Person) obj;
        if (code == null) {
            if (other.code != null)
                return false;
        } else if (!code.equals(other.code))
            return false;
        return true;
    }
}
