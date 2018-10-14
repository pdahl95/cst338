package Lab7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lab7Test {
    Lab7 lab1;

    @BeforeEach
    void setUp(){
        System.out.println("This runs before each");
        lab1 = null;
    }
    @Test
    void getFoo(){
        int fooVal = 42;
        lab1 = new Lab7( fooVal, "Arthur" , 200.25 );
        assertEquals( lab1.getFoo(), fooVal, "Values don't match!" );
//        assertEquals( lab1.getFoo(), fooVal+1, "Values don't match!" );
        assertNotNull( lab1.getFoo(), "Values is not null" );

    }

}