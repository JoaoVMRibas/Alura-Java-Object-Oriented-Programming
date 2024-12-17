package br.com.alura.screenmatch.calculation;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {
    public String getAPIKeyFromProperties(String fileAddress){
        Properties props =  new Properties();
        String apiKey;
        try(FileInputStream file = new FileInputStream(fileAddress)){
            props.load(file);
            apiKey = props.getProperty("API_KEY");
            if(apiKey.isEmpty()){
                System.err.println("API Key is missing in the configuration.");
                return null;
            }
        }catch (IOException error) {
            System.err.println("Error loading configuration file: " + error.getMessage());
            return null;
        }
        return apiKey;
    }
}
