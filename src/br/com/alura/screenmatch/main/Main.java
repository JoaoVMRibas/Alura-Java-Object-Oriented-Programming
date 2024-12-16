package br.com.alura.screenmatch.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
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
            String uri = "https://www.omdbapi.com/?t=Matrix&apikey="+apiKey;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        }catch (IOException | InterruptedException e){
            System.out.println("Error sending request: " + e.getMessage());
        }
    }
}
