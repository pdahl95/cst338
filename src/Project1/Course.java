package Project1;

import java.util.*;
/**
 * Title: Course.java
 * Abstract: This is the course class. It keeps the course data. It also consists of Instrcutor Information, and well as enrolled student in the course, and the grades for each course.
 * Name: Pernille Dahl
 * Date: 2018-Oct-13
 */

public class Course {

    private int courseNum;
    private String courseTitle;
    private int maxCapacity;
    private String location;

    private Instructor instructor;
    private List<Student> enrolledStudents;
    private Map<Student,Double> grades;


    public Course(int courseNum, String courseTitle, int maxCapacity, String location) {
        this.courseNum = courseNum;
        this.courseTitle = courseTitle;
        this.maxCapacity = maxCapacity;
        this.location = location;
        enrolledStudents = new ArrayList<>();
        grades = new HashMap<>();
    }

    public boolean isRegistered(int studentId) {
        for ( Student student : enrolledStudents ) {
            if ( student.getId() == studentId ) {
                return true;
            }
        }
        return false;
    }

    public void unRegister(int studentId) {
        Iterator<Student> iterator = getEnrolledStudents().iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if ( student.getId() == studentId ) {
                iterator.remove();
                // removing all the courses for the student
                grades.remove( student );
                return;
            }
        }
        System.out.println("Student was not registered in the course!");
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

    public void updateLocation(String location) {
        this.location = location;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public Map<Student, Double> getGrades() {
        return grades;
    }

    /**
     * Gets the average score of the course
     * @return
     */
    public double getAverage() {
        if ( grades.size() == 0 ) {
            return 0; // meaning no scores yet!
        }
        double sum = 0;
        for ( Double d : grades.values() ) {
            sum += d;
        }
        return sum / grades.size();
    }

    /**
     * Adds the score of the student if it is registered
     * @param student
     * @param score
     * @return
     */
    public boolean putScore(Student student, double score) {
        if ( isRegistered( student.getId() ) ) {
            return grades.put(student, score ) == null ;
        }
        return false;
    }

    @Override
    public String toString() {
        return "\t" + getCourseTitle() + "\n";
    }
}
