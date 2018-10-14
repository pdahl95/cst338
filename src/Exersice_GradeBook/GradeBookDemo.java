package Exersice_GradeBook;

public class GradeBookDemo
{
    public static void main(String[] args)
    {
        System.out.println("********** Grade Book1 Data **********");
        GradeBook book1 = new GradeBook( );
        book1.display( );

        System.out.println("\n\n********** Grade Book2 Data **********");
        GradeBook book2 = new GradeBook(book1);
        book2.display( );
    }
}
