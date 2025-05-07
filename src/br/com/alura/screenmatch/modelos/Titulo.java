package br.com.alura.screenmatch.modelos;

import java.util.Scanner;

public class Titulo {
    private String nome;
    private int anoDeLancamento;
    private int duracaoEmMinutos;
    private boolean incluidoNoPlano;
    private double avaliacao;
    private int totalDeAvaliacoes;

    public void exibirFichaTecnica () {
        System.out.printf("""
                nome: %s
                ano de lançamento: %d
                duração (em minutos): %d
                """, nome,anoDeLancamento,duracaoEmMinutos);
    }

    public void avaliar (Scanner leitura) {
        System.out.print("Insira a sua nota 0 a 10: ");
        int nota = leitura.nextInt();
        leitura.nextLine();
        if (nota < 0 || nota > 10){
            System.out.println("Nota inválida!");
        }
        else{
            avaliacao += nota;
            totalDeAvaliacoes++;
        }
    }

    public double media () {
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


}
