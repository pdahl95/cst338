package Project1;

import java.io.FileNotFoundException;

public class SchoolDemo1 {
    public static void main(String[] args) throws FileNotFoundException {
        School SCD = new School("SCD");

        System.out.println("===== Read Data 1 ===== ");
        SCD.readData("/Users/pernilledahl/Desktop/cst338Folder/cst338/src/Project1/tmp/test1.txt");

        System.out.println("\n===== School Info 1 ===== ");
        SCD.schoolInfo();

        System.out.println("\n===== Read Data 2 ===== ");
        SCD.readData("/Users/pernilledahl/Desktop/cst338Folder/cst338/src/Project1/tmp/test2.txt");

        System.out.println("\n===== School Info 2 ===== ");
        SCD.schoolInfo();

        System.out.println("\n===== Search by Email =====");
        SCD.searchByEmail( "ybyun@csumb.edu" );

        System.out.println( "\n===== Search by Email (fail) =====" );
        SCD.searchByEmail( "byun@csumb.edu" );

        System.out.println("\n===== End of SchoolDemo1 =====");
    }
}

