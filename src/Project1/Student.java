package Project1;

import java.util.ArrayList;
import java.util.List;
/**
 * Title: Student.java
 * Abstract: This is the student class. This class has the getters and setter for student information.
 * The class also keeps track of the course, this way I can "linked" the student score with the correct course.
 * Name: Pernille Dahl
 * Date: 2018-Oct-13
 */


public class Student {
    private int id;
    private String name;

    private List<Course> courses;

    public Student(int ID, String name) {
        this.id = ID;
        this.name = name;
        courses = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    /**
     * Gets the average score of all courses for the student
     * @return
     */
    public double getAverage() {
        if(courses.size()==0) return 0;
        double sum = 0;
        for ( Course course : courses ) {
            sum += course.getGrades().get( this );
        }
        return sum / courses.size();
    }

    @Override
    public String toString(){
        StringBuilder detailedInfo = new StringBuilder();
        detailedInfo.append( String.format( "Student Number: %d\n", id ) );
        detailedInfo.append( String.format( "Name: %s\n", name ) );
        detailedInfo.append( "Courses enrolled\n" );
        for ( Course course : courses ) {
            detailedInfo.append( String.format( "%d: %.2f\n", course.getCourseNum(), course.getGrades().get( this ) ) );
        }
        return detailedInfo.toString();
    }

}
