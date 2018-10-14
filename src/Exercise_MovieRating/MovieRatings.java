package Exercise_MovieRating;
import java.util.Scanner;
import java.util.ArrayList;

public class MovieRatings {

    private int[][] ratings;  // first index (row) is person, second index (column) is movie
    private String[] movies;
    private String[] people;

    public MovieRatings(String[] movies, String[] people){
        this.movies = movies;
        this.people = people;
        ratings = new int[people.length][movies.length];
        fill();
    }

    public void fill() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ratings by person -5(very bad) to +5(great). 0 means have not seen it yet. ");
        for (int person = 0; person<people.length; person++){
            System.out.println("\nEnter ratings by "+people[person]);
            for (int movie=0; movie<movies.length; movie++) {
                System.out.print(movies[movie]);
                ratings[person][movie]=in.nextInt();
            }
        }
    }

    /*
     * compare two people p1 and p2.
     * if both people like or both dislike a movie will increase score.
     * if one likes the movie and other dislikes, will decrease score.
     * a postive overall score means two people are similar.
     */
    public int compare(int[] ratings1, int[] ratings2) {
        int sum=0;
        for (int i=0; i<ratings1.length; i++) {
            sum = sum + ( ratings1[i] * ratings2[i] );
        }
        return sum;
    }

    public int findMostCompatible(int p1) {
        int max=0;
        int mostCompatible=0;
        for (int i=0; i<people.length; i++) {
            if (i==p1) continue;  // don't compare a person to themselves.
            int similar = compare(ratings[p1], ratings[i]);
            if (similar > max){
                max=similar;
                mostCompatible=i;
            }
        }
        return mostCompatible;
    }

    // recommend movies for person p1
    public ArrayList<String>  recommend(int p1) {
        int p2 = findMostCompatible(p1);
        System.out.println(people[p2] +" is most compatible with "+people[p1]);
        ArrayList<String> recommendedMovies = new ArrayList<String>();
        // find a movie that p2 likes that p1 has not seen
        for (int movie=0; movie<movies.length; movie++){
            if (ratings[p1][movie]==0 && ratings[p2][movie]>0) {
                recommendedMovies.add(movies[movie]);
            }
        }
        return recommendedMovies;
    }

}