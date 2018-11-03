package Midterm;

public class Midterm {

    private String courseName;
    private static int numTestes;
    private Integer numQuestions;
    private double[] scores;

    public Midterm(String courseName, Integer numQuestions, double[] scores) {
        this.courseName = courseName;
        this.numQuestions = numQuestions;
        this.scores = scores;
    }

    public void midterm(String name, Integer score){

    }
    public void getScore(double[] scores){

    }
    public void calcAverage(double score){

    }
    public char getLetterGrade(double max){
        double score;
        return 't';
    }
    public Integer getNumQuestions(){
        return numQuestions;
    }

    private double sumScores(){
        return 0;
    }
    private static boolean makeTest(){
        numTestes += 1;
        return true;
    }
}
