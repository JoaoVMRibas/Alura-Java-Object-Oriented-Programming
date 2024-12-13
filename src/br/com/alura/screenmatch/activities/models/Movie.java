package br.com.alura.screenmatch.activities.models;

public class Movie extends AudiovisualContent implements Rating {
    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getRating() {
        return (int) this.getAverageRatings()/2;
    }
}
