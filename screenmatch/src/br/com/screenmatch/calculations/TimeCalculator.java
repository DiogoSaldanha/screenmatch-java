package br.com.screenmatch.calculations;
import br.com.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTime = 0;

    public int getTotalTime() {
        return this.totalTime;
    } 

    // public void include(Movie m) {
    //     this.totalTime += m.getMinuteDuration();
    // }

    // public void include(Series s) {
    //     this.totalTime += s.getMinuteDuration();
    // }

    public void include(Title title) {
        System.out.println("Adicionando duração em minutos de " + title);
        this.totalTime += title.getMinuteDuration();
    }
}
