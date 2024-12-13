package br.com.alura.screenmatch.challenge.models;

public class Audio {
    private String title;
    private int playbackTotal;
    private int likes = 0;
    private int rating;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public int getPlaybackTotal() {
        return playbackTotal;
    }

    public int getLikes() {
        return likes;
    }

    public int getRating() {
        return rating;
    }

    public void giveLike() {
        this.likes++;
    }

    public void playAudio() {
        this.playbackTotal++;
    }
}
