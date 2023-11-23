package br.com.screenmatch.main;
import java.util.ArrayList;
import br.com.screenmatch.calculations.RecommendationFilter;
import br.com.screenmatch.calculations.TimeCalculator;
import br.com.screenmatch.models.Episodes;
import br.com.screenmatch.models.Movie;
import br.com.screenmatch.models.Series;

public class Main {
    public static void main(String[] args) {
        Movie m1 = new Movie("Tarzan", 1999);
        m1.setMinuteDuration(98);
        m1.setPlanIncluded(true);
        m1.showInfo();

        m1.rate(4);
        m1.rate(3.5f);
        m1.rate(7.8f);
        m1.rate(9);
        System.out.println("\nMédia de avaliações do filme: " + m1.getName() + " -> " + m1.getAvgRating());

        Movie m2 = new Movie("BladeRunner 2049", 2017);
        m2.setMinuteDuration(163);
        m2.setPlanIncluded(true);

        m2.rate(7.5f);
        m2.rate(10);
        System.out.println("Média de avaliações do filme: " + m2.getName() + " -> " + m2.getAvgRating());

        var m3 = new Movie("Avatar", 2023);
        m3.setMinuteDuration(192);
        m3.setPlanIncluded(true);
        m3.rate(10);
        System.out.println("Média de avaliações do filme: " + m3.getName() + " -> " + m3.getAvgRating());

        Series s1 = new Series("Game of Thrones", 2011);
        s1.setMinutesEpisode(58);
        s1.setPlanIncluded(true);
        s1.setSeasons(7);
        s1.setSeasonsEpisodes(10);
        System.out.println(("\nTempo para maratonar GOT: " + s1.getMinuteDuration() + "\n"));

        TimeCalculator tc1 = new TimeCalculator();
        tc1.include(m1);
        tc1.include(m2);
        tc1.include(s1);
        System.out.println("Tempo total para maratonar todos os títulos inseridos: "+ tc1.getTotalTime() + "\n");

        Episodes e1 = new Episodes();
        e1.setEpName("Battle of Bastards.");
        e1.setNum(1);
        e1.setSeries(s1);
        e1.setTotalViews(10);

        RecommendationFilter filter = new RecommendationFilter();
        System.out.println(String.format("O filme %s é avaliado em %f e tem %d de classificação.", m1.getName(), m1.getAvgRating(), m1.getClassification()));
        filter.filter(m1);
        System.out.println(String.format("\nO filme %s é avaliado em %f e tem %d de classificação.", m2.getName(), m2.getAvgRating(), m2.getClassification()));
        filter.filter(m2);
        System.out.println(String.format("\nO episódio %s tem %d de classificação.", e1.getEpName(), e1.getClassification()));
        filter.filter(e1);

        ArrayList<Movie> movieList = new ArrayList<>();
        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);

        System.out.println("\nTamanho da lista de filmes: " + movieList.size());
        System.out.println("Lista de filmes: " + movieList);
        System.out.println("Nome do primeiro filme da lista: " + movieList.get(0).getName());
        System.out.println("toString do primeiro filme da lista: " + movieList.get(0).toString() + "\n");
    }
}