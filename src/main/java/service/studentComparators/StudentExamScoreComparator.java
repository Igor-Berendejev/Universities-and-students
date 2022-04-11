package service.studentComparators;

import model.Student;

public class StudentExamScoreComparator implements StudentComparator {
    @Override
    public int compare(Student o1, Student o2) {
        Float o1Score = o1.getAvgExamScore();
        return o1Score.compareTo(o2.getAvgExamScore());
    }
}
