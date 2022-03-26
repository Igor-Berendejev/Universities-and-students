public class Main {
    public static void main(String[] args) {
        University mti = new University("1", "Moscow Technological Institute", "MTI", 2000, StudyProfile.TECHNOLOGY);
        University harvard = new University("2", "Harvard University", "Harvard", 1636, StudyProfile.LAW);
        Student goodStudent = new Student("Cheng Smart", "2", 3, 99.9f);
        Student soSoStudent = new Student("Mickey Mouse", "2", 2, 60.5f);
        Student badStudent = new Student("Ivan Durak", "1", 3, 20f);
        System.out.println(mti);
        System.out.println(harvard);
        System.out.println(goodStudent);
        System.out.println(soSoStudent);
        System.out.println(badStudent);
    }
}
