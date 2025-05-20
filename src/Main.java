import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Episodio;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitura = new Scanner(System.in);

        Filme meuFilme = new Filme();

        meuFilme.setNome("Shaolin Soccer");
        meuFilme.setAnoDeLancamento(2001);
        meuFilme.setDuracaoEmMinutos(113);
        meuFilme.setDiretor("Stephen Chow");

        meuFilme.exibirFichaTecnica();

        Filme outroFilme = new Filme();

        outroFilme.setNome("Kung-fu Hustle");
        outroFilme.setAnoDeLancamento(2004);
        outroFilme.setDuracaoEmMinutos(99);
        outroFilme.setDiretor("Stephen Chow");

        outroFilme.exibirFichaTecnica();

        Serie minhaSerie = new Serie();

        minhaSerie.setNome("Cobra Kai");
        minhaSerie.setAnoDeLancamento(2018);
        minhaSerie.setEpisodiosPorTemporada(12);
        minhaSerie.setTemporadas(6);
        minhaSerie.setMinutosPorEpisodio(50);
        minhaSerie.isAtiva(true);

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


        Filme maisUmFilme = new Filme();

        maisUmFilme.setNome("Rocky Balboa");
        maisUmFilme.setDiretor("Sylvester Stallone");
        maisUmFilme.setAnoDeLancamento(2006);
        maisUmFilme.setDuracaoEmMinutos(102);

        ArrayList<Filme> ListaDeFilmes = new ArrayList<>();
        ListaDeFilmes.add(meuFilme);
        ListaDeFilmes.add(outroFilme);
        ListaDeFilmes.add(maisUmFilme);

        System.out.println("Tamanho da lista: " + ListaDeFilmes.size());
        System.out.println("Primeiro Filme: " + ListaDeFilmes.get(0).getNome());
        System.out.println(ListaDeFilmes);
    }
}