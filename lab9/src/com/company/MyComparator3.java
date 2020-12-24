package com.company;
import java.util.Comparator;
public class MyComparator3 implements Comparator<Student> {
    public int compare(Student o1, Student o2)
    {
        if (o1.getCourse() != o2.getCourse())
            return o1.getCourse()-o2.getCourse();
        else if (o1.getGroup() != o2.getGroup())
            return o1.getGroup() - o2.getGroup();
        else
            return o1.getName().compareTo(o2.getName());

    }

}
