package br.com.alura.screenmatch.modelos;

import com.google.gson.annotations.SerializedName;

import java.util.Scanner;

public class Titulo implements Comparable<Titulo> {
    @SerializedName("Title")
    private String nome;
    @SerializedName("Year")
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double avaliacao;
    private int totalDeAvaliacoes;

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 2));
    }

    public void exibirFichaTecnica() {
        System.out.printf("""
                Nome: %s
                Ano de lançamento: %d
                Duração (em minutos): %d
                """, getNome(), getAnoDeLancamento(), getDuracaoEmMinutos());
    }

    public void avaliar(Scanner leitura) {
        System.out.print("Insira a sua nota 0 a 10: ");
        int nota = leitura.nextInt();
        leitura.nextLine();
        if (nota < 0 || nota > 10) {
            System.out.println("Nota inválida!");
        } else {
            avaliacao += nota;
            totalDeAvaliacoes++;
        }
    }

    public double media() {
        double media = avaliacao / totalDeAvaliacoes;
        return Math.round(media * 100) / 100;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public double getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getTotalDeAvaliacoes() {
        return totalDeAvaliacoes;
    }

    public void setTotalDeAvaliacoes(int totalDeAvaliacoes) {
        this.totalDeAvaliacoes = totalDeAvaliacoes;
    }

    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "Título: " + nome + "\n" +
                "Ano de Lançamento: " + anoDeLancamento + "\n" +
                "Duração em Minutos: " + duracaoEmMinutos;
    }
}
