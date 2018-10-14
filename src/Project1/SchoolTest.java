package Project1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Title: SchoolTest.java
 * Abstract: This is my file to test the code. It consists of 12 testcases.
 * Name: Pernille Dahl
 * Date: 2018-Oct-13
 */


class SchoolTest {

    String filePrefix = "/Users/pernilledahl/Desktop/cst338Folder/cst338/src/Project1/test/";

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void test1() throws FileNotFoundException {
        School SCD = new School( "SCD" );


        SCD.readData( filePrefix + "test1.txt" );
        SCD.schoolInfo();
        System.out.println( "\n\n===== ANSWER: 1 Instructor (Y. Byun), 1 Course (CST338), 1 Student (Alice Otter) =====\n" );
        assertEquals( SCD.getInstructorMap().size(),1 );
        assertEquals( SCD.getStudentsMap().size(),1 );
        assertEquals( SCD.getCoursesMap().size(),1 );
    }


    @Test
    void test2() throws FileNotFoundException{
        School SCD = new School("SCD");

        SCD.readData(filePrefix + "test1.txt");
        SCD.schoolInfo();
        SCD.readData(filePrefix + "test2.txt");
        System.out.println("\n\n===== ANSWER: 3 fail messages. One instructor fail, one course fail, one student fail. =====\n");
        assertEquals( SCD.getInstructorMap().size(),5 );
        assertEquals( SCD.getStudentsMap().size(),2 );
        assertEquals( SCD.getCoursesMap().size(),7 );
    }

    @Test
    void test3() throws FileNotFoundException{
        School SCD = new School("SCD");

        SCD.readData(filePrefix + "test3.txt");

        System.out.println("\n\n===== ANSWER: The program should display three failed course additions. =====\n");
        assertFalse( SCD.addCourse(301, "CST301 - Incorrect Course A", 10, "ERROR301") );
        assertTrue( SCD.addCourse(308, "CST308 - Course 308", 30, "BIT103") );
        assertTrue( SCD.addCourse( 309, "CST309 - Course 309", 40, "BIT104" ) );
        assertFalse( SCD.addCourse(308, "CST308 - Incorrect Course B", 10, "ERROR308") );
        assertFalse( SCD.addCourse(305, "CST305 - Incorrect Course C", 10, "ERROR305") );
        assertTrue( SCD.addCourse(310, "CST310 - Course 310", 50, "BIT105") );
    }

    @Test
    void test4() throws FileNotFoundException{
        School SCD = new School("SCD");

        SCD.readData(filePrefix + "test4.txt");

        assertTrue( SCD.addInstructor( 200, "B. BBB", "bbb@csumb.edu", "222-222-2222" ) );
        assertTrue( SCD.addInstructor( 300, "C. CCC", "ccc@csumb.edu", "333-333-3333" ) );
        assertTrue( SCD.addCourse( 302, "CST302 - Course 302", 20, "BIT102" ) );
        assertTrue( SCD.addCourse( 303, "CST303 - Course 303", 30, "BIT103" ) );
        assertTrue( SCD.addCourse( 304, "CST304 - Course 304", 10, "BIT104" ) );
        assertTrue( SCD.addCourse( 305, "CST305 - Course 305", 20, "BIT105" ) );
        assertTrue( SCD.assignInstructor( 301, 100 ) );
        assertTrue( SCD.assignInstructor( 302, 200 ) );
        assertTrue( SCD.assignInstructor( 303, 300 ) );
        System.out.println("\n\n===== ANSWER: Two error messages for non-existing instructors. =====\n");
        assertFalse( SCD.assignInstructor (304, 400) );
        assertFalse( SCD.assignInstructor (305, 500) );
    }

    @Test
    void test5() throws FileNotFoundException {
        School SCD = new School( "SCD" );
        Course course305;
        SCD.readData( filePrefix + "test5.txt" );

        SCD.assignInstructor (305, 100);
        SCD.register (305, 1111);
        SCD.register (305, 2222);
        SCD.putScore (305, 1111, 100.0);
        SCD.putScore (305, 2222, 50);

        course305 = SCD.getCourse(305);
        course305.updateLocation("ERROR ROOM");
        course305.updateLocation("BIT 104");

        System.out.println("\n\n===== ANSWER: CST305 (A. AAA, Course 305) at BIT 104 with 2 students (AVG: 75.00) =====\n");
        assertEquals( course305.getLocation(), "BIT 104");
        assertEquals( course305.getEnrolledStudents().size(), 2 );
        assertEquals( course305.getAverage(), 75.00 );
    }

    @Test
    void test6() throws FileNotFoundException {
        School SCD = new School( "SCD" );

        SCD.readData( filePrefix + "test6.txt" );
        SCD.assignInstructor (301, 300);
        SCD.assignInstructor (302, 300);
        SCD.assignInstructor (303, 300);
        SCD.register (301, 1111);
        SCD.register (301, 2222);
        SCD.register (301, 3333);
        SCD.register (302, 3333);
        SCD.register (302, 2222);
        SCD.register (302, 1111);
        SCD.register (303, 1111);
        SCD.register (303, 2222);
        SCD.register (303, 3333);
        SCD.unRegister  (303, 1111);
        SCD.unRegister  (303, 2222);
        SCD.unRegister  (303, 3333);

        System.out.println("\n\n===== ANSWER: 3 Courses with 301 (3 enrolled), 302 (3 enrolled) and 303 (0 enrolled) =====\n");
        assertEquals( SCD.getCoursesMap().get( 301 ).getEnrolledStudents().size(), 3 );
        assertEquals( SCD.getCoursesMap().get( 302 ).getEnrolledStudents().size(), 3 );
        assertEquals( SCD.getCoursesMap().get( 303 ).getEnrolledStudents().size(), 0 );

    }

    @Test
    void test7() throws FileNotFoundException {
        School SCD = new School( "SCD" );

        SCD.readData( filePrefix + "test7.txt" );
        SCD.register (301, 1111);
        SCD.register (301, 2222);

        System.out.println("\n\n===== ANSWER: 1 course deletion should be failed. =====\n");
        assertFalse( SCD.deleteCourse(301) );
        assertTrue( SCD.deleteCourse( 302 ));

    }

    @Test
    void test8() throws FileNotFoundException {
        School SCD = new School( "SCD" );

        SCD.readData( filePrefix + "test8.txt" );
        SCD.addStudent(2222, "BB BBBB");
        SCD.addStudent(3333, "CC CCCC");
        SCD.addStudent(4444, "DD DDDD");
        SCD.addStudent(5555, "FF FFFF");

        SCD.assignInstructor (301, 300);
        SCD.register (301, 1111);
        SCD.register (301, 2222);
        SCD.register (301, 3333);
        SCD.register (301, 4444);
        SCD.register (301, 5555);

        SCD.putScore (301, 1111, 95.0);
        SCD.putScore (301, 2222, 85.0);
        SCD.putScore (301, 3333, 75.0);
        SCD.putScore (301, 4444, 65.0);
        SCD.putScore (301, 5555, 55.0);

        System.out.println("\n\n===== ANSWER: Course 301 with 5 students enrolled (AVG: 75.00) =====\n");
        assertEquals( SCD.getCoursesMap().get( 301 ).getEnrolledStudents().size(), 5 );
        assertEquals( SCD.getCoursesMap().get( 301 ).getAverage(), 75.00 );

    }

    @Test
    void test9() throws FileNotFoundException {
        School SCD = new School( "SCD" );

        SCD.readData( filePrefix + "test9.txt" );
        SCD.assignInstructor (301, 300);
        SCD.assignInstructor (302, 300);
        SCD.register (301, 1111);
        SCD.register (301, 2222);
        SCD.register (301, 3333);
        SCD.register (302, 2222);

        SCD.putScore (301, 1111, 95.0);
        SCD.putScore (301, 2222, 85.5);
        SCD.putScore (301, 3333, 75.0);
        SCD.putScore (302, 2222, 84.5);


        Student student1 = SCD.getStudent(2222);
        System.out.println("\n\n===== ANSWER: Student BB BBBB - 2 courses enrolled. (AVG: 85.0)  =====\n");
        assertEquals( student1.getCourses().size(), 2 );
        assertEquals( student1.getAverage(), 85.00 );

    }

    @Test
    void test10() throws FileNotFoundException {
        School SCD = new School( "SCD" );

        SCD.readData( filePrefix + "test10.txt" );
        System.out.println("\n\n===== ANSWER: No employee with the email =====\n");
        assertNull( SCD.searchByEmail("ccc@csu.edu") );

        System.out.println("\n\n===== ANSWER: Employee Number: 300, Name: CCC =====\n");
        Instructor instructor = SCD.searchByEmail( "ccc@csumb.edu" );
        assertNotNull( instructor );
        assertEquals( instructor.getName(), "C. CCC" );
        assertEquals( instructor.getEmployeeNum(), 300 );

    }

    @Test
    void test11() throws FileNotFoundException {
        School SCD = new School( "SCD" );

        SCD.readData( filePrefix + "test11.txt" );

        SCD.assignInstructor (301, 300);
        SCD.assignInstructor (302, 300);
        SCD.register (301, 1111);
        SCD.register (301, 2222);
        SCD.register (302, 1111);
        SCD.register (302, 2222);

        SCD.putScore (301, 1111, 100.0);
        SCD.putScore (301, 2222, 100.0);
        SCD.putScore (302, 1111, 100.0);
        SCD.putScore (302, 2222, 100.0);

        SCD.graduateStudent(1111);

        System.out.println("\n\n===== ANSWER: There are 2 courses. Each course has only one student. =====\n");
        assertEquals( SCD.getCoursesMap().size(), 2 );
        assertEquals( SCD.getCoursesMap().get( 301 ).getEnrolledStudents().size(),1 );
        assertEquals( SCD.getCoursesMap().get( 302 ).getEnrolledStudents().size(),1 );
    }

    @Test
    void test12() throws FileNotFoundException {
        School SCD = new School( "SCD" );

        SCD.readData( filePrefix + "test12.txt" );
        SCD.assignInstructor (301, 300);
        SCD.assignInstructor (302, 300);
        SCD.register (301, 1111);
        SCD.register (301, 2222);

        SCD.putScore (301, 1111, 100.0);
        SCD.putScore (301, 2222, 100.0);

        SCD.deleteCourse(301);
        SCD.deleteCourse(302);
        System.out.println("\n\n===== ANSWER: Only 1 course (301 with 2 enrolled). =====\n");
        assertEquals( SCD.getCoursesMap().size(), 1 );
        assertEquals( SCD.getCoursesMap().get( 301 ).getEnrolledStudents().size(),2 );

    }

}