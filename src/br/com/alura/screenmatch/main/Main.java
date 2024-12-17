package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.calculation.MovieSearcher;
import br.com.alura.screenmatch.calculation.PropertiesHandler;
import br.com.alura.screenmatch.models.AudiovisualContent;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<AudiovisualContent> audioVisualList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String movieName = "";
        String apiKey = "";

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        PropertiesHandler propsHandler = new PropertiesHandler();
        apiKey = propsHandler.getAPIKeyFromProperties(".properties");
        if(apiKey == null) { return; }

        while(!movieName.equalsIgnoreCase("exit")) {
            System.out.println("Enter a movie to search:");
            movieName = scanner.nextLine();
            if (movieName.equalsIgnoreCase("exit")) { break;}

            MovieSearcher searcher = new MovieSearcher(apiKey,gson);

            audioVisualList.add(searcher.searchAudioVisualContent(movieName));
        }
        scanner.close();

        try(FileWriter writer = new FileWriter("Movies.json")){
            writer.write(gson.toJson(audioVisualList));
        }catch (IOException error){
            System.err.println("Error writing file: " + error.getMessage());
        }
    }
}
