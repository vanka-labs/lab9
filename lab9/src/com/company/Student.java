package com.company;

public class Student {
    private String name;
    private int number;
    private int course;
    private int group;

    public Student() {
        name = "";
       number =0;
       course = 0;
       group = 0;
    }
    public Student(int number, String name, int course, int group) {
        this.number = number;
        this.name = name;
        this.course = course;
        this.group = group;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public int getCourse() {
        return course;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public int getGroup() {
        return group;
    }
    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return number + " " + name + " " + course + " " + group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        if (number != student.number) return false;
        if (course != student.course) return false;
        if (group != student.group) return false;
        return name.equals(student.name);

    }


}
