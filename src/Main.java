import br.com.alura.screenmatch.calculation.TimeCalculator;
import br.com.alura.screenmatch.models.Movie;
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

        Series series = new Series();
        series.setName("Lost");
        series.setYearOfRelease(2004);
        series.setIncluded(true);
        series.setNumberOfSeasons(6);
        series.setTotalNumberOfEpisodes(120);
        series.setMinutesPerEpisode(43);

        TimeCalculator calculator = new TimeCalculator();
        calculator.addAudiovisualContentTime(movie);
        System.out.println(calculator.getTotalTime());
        calculator.addAudiovisualContentTime(series);
        System.out.println(calculator.getTotalTime());
    }
}
