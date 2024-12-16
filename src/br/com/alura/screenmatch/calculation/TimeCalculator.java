package br.com.alura.screenmatch.calculation;

import br.com.alura.screenmatch.models.AudiovisualContent;

public class TimeCalculator {
    private int totalTime = 0;

    public int getTotalTime() {
        return totalTime;
    }

    public void addAudiovisualContentTime(AudiovisualContent a) {
        this.totalTime += a.getTotalDurationMinutes();
    }
}
