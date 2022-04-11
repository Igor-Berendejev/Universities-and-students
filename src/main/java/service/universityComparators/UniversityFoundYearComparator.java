package service.universityComparators;

import model.University;

public class UniversityFoundYearComparator implements UniversityComparator {
    @Override
    public int compare(University o1, University o2) {
        Integer o1Year = o1.getYearOfFoundation();
        return o1Year.compareTo(o2.getYearOfFoundation());
    }
}
