package br.com.screenmatch.models;
import br.com.screenmatch.calculations.Classified;

public class Movie extends Title implements Classified{
    private String director;

    public Movie(String name, int releaseYear) {
        super(name, releaseYear);
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getClassification() {
        return (int) getAvgRating() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getName() + " (" + this.getReleaseYear() + ")";
    }
}
