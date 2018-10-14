package Project1;

public class Course {

    private int courseNum;
    private String courseTitle;
    private int maxCapacity;
    private String location;

    private String instructorName;
    private double studentScore;

    private int currentEnrollment;

    public Course(int courseNum, String courseTitle, int maxCapacity, String location, String instructorName, double studentScore, int currentEnrollment) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.maxCapacity = maxCapacity;
        this.location = location;
        this.instructorName = instructorName;
        this.studentScore = studentScore;
        this.currentEnrollment = currentEnrollment;
    }

    public Course(int courseNum, String courseTitle, int maxCapacity, String location) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.maxCapacity = maxCapacity;
        this.location = location;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public void setCurrentEnrollment(int currentEnrollment) {
        this.currentEnrollment = currentEnrollment;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public double getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(double studentScore) {
        this.studentScore = studentScore;
    }

    public int getCourseNum() {
        return courseNum;
    }

    public void setCourseNum(int courseNum) {
        this.courseNum = courseNum;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String updateLocation(String location) {
        return  this.location = location;
    }
    @Override
    public String toString(){
        return "\t" + getCourseTitle() + "\n";
    }
}
