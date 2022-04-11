package service;

import service.studentComparators.*;
import service.universityComparators.*;

public class Comparators {
    private Comparators() {
    }

    public static StudentComparator getStudentComparator(StudentComparators studentComparator) {
        switch (studentComparator) {
            case STUDENT_NAME_COMPARATOR -> {
                return new StudentNameComparator();
            }
            case STUDENT_COURSE_COMPARATOR -> {
                return new StudentCourseComparator();
            }
            case STUDENT_EXAM_SCORE_COMPARATOR -> {
                return new StudentExamScoreComparator();
            }
            case STUDENT_UNIVERSITY_ID_COMPARATOR -> {
                return new StudentUniversityIdComparator();
            }
        }
        return null;
    }

    public static UniversityComparator getUniversityComparator(UniversityComparators universityComparator) {
        switch (universityComparator) {
            case UNIVERSITY_ID_COMPARATOR -> {
                return new UniversityIdComparator();
            }
            case UNIVERSITY_NAME_COMPARATOR -> {
                return new UniversityNameComparator();
            }
            case UNIVERSITY_SHORT_NAME_COMPARATOR -> {
                return new UniversityShortNameComparator();
            }
            case UNIVERSITY_FOUNDATION_YEAR_COMPARATOR -> {
                return new UniversityFoundYearComparator();
            }
            case UNIVERSITY_PROFILE_COMPARATOR -> {
                return new UniversityProfileComparator();
            }
        }
        return null;
    }
}
