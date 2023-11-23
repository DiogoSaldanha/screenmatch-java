package br.com.screenmatch.calculations;

public class RecommendationFilter {
    public void filter(Classified c) {
        if (c.getClassification() >= 4){
            System.out.println("Este título está entre os mais bem avaliados no momento.");
        } else if (c.getClassification() >= 2) {
            System.out.println("Título bem avaliado no momento.");
        } else {
            System.out.println("Adicione à sua lista para assistir mais tarde.");
        }
    }
}
