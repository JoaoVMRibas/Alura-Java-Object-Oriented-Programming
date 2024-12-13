package br.com.alura.screenmatch.models;

public class AudiovisualContent {
    private String name;
    private int yearOfRelease;
    private boolean included;
    private int totalDurationMinutes;
    private double sumOfRating;
    private int qtOfReviews;

    public void setName(String name) {
        this.name = name;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public void setIncluded(boolean included) {
        this.included = included;
    }

    public void setTotalDurationMinutes(int totalDurationMinutes) {
        this.totalDurationMinutes = totalDurationMinutes;
    }

    public String getName() {
        return this.name;
    }

    public int getYearOfRelease() {
        return this.yearOfRelease;
    }

    public boolean isIncluded() {
        return this.included;
    }

    public int getTotalDurationMinutes() {
        return this.totalDurationMinutes;
    }

    public int getQuantityOfReviews() {
        return this.qtOfReviews;
    }

    public void addNewRating(double rating) {
        this.sumOfRating += rating;
        this.qtOfReviews++;
    }

    public double getAverageRatings() {
        return sumOfRating/ qtOfReviews;
    }

    public void displaysTechnicalFeatures() {
        String display = """
                Name: %s.
                Year of release: %d.
                Is included: %b.
                Rating: %.2f.
                Number of reviews: %d.
                Duration: %d min.
                """.formatted(name,yearOfRelease, included, (sumOfRating/ qtOfReviews), qtOfReviews, totalDurationMinutes);
        System.out.println(display);
    }
}
