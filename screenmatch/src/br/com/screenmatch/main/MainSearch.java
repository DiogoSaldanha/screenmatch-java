package br.com.screenmatch.main;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.screenmatch.exceptions.YearConversionException;
import br.com.screenmatch.models.OmdbTitle;
import br.com.screenmatch.models.Title;

public class MainSearch {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        List<Title> titleList = new ArrayList<>();
        String search = "";

        Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .create();


        while (!search.equalsIgnoreCase("sair")) {
            System.out.println("\nDigite um filme para busca: ");
            search = scanner.nextLine();

            if (search.equalsIgnoreCase("sair")) {
                break;
            }

            String apiKey = "4e7d669c";
            String address = "https://www.omdbapi.com/?t=" + search.replace(" ", "+") + "&apikey=" + apiKey;

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(address))
                        .build();
                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                System.out.println("\nJSon recebido da API: ");
                System.out.println(json);

                OmdbTitle omdbTitle = gson.fromJson(json, OmdbTitle.class);
                Title title = new Title(omdbTitle);
                titleList.add(title);

                System.out.println("\nTítulo usando record 'OmdbTitle': ");
                System.out.println(omdbTitle);
                System.out.println("Título já convertido: ");
                System.out.println(title);

                FileWriter writer = new FileWriter("títulos.json");
                writer.write(title.toString());
                writer.close();

            } catch (NumberFormatException e) {
                System.out.println("\nHouve um erro ao converter uma String em Int. ");
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("\nErro de argumento inválido na busca, verifique o endereço da API. ");
                System.out.println(e.getMessage());
            } catch (YearConversionException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
        System.out.println(titleList);
        FileWriter writer = new FileWriter("titles.json");
        writer.write(gson.toJson(titleList));
        writer.close();

        System.out.println("\nPrograma finalizou corretamente.");
    }
}