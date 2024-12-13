package br.com.alura.screenmatch.challenge.models;

public class FavoriteAudio {
    public void isFavorite(Audio audio) {
        if(audio.getRating() > 8) {
            System.out.println(audio.getTitle() + " - One of the most listened to and reproduced!");
        }else {
            System.out.println(audio.getTitle() + " - A good audio.");
        }
    }
}
