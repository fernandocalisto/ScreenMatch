package br.com.alura.screenmatch.calculos;

import br.com.alura.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal;

    public String getTempoTotal() {
        return "O tempo total para assistir esses títulos é de " + tempoTotal + " minutos!";
    }

    public void inclui(Titulo titulo) {
        System.out.println("Adicionando duração em minutos de: " + titulo.getNome());
        tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
