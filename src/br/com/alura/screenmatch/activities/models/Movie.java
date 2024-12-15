package br.com.alura.screenmatch.activities.models;

import br.com.alura.screenmatch.activities.calculation.Rating;

public class Movie extends AudiovisualContent implements Rating {
    private String director;

    public Movie(String name, int yearOfRelease) {
        super(name, yearOfRelease);
    }

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

    @Override
    public String toString() {
        return "Movie: " + this.getName() + " (" + this.getYearOfRelease() + ")";
    }
}
