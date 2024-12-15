package br.com.alura.screenmatch.activities.main;

import br.com.alura.screenmatch.activities.models.AudiovisualContent;
import br.com.alura.screenmatch.activities.models.Movie;
import br.com.alura.screenmatch.activities.models.Series;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Movie topGun = new Movie("Top Gun - Maverick",2022);
        Movie avatar = new Movie("Avatar",2009);
        Movie avengers = new Movie("Vingadores: Ultimato",2019);
        Series lost = new Series("Lost",2004);

        List<AudiovisualContent> listOfViewed = new ArrayList<>();
        listOfViewed.add(topGun);
        listOfViewed.add(avengers);
        listOfViewed.add(avatar);
        listOfViewed.add(lost);

        System.out.println("Ordered list:");
        Collections.sort(listOfViewed);
        for (AudiovisualContent item : listOfViewed) {
            System.out.println(item);
        }
    }
}
