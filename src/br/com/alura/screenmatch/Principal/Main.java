package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        Filme meuFilme = new Filme("Shaolin Soccer", 2001);
        meuFilme.setDuracaoEmMinutos(113);
        meuFilme.setDiretor("Stephen Chow");
        meuFilme.setAvaliacao(5);

        meuFilme.exibirFichaTecnica();

        Filme outroFilme = new Filme("Kung-fu Hustle", 2004);
        outroFilme.setDuracaoEmMinutos(99);
        outroFilme.setDiretor("Stephen Chow");
        outroFilme.setAvaliacao(4);

        outroFilme.exibirFichaTecnica();

        Serie minhaSerie = new Serie("Cobra Kai", 2018);
        minhaSerie.setEpisodiosPorTemporada(12);
        minhaSerie.setTemporadas(6);
        minhaSerie.setMinutosPorEpisodio(50);
        minhaSerie.isAtiva(true);
        minhaSerie.setAvaliacao(4);

        minhaSerie.exibirFichaTecnica();

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(minhaSerie);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();

        episodio.setNumero(1);
        episodio.setNome("Inicio");
        episodio.setSerie(minhaSerie);
        episodio.setTotalVisualizacoes(10000);

        filtro.filtra(episodio);


        Filme maisUmFilme = new Filme("Rocky Balboa", 2006);
        maisUmFilme.setDuracaoEmMinutos(102);
        maisUmFilme.setDiretor("Sylvester Stallone");
        maisUmFilme.setAvaliacao(3);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(maisUmFilme);
        lista.add(minhaSerie);

        for (Titulo item : lista) {
            System.out.println(item);
            if (item instanceof Filme filme)
                System.out.println(item.getAvaliacao());
        }

        List<String> buscaPorArtista = new LinkedList<>();
        buscaPorArtista.add("Belchior");
        buscaPorArtista.add("Adele");
        buscaPorArtista.add("Charlie Brown Jr");

        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);
        Collections.sort(lista);
        System.out.println(lista);
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenado por ano!");
        System.out.println(lista);
    }
}