package Project1;
import java.util.HashMap;
import java.io.*;
import java.util.*;

public class School {

    private String schoolName;

    public School(String name) {
        this.schoolName = name;
    }

    private HashMap<Integer, Instructor> instructor  = new HashMap<>();
    private HashMap<Integer, Student> students = new HashMap<>();
    private HashMap<Integer, Course> courses = new HashMap<>();


    public void readData(String filePath) throws FileNotFoundException {
        Scanner s = new Scanner(new File(filePath));
        int numIns = s.nextInt();
        s.nextLine();
        for(int i = 0; i < numIns;i++){
            String instructorInfo = s.nextLine();
            String[] listOfInstrcutor = instructorInfo.split(",", -1);
            addInstructor(Integer.parseInt(listOfInstrcutor[0]), listOfInstrcutor[1], listOfInstrcutor[2], listOfInstrcutor[3]);
        }
        int numCor = s.nextInt();
        s.nextLine();
        for(int i = 0; i < numCor;i++){
            String CourseInfo = s.nextLine();
            String[] listOfCourse = CourseInfo.split(",", -1);
            addCourse(Integer.parseInt(listOfCourse[0]), listOfCourse[1], Integer.parseInt(listOfCourse[2]), listOfCourse[3]);
        }
        int numStudent = s.nextInt();
        s.nextLine();
        for(int i = 0; i < numStudent;i++){
            String Studentinfo = s.nextLine();
            String[] listOfStudent = Studentinfo.split(",", -1);
            addStudent(Integer.parseInt(listOfStudent[0]), listOfStudent[1]);
        }
        s.close();
        System.out.println("Done.");
//        readInfoMessage();
    }

//    public void readInfoMessage(){
//        if(instructor.get( employeeNumber ).equals(employeeNumber)){
//            System.out.println("Instructor info reading failed – Employee number" + employeeNumber + " already used.");
//        }
//        if(students.get(studentID).equals( studentID )){
//            System.out.println("Student info reading failed – Student ID " + studentID + " already used.");
//        }
//        System.out.println("Done.");
//    }

    public void schoolInfo() {
        System.out.println("School Name: " + schoolName);
        System.out.println("Instructor Information \n");
        System.out.println(instructor.toString());
        System.out.println("Course Information \n");
        System.out.println(courses.toString());
        System.out.println("Student Information \n");
        System.out.println(students.toString());
    }

    public boolean searchByEmail(String email) {
        if ( instructor.containsValue(email) && email != null) { // never go inside
            System.out.println( "Search Key: " + email );
            System.out.println( "Employee Number: " + instructor.get( email ).getEmployeeNum() );
            System.out.println( "\tName: " + instructor.get( email ).getName() + "\n Phone: " + instructor.get( email ).getPhoneNumber() );
            return true;
        } else {
            System.out.println( "Search Key: " + email );
            System.out.println( "No employee with email " + email );
            return false;
        }
    }

    public void addInstructor(int employeeNumber, String name, String email, String phonenumber) {
        if(!instructor.containsKey( employeeNumber )){
            Instructor instructorInfo = new Instructor( employeeNumber, name, email, phonenumber );
            instructor.put( employeeNumber,instructorInfo );
        }
    }

    public void addCourse(int courseId, String courseName, int capacity, String location) {
        if(!courses.containsKey( courseId )){
            Course courseInfo = new Course( courseId, courseName, capacity, location );
            courses.put( courseId, courseInfo );
        }else {
            System.out.println("Course addition failed - Course number " + courseId + " already used.");
        }
    }
    public void addStudent(int studentId, String name) {
        if(!students.containsKey( studentId )){
            Student studentInfo = new Student( studentId, name);
            students.put( studentId, studentInfo );
        }
    }

    public void assignInstructor(int courseId, int employeeNumber) {
        if(!instructor.containsKey( employeeNumber )){
            System.out.println("Instructor " + employeeNumber + " does not exist.");
        }
// TODO: assign ins to the course map?? and link course and instructor
//        courses.get( courseId ).setInstructorName( instructor.get( employeeNumber ).getName());
    }

    public void register(int courseId, int studentID) {
        if(!students.containsKey( studentID )){
            System.out.println("Student " + studentID + " does not exist.");
        }
        courses.get( courseId ).setCurrentEnrollment(+1);
        // if the student ID is not in the course info the that course you know it is not in the class

    }

    public void putScore(int courseId, int studentID, double score) {
        if(students.containsKey( studentID ) && (courses.containsKey( courseId )) && studentID == courseId){
            courses.get( courseId ).setStudentScore( score );
        }
        if(!courses.get( courseId ).equals( studentID )){ // TODO: Fix, print also in the read section! does not what I want
            System.out.println("Student " + studentID + " is not enrolled in " + courseId + ".");
        }
        // TODO: assign student to the course map?? add score ??
//        courses.get( courseId ).setStudentScore( score );

    }

    public void unRegister(int courseID, int studentID) {


    }

    // detailed course information
    public void courseInfo(int courseId) {
        System.out.println("Course Number: " + courseId);
        System.out.println("Instructor: " + courses.get( courseId ).getInstructorName()); // TODO: name is null, fix
        System.out.println("Course Title: " + courses.get( courseId ).getCourseTitle());
        System.out.println("Room: " + courses.get( courseId ).getLocation());
        System.out.println("Total Enrolled: " + courses.get( courseId ).getCurrentEnrollment());
        System.out.println("Course Average: " + courses.get( courseId ).getStudentScore());
    }

    public Course getCourse(int courseId) {
        Course getCourses = courses.get( courseId );
        if(!getCourses.equals( courseId )) return null;
        return getCourses;

    }
    // should not delete the course if students are enrolled in the course.
    public void deleteCourse(int courseId) {
        if( courses.get( courseId ).getCurrentEnrollment() <= 0 ){
            courses.remove( courseId );

        }else {
            System.out.println("Course deletion failed – Enrolled student(s) in the class");
        }
    }

    public void courseInfo() {
        System.out.println("Number of Courses: " + courses.size());
//        for(Integer i : courses.keySet()){
//            System.out.println(i + ": " +  ) ));
//        }
//        System.out.println(courses.getCourseNum + ":" + courses.getCurrentEnrollment + " enrolled");
//        System.out.println(courses.toString());

    }
    public Instructor getInstructor(int employeeNumber) {
        Instructor getIns = instructor.get( employeeNumber );
        if(!getIns.equals( employeeNumber )) return null;
        return getIns;
    }

    public Student getStudent(int studentId) {
        Student getS = students.get( studentId );
        if(!getS.equals( studentId )) return null;
        return getS;
    }
    // should drop all of the coursed the student is enrolled in.
    public void graduateStudent(int studentId) {

    }
    @Override
    public String toString(){
        return "School Name: " + schoolName;
    }
}
