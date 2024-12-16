package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.AudiovisualContent;
import br.com.alura.screenmatch.models.AudiovisualContentOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Properties props =  new Properties();
        String apiKey = "";
        try{
            FileInputStream file = new FileInputStream(".properties");
            props.load(file);
            apiKey = props.getProperty("API_KEY");
        }catch (IOException e) {
            System.err.println("Error loading configuration file: " + e.getMessage());
        }

        try {
            System.out.println("Enter a movie to search:");
            String movieName = scanner.nextLine();

            String uri = String.format("https://www.omdbapi.com/?t=%s&apikey=%s",movieName, apiKey);
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();
            AudiovisualContentOmdb audioVisualOmdb = gson.fromJson(json, AudiovisualContentOmdb.class);
            AudiovisualContent audioVisual = new AudiovisualContent(audioVisualOmdb);
            System.out.println(audioVisual);
        }catch (IOException | InterruptedException e){
            System.out.println("Error sending request: " + e.getMessage());
        }
    }
}
