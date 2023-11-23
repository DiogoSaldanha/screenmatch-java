package br.com.screenmatch.models;

public class Series extends Title{
    private int seasons;
    private int seasonsEpisodes;
    private boolean active;
    private int minutesEpisode;

    public Series(String name, int releaseYear) {
        super(name, releaseYear);
    }    

    public int getSeasons() {
        return seasons;
    }
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }
    public int getSeasonsEpisodes() {
        return seasonsEpisodes;
    }
    public void setSeasonsEpisodes(int seasonsEpisodes) {
        this.seasonsEpisodes = seasonsEpisodes;
    }
    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }
    public float getMinutesEpisode() {
        return minutesEpisode;
    }
    public void setMinutesEpisode(int minutesEpisode) {
        this.minutesEpisode = minutesEpisode;
    }

    @Override
    public int getMinuteDuration(){
        return seasons * seasonsEpisodes * minutesEpisode;
    }

    @Override
    public String toString() {
        return "Série: " + this.getName() + " (" + this.getReleaseYear() + ")";
    }
}
