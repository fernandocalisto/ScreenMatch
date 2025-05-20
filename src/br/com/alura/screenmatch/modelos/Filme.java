package br.com.alura.screenmatch.modelos;

import br.com.alura.screenmatch.calculos.Classificavel;

import java.util.Scanner;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public void exibirFichaTecnica() {
        super.exibirFichaTecnica();
        System.out.printf("Diretor: %s%n", getDiretor());
    }

    @Override
    public int getClassificacao() {
        return (int) media() / 2;
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";}
}