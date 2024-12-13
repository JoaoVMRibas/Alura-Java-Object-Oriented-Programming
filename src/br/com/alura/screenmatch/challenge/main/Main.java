package br.com.alura.screenmatch.challenge.main;
import br.com.alura.screenmatch.challenge.models.FavoriteAudio;
import br.com.alura.screenmatch.challenge.models.Music;
import br.com.alura.screenmatch.challenge.models.Podcast;

public class Main {
    public static void main(String[] args) {
        Music music = new Music();
        music.setTitle("We Will Rock You");
        music.setSinger("Queen");

        for (int i = 0; i < 600; i++) {
            music.playAudio();
        }
        for (int i = 0; i < 30; i++) {
            music.giveLike();
        }

        Podcast podcast = new Podcast();
        podcast.setTitle("Flow Podcast");
        podcast.setDescription("Flow Podcast is one of the most popular podcasts in Brazil, " +
                "known for its relaxed format and long, in-depth conversations.");
        podcast.setHost("Igor");

        for (int i = 0; i < 300; i++) {
            podcast.playAudio();
        }
        for (int i = 0; i < 190; i++) {
            podcast.giveLike();
        }

        FavoriteAudio favorite = new FavoriteAudio();

        //System.out.println("Music rating: " + music.getRating());
        favorite.isFavorite(music);
        //System.out.println("Podcast rating: " + podcast.getRating());
        favorite.isFavorite(podcast);
    }
}
