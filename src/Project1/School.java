package Project1;
import java.util.HashMap;
import java.io.*;
import java.util.*;

/**
 * Title: School.java
 * Abstract: This class is the name class with all the function of this project. This class stores the data of my school.
 * Keeps the data in 3 different hashmaps.
 * Name: Pernille Dahl
 * Date: 2018-Oct-130
 */


public class School {

    private String schoolName;

    public School(String name) {
        this.schoolName = name;
    }

    private HashMap<Integer, Instructor> instructorMap = new HashMap<>();
    private HashMap<Integer, Student> studentsMap = new HashMap<>();
    private HashMap<Integer, Course> coursesMap = new HashMap<>();

    public HashMap<Integer, Instructor> getInstructorMap() {
        return instructorMap;
    }

    public HashMap<Integer, Student> getStudentsMap() {
        return studentsMap;
    }

    public HashMap<Integer, Course> getCoursesMap() {
        return coursesMap;
    }

    /**
     *  Reading a text file of data. Throws a exception is file not found.
     * @param filePath
     * @throws FileNotFoundException
     */
    public void readData(String filePath) throws FileNotFoundException {
        Scanner s = new Scanner(new File(filePath));
        int numInstructor = s.nextInt();
        s.nextLine();
        for(int i = 0; i < numInstructor;i++){
            String instructorInfo = s.nextLine();
            String[] listOfInstructor = instructorInfo.split(",");
            addInstructor(Integer.parseInt(listOfInstructor[0]), listOfInstructor[1], listOfInstructor[2], listOfInstructor[3]);
        }
        int numCourse = s.nextInt();
        s.nextLine();
        for(int i = 0; i < numCourse;i++){
            String CourseInfo = s.nextLine();
            String[] listOfCourse = CourseInfo.split(",");
            addCourse(Integer.parseInt(listOfCourse[0]), listOfCourse[1], Integer.parseInt(listOfCourse[2]), listOfCourse[3]);
        }
        int numStudent = s.nextInt();
        s.nextLine();
        for(int i = 0; i < numStudent;i++){
            String studentInfo = s.nextLine();
            String[] listOfStudent = studentInfo.split(",");
            addStudent(Integer.parseInt(listOfStudent[0]), listOfStudent[1]);
        }
        s.close();
        System.out.println("Done.");
    }

    /**
     * Print the school information obtained in the toString function
     */
    public void schoolInfo() {
        System.out.println( this.toString() );
    }

    /**
     * Builds the string for schoolInfo and return its.
     * @return
     */

    @Override
    public String toString() {
        StringBuilder schoolInfo = new StringBuilder();
        schoolInfo.append( String.format( "School Name: %s.\n", schoolName ) );
        schoolInfo.append("Instructor Information\n");
        for ( Instructor instructor : instructorMap.values() ) {
            schoolInfo.append( instructor.getName()+ "\n" );
        }
        schoolInfo.append("Course Information\n");
        for ( Course course : coursesMap.values() ) {
            schoolInfo.append(course.toString());
        }
        schoolInfo.append("Student Information\n");
        for ( Student student : studentsMap.values() ) {
            schoolInfo.append(student.toString());
        }
        return schoolInfo.toString();
    }

    /**
     * Get the email, search and checks if the email is in the instructor map or not, if it is, it returns the instructor
     * @param email
     * @return
     */
    public Instructor searchByEmail(String email) {
        for ( Instructor instructor : instructorMap.values() ) {
            if ( instructor.getEmail().equals( email ) ) {
                System.out.println( "Search Key: " + email );
                System.out.println( "Employee Number: " + instructor.getEmployeeNum() );
                System.out.println( "\tName: " + instructor.getName() + "\n Phone: " + instructor.getPhoneNumber() );
                return instructor;
            }
        }
        System.out.println( "Search Key: " + email );
        System.out.println( "No employee with email " + email );
        return null;
    }

    /**
     * Adds the instructor to the instructor Map
     * @param employeeNumber
     * @param name
     * @param email
     * @param phoneNumber
     * @return
     */
    public boolean addInstructor(int employeeNumber, String name, String email, String phoneNumber) {
        if ( !instructorMap.containsKey( employeeNumber ) ) {
            Instructor instructorInfo = new Instructor( employeeNumber, name, email, phoneNumber );
            instructorMap.put( employeeNumber, instructorInfo );
            return true;
        } else {
            System.out.printf( "Instructor addition failed - Instructor id %d already exists.\n", employeeNumber );
            return false;
        }
    }

    /**
     * Adds the course to the course Map
     * @param courseId
     * @param courseName
     * @param capacity
     * @param location
     * @return
     */
    public boolean addCourse(int courseId, String courseName, int capacity, String location) {
        if(!coursesMap.containsKey( courseId )){
            Course courseInfo = new Course( courseId, courseName, capacity, location );
            coursesMap.put( courseId, courseInfo );
            return true;
        }else {
            System.out.printf("Course addition failed - Course number %d already used.\n", courseId);
            return false;
        }
    }

    /**
     * Adds the student to the student Map
     * @param studentId
     * @param name
     * @return
     */
    public boolean addStudent(int studentId, String name) {
        if ( !studentsMap.containsKey( studentId ) ) {
            Student studentInfo = new Student( studentId, name );
            studentsMap.put( studentId, studentInfo );
            return true;
        } else {
            System.out.printf("Student addition failed - Student id %d already used.\n", studentId);
            return false;
        }
    }

    /**
     * Assign instructor to the course
     * @param courseId
     * @param employeeNumber
     * @return
     */
    public boolean assignInstructor(int courseId, int employeeNumber) {
        if(!instructorMap.containsKey( employeeNumber )){
            System.out.println("Instructor " + employeeNumber + " does not exist.");
            return false;
        }
        if ( !coursesMap.containsKey( courseId ) ) {
            System.out.println("Course " + courseId + " does not exist.");
            return false;
        }
        Course course = coursesMap.get( courseId );
        course.setInstructor( instructorMap.get( employeeNumber ) );
        Instructor instructor = instructorMap.get( employeeNumber );
        instructor.getCourses().add( course );
        return true;
    }

    /**
     * Assign/register the student to the course.
     * @param courseId
     * @param studentId
     * @return
     */
    public boolean register(int courseId, int studentId) {
        if(!studentsMap.containsKey( studentId )){
            System.out.println("Student " + studentId + " does not exist.");
            return false;
        }
        if(!coursesMap.containsKey( courseId )){
            System.out.println("Course " + courseId + " does not exist.");
            return false;
        }
        Course course = coursesMap.get( courseId );
        if ( course.getEnrolledStudents().size() >= course.getMaxCapacity() ) {
            System.out.println("Registration failed - Class is full.\n");
            return false;
        }
        course.getEnrolledStudents().add( studentsMap.get( studentId ) );
        Student student = studentsMap.get( studentId );
        student.getCourses().add( course );
        return true;
    }

    /**
     * Adding a score for a student in a class (course)
     * @param courseId
     * @param studentId
     * @param score
     */
    public boolean putScore(int courseId, int studentId, double score) {
        if(!studentsMap.containsKey( studentId )){
            System.out.println("Student " + studentId + " does not exist.");
            return false;
        }
        if(!coursesMap.containsKey( courseId )){
            System.out.println("Course " + courseId + " does not exist.");
            return false;
        }
        Course course = coursesMap.get( courseId );
        if ( !course.isRegistered( studentId ) ) {
            System.out.printf( "Student %d is not registered for the course.\n", studentId );
            return false;
        }
        return course.putScore( studentsMap.get( studentId ), score );
    }

    /**
     * unregisters a student from a course
     * @param courseId
     * @param studentId
     */
    public void unRegister(int courseId, int studentId) {
        if(!studentsMap.containsKey( studentId )){
            System.out.println("Student " + studentId + " does not exist.");
        }
        if(!coursesMap.containsKey( courseId )){
            System.out.println("Course " + courseId + " does not exist.");
        }
        Course course = coursesMap.get( courseId );
        course.unRegister( studentId );
    }

    /**
     * Deletes the information of the course
     * @param courseId
     */
    public void courseInfo(int courseId) {
        if ( !coursesMap.containsKey( courseId ) ) {
            System.out.printf( "Course with id %d does not exist.\n", courseId );
        }
        Course course = coursesMap.get( courseId );
        System.out.println("Course Number: " + courseId);
        System.out.println("Instructor: " + course.getInstructor().getName());
        System.out.println("Course Title: " + course.getCourseTitle());
        System.out.println("Room: " + course.getLocation());
        System.out.println("Total Enrolled: " + course.getEnrolledStudents().size());
        System.out.println("Course Average: " + course.getAverage());
    }

    /**
     * Gets the information about the course
     * @param courseId
     * @return
     */
    public Course getCourse(int courseId) {
        if ( coursesMap.containsKey( courseId ) ) {
            return coursesMap.get( courseId );
        }
        return null;
    }

    /**
     * Deletes the course, and cheack so it should not delete the course if studentsMap are enrolled in the course.
     * @param courseId
     * @return
     */
    public boolean deleteCourse(int courseId) {
        if ( !coursesMap.containsKey( courseId ) ) {
            System.out.printf( "Course with id %d does not exist.\n", courseId );
            return false;
        }
        if ( coursesMap.get( courseId ).getEnrolledStudents().size() > 0 ) {
            System.out.println("Course deletion failed – Enrolled student(s) in the class");
            return false;
        }
        return coursesMap.remove( courseId ) != null;
    }

    /**
     * Print the course information about all of the relevant courses
     */
    public void courseInfo() {
        System.out.println("Number of Courses: " + coursesMap.size());
        for ( Course course : coursesMap.values() ) {
            System.out.printf( "%d : %d enrolled\n", course.getCourseNum(), course.getEnrolledStudents().size() );
        }
    }

    /**
     * Get the instructor, and checks if the instructor exist or not.
     * @param courseId
     * @return
     */
    public Instructor getInstructor(int courseId) {
        if ( coursesMap.containsKey( courseId) ) {
            Instructor instructor = coursesMap.get( courseId ).getInstructor();
            return instructor;
        }
        System.out.printf( "Course with id %d does not exist.\n", courseId );
        return null;
    }

    /**
     * Get the student, and checks if the student exist or not.
     * @param studentId
     * @return
     */
    public Student getStudent(int studentId) {
        if ( studentsMap.containsKey( studentId ) ) {
            return studentsMap.get( studentId );
        }
        return null;
    }

    /**
     * Checks if the student is in the school data, and because this student graduated it will remove the student information
     * @param studentId
     */
    public void graduateStudent(int studentId) {
        if ( studentsMap.containsKey( studentId ) ) {
            Student student = studentsMap.get( studentId );
            for ( Course course : student.getCourses() ) {
                course.unRegister( studentId ); // just in case, requirement is not clear
            }
            studentsMap.remove( studentId );
        }
    }
}
