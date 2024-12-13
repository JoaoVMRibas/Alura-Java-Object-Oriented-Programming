package br.com.alura.screenmatch.challenge.models;

public class Podcast extends Audio{
    private String host;
    private String description;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getRating() {
        if((this.getPlaybackTotal()*0.7)<this.getLikes()) {
            return 10;
        }else{
            return 6;
        }
    }
}
