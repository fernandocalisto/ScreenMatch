package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.excecao.ErroDeConversaoDeAnoException;
import br.com.alura.screenmatch.modelos.Titulo;
import br.com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite um Filme para a Busca: ");
        String busca = leitura.nextLine().replaceAll(" ", "+");

        String endereco = "http://www.omdbapi.com/?t=" + busca + "&apikey=fd1f888c";

        try {

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);

            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
            FileWriter escrita = new FileWriter("filmes.txt");
            escrita.write(meuTitulo.toString());
            escrita.close();
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro!");
            System.out.println(e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro no argumento de busca!");
            System.out.println(e.getMessage());
        } catch (ErroDeConversaoDeAnoException e) {
            System.out.println(e.getMessage());
        }

    }
}
