package br.com.alura.screenmatch.main;

import br.com.alura.screenmatch.models.AudiovisualContent;
import br.com.alura.screenmatch.models.AudiovisualContentOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<AudiovisualContent> audioVisualList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Properties props =  new Properties();
        String movieName = "";
        String apiKey;
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        try(FileInputStream file = new FileInputStream(".properties")){
            props.load(file);
            apiKey = props.getProperty("API_KEY");
        }catch (IOException error) {
            System.err.println("Error loading configuration file: " + error.getMessage());
            return;
        }
        if(apiKey.isEmpty()){
            System.err.println("API Key is missing in the configuration.");
            return;
        }

        while(!movieName.equalsIgnoreCase("exit")) {
            try (HttpClient client = HttpClient.newHttpClient()){
                System.out.println("Enter a movie to search:");
                movieName = scanner.nextLine();
                if (movieName.equalsIgnoreCase("exit")) { break;}
                movieName = movieName.replace(" ","+");

                String uri = String.format("https://www.omdbapi.com/?t=%s&apikey=%s",movieName, apiKey);
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(uri))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                AudiovisualContentOmdb audioVisualOmdb = gson.fromJson(response.body(), AudiovisualContentOmdb.class);
                AudiovisualContent audioVisual = new AudiovisualContent(audioVisualOmdb);
                audioVisualList.add(audioVisual);

            }catch (IOException | InterruptedException error){
                System.out.println("Error sending request. Error message: " + error.getMessage());
            }catch (NumberFormatException error) {
                System.out.println("Number format error. Error message: " + error.getMessage());
            }catch (IllegalArgumentException error) {
                System.out.println("Error creating URI. Error message: " + error.getMessage());
            }
        }
        scanner.close();

        try(FileWriter writer = new FileWriter("Movies.json")){
            writer.write(gson.toJson(audioVisualList));
        }catch (IOException error){
            System.err.println("Error writing file: " + error.getMessage());
        }
    }
}
