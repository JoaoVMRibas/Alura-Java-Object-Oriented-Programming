package br.com.alura.screenmatch.calculation;

public class RecommendationFilter {
    public void isRecommended(Rating classifiable){
        if(classifiable.getRating() >= 4){
            System.out.printf("It is recommended, one of the best rated with %d stars.%n", classifiable.getRating());
        }else {
            System.out.println("Very well rated.");
        }
    }
}
