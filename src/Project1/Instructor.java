package Project1;

import java.util.ArrayList;
import java.util.List;

/**
 * Title: Instructor.java
 * Abstract: This is the instructor class. It keep the data of each instructor in the school.
 * It also have a list of courses, to "link" the instructor with the correct course.
 * Name: Pernille Dahl
 * Date: 2018-Oct-13
 */


public class Instructor {

    private int employeeNum;
    private String name;
    private String email;
    private String phoneNumber;

    private List<Course> courses;

    public Instructor(int employeeNum, String name, String email, String phoneNumber) {
        this.employeeNum = employeeNum;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        courses = new ArrayList<>();
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getCourses() {
        return courses;
    }

    @Override
    public String toString(){
        StringBuilder detailedInfo = new StringBuilder();
        detailedInfo.append( String.format( "Instructor Number: %d\n", employeeNum ) );
        detailedInfo.append( String.format( "Name: %s\n", name ) );
        detailedInfo.append("Courses Teaching:\n");
        for ( Course course : courses ) {
            detailedInfo.append(String.format( "%d: %d enrolled\n",course.getCourseNum(), course.getEnrolledStudents().size()));
        }
        return detailedInfo.toString();
    }
}
