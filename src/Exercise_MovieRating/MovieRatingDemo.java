package Exercise_MovieRating;


import java.util.ArrayList;
public class MovieRatingDemo {

    public static void main(String[] args) {

        String[] movies = {"Avengers: Infinity War", "Black Panther", "Coco", "Winchester", "Solo: A Star Wars Story"};
        String[] people = {"Okoye", "T\'Challa", "Matt", "Karen"};

        MovieRatings ratings = new MovieRatings(movies, people);

        ArrayList<String> rec;

        rec = ratings.recommend(1);  // what movies should Okoye see?
        System.out.println("Recommendations for " + people[1] +rec);

        rec = ratings.recommend(2); // what movies should T\'Challa see?
        System.out.println("Recommendations for " + people[2] + rec);

    }
}
