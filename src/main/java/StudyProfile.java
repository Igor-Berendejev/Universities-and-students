public enum StudyProfile {
    MEDICINE("Медицина"),
    TECHNOLOGY("Технология"),
    IT("ИТ"),
    LAW("Юриспруденция");

    public final String profileName;

    private StudyProfile(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return profileName;
    }
}
