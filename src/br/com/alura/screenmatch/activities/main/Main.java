package br.com.alura.screenmatch.activities.main;

import br.com.alura.screenmatch.activities.models.Episode;
import br.com.alura.screenmatch.activities.models.Movie;
import br.com.alura.screenmatch.activities.models.Series;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Movie topGun = new Movie("Top Gun - Maverick",2022);
        topGun.setTotalDurationMinutes(131);
        topGun.setIncluded(true);
        topGun.addNewRating(8.7);
        topGun.addNewRating(6);
        topGun.addNewRating(9.5);

        Movie avatar = new Movie("Avatar",2009);
        avatar.setTotalDurationMinutes(162);
        avatar.setIncluded(true);
        avatar.addNewRating(8.6);
        avatar.addNewRating(8);
        avatar.addNewRating(9.1);

        Movie avengers = new Movie("Vingadores: Ultimato",2019);
        avengers.setTotalDurationMinutes(181);
        avengers.setIncluded(true);
        avengers.addNewRating(8.7);
        avengers.addNewRating(9.2);
        avengers.addNewRating(9.5);

        Series lost = new Series("Lost",2004);
        lost.setIncluded(true);
        lost.setNumberOfSeasons(6);
        lost.setTotalNumberOfEpisodes(120);
        lost.setMinutesPerEpisode(43);

        Episode episode = new Episode();
        episode.setName("Episode 1");
        episode.setNumber(1);
        episode.setSeries(lost);
        episode.setLikes(57);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(topGun);
        movieList.add(avengers);
        movieList.add(avatar);
        System.out.println("List size: " + movieList.size());
        System.out.println("First element(movie): " + movieList.getFirst().getName());
        System.out.println(movieList);
    }
}
