import br.com.alura.screenmatch.models.Movie;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setName("Top Gun - Maverick");
        movie.setYearOfRelease(2022);
        movie.setDurationMinutes(131);
        movie.setIncluded(true);

        movie.addNewRating(8.7);
        movie.addNewRating(6);
        movie.addNewRating(9.5);

        //double averageR = movie.getAverageRatings();
        //System.out.println(averageR);

        //int numberOfReviews = movie.getQuantityOfReviews();
        //System.out.println(numberOfReviews);

        //movie.displaysTechnicalFeatures();
    }
}
