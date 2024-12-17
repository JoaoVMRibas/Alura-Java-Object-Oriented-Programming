package br.com.alura.screenmatch.calculation;

import br.com.alura.screenmatch.models.AudiovisualContent;
import br.com.alura.screenmatch.models.AudiovisualContentOmdb;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MovieSearcher {
    private final Gson gson;
    private final String apiKey;
    AudiovisualContentOmdb audioVisualOmdb;

    public MovieSearcher(String apiKey, Gson gson){
        this.gson = gson;
        this.apiKey = apiKey;
    }

    public AudiovisualContent searchAudioVisualContent(String audioVisualName){
        try(HttpClient client = HttpClient.newHttpClient()){
            audioVisualName = audioVisualName.replace(" ","+");
            String uri = String.format("https://www.omdbapi.com/?t=%s&apikey=%s",audioVisualName, this.apiKey);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            this.audioVisualOmdb = gson.fromJson(response.body(), AudiovisualContentOmdb.class);
        }catch (IOException | InterruptedException error){
            System.out.println("Error sending request. Error message: " + error.getMessage());
        }catch (NumberFormatException error) {
            System.out.println("Number format error. Error message: " + error.getMessage());
        }catch (IllegalArgumentException error) {
            System.out.println("Error creating URI. Error message: " + error.getMessage());
        }
        return new AudiovisualContent(audioVisualOmdb);
    }
}
