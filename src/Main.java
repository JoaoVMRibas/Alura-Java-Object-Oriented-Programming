import br.com.alura.screenmatch.calculation.TimeCalculator;
import br.com.alura.screenmatch.models.Episode;
import br.com.alura.screenmatch.models.Movie;
import br.com.alura.screenmatch.models.RecommendationFilter;
import br.com.alura.screenmatch.models.Series;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie();
        movie.setName("Top Gun - Maverick");
        movie.setYearOfRelease(2022);
        movie.setTotalDurationMinutes(131);
        movie.setIncluded(true);
        movie.addNewRating(8.7);
        movie.addNewRating(6);
        movie.addNewRating(9.5);

        Series lost = new Series();
        lost.setName("Lost");
        lost.setYearOfRelease(2004);
        lost.setIncluded(true);
        lost.setNumberOfSeasons(6);
        lost.setTotalNumberOfEpisodes(120);
        lost.setMinutesPerEpisode(43);

        TimeCalculator calculator = new TimeCalculator();
        calculator.addAudiovisualContentTime(movie);
        calculator.addAudiovisualContentTime(lost);

        RecommendationFilter recommendation = new RecommendationFilter();
        // recommendation.isRecommended(movie);

        Episode episode = new Episode();
        episode.setName("Episode 1");
        episode.setNumber(1);
        episode.setSeries(lost);
        episode.setLikes(57);
        recommendation.isRecommended(episode);

    }
}
