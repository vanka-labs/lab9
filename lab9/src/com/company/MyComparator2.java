package com.company;
import java.util.Comparator;
public class MyComparator2 implements Comparator<Student> {
    public int compare(Student o1, Student o2)
    {
        if (o1.getGroup() != o2.getGroup())
            return o1.getGroup()-o2.getGroup();
        else
            return o1.getNumber()-o2.getNumber();

    }

}
