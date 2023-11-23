package br.com.screenmatch.models;

import br.com.screenmatch.exceptions.YearConversionException;

public class Title implements Comparable<Title>{
    private String name;
    private int releaseYear;
    private boolean planIncluded;
    private float sumRating;
    private int totalRatings;
    private int minuteDuration;

    public Title(String name, int releaseYear) {
        this.name = name;
        this.releaseYear = releaseYear;
    }

    public Title(OmdbTitle omdbTitle) {
        this.name = omdbTitle.title();

        if (omdbTitle.year().length() > 4){
            throw new YearConversionException("Não foi possível converter o ano pois ele tem mais de 4 caracteres.");
        }
        this.releaseYear = Integer.valueOf(omdbTitle.year());
        //this.minuteDuration = Integer.valueOf(omdbTitle.runtime().substring(0, 2)); Não era possível cadastrar titulos com runtime a partir de 3 digitos
        this.minuteDuration = Integer.parseInt(omdbTitle.runtime().replaceAll("[^0-9]", ""));
    }

    public void showInfo() {
        System.out.println("Nome: " + this.name);
        System.out.println("Ano de lançamento: " + this.releaseYear);
        System.out.println("Tempo de filme em minutos: " + minuteDuration);
        System.out.println("Incluído no plano? " + isPlanIncluded());
    }

    public void rate (float r) {
        this.sumRating += r;
        totalRatings++;
    }

    public float getAvgRating () {
        return this.sumRating / totalRatings;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public boolean isPlanIncluded() {
        return planIncluded;
    }

    public void setPlanIncluded(boolean planIncluded) {
        this.planIncluded = planIncluded;
    }

    public int getMinuteDuration() {
        return minuteDuration;
    }

    public void setMinuteDuration(int totalTime) {
        this.minuteDuration = totalTime;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    @Override
    public int compareTo(Title otherTitle) {
        return this.getName().compareTo(otherTitle.getName());
    }

    @Override
    public String toString() {
        return "(Título: " + this.getName() + " | Ano de lançamento: " + this.getReleaseYear() + " | Duração em minutos: " + this.getMinuteDuration() + ")";
    }
}
