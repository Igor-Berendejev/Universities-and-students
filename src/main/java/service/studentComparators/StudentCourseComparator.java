package service.studentComparators;

import model.Student;

public class StudentCourseComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        Integer o1Course = o1.getCurrentCourseNumber();
        return o1Course.compareTo(o2.getCurrentCourseNumber());
    }
}
