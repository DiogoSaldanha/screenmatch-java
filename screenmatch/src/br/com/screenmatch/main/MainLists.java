package br.com.screenmatch.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import br.com.screenmatch.models.Movie;
import br.com.screenmatch.models.Series;
import br.com.screenmatch.models.Title;

public class MainLists {
    public static void main(String[] args) {
        Movie m1 = new Movie("Tarzan", 1999);
        m1.rate(9);
        Movie m2 = new Movie("BladeRunner 2049", 2017);
        m2.rate(6);
        var m3 = new Movie("Avatar", 2023);
        m3.rate(10);
        Series s1 = new Series("Game of Thrones", 2011);

        List<Title> titlesList = new LinkedList<>();
        titlesList.add(m1);
        titlesList.add(m2);
        titlesList.add(m3);
        titlesList.add(s1);

        for (Title title : titlesList) {
            System.out.println("Nome do título: " + title.getName());
            if (title instanceof Movie mov){
                System.out.println("Classificação: " + mov.getClassification()); // Apenas classificação dos filmes é mostrada, pois série não possui o método getClassification()
            }
        }

        System.out.println("\n");

        //Foreach  onde apenas as classificações mais altas aparecem:
        for (Title title : titlesList) {
            System.out.println("Nome do título: " + title.getName());
            if (title instanceof Movie mov && mov.getClassification() > 4){
                System.out.println("CLassificação: " + mov.getClassification());
            }
        }

        ArrayList<String> searchForArtist = new ArrayList<>();
        searchForArtist.add("Cillian Murphy");
        searchForArtist.add("Nicole Kidman");
        searchForArtist.add("Tom Cruise");
        searchForArtist.add("Adam Sandler");

        System.out.println("\nLista de artistas:" + searchForArtist);
        Collections.sort(searchForArtist);
        System.out.println("Lista de artistas ordenada por ordem alfabética: " + searchForArtist);

        System.out.println("Lista de títulos:" + titlesList);
        Collections.sort(titlesList); // Para fazer essa chamada, é necessário implementar a interface 'Comparable' em 'Title' e sobreescrever o método 'compareTo'.
        System.out.println("Lista de artistas ordenada por ordem alfabética: " + titlesList);
        titlesList.sort(Comparator.comparing(Title::getReleaseYear)); //Usando Comparator para comparar a partir do ano de lanÇamento.
        System.out.println("Lista de artistas ordenada por ordem de ano: " + titlesList);
    }
}
