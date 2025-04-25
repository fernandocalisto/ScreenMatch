import java.util.Scanner;

public class Filme {

    String nome;
    int anoDeLancamento;
    int duracaoEmMinutos;
    boolean incluidoNoPlano;
    double avaliacao;
    int totalDeAvaliacoes;

    void exibirFichaTecnica () {
        System.out.printf("""
                Nome: %s
                Ano de Lançamento: %d
                Duração (em minutos): %d
                """, nome,anoDeLancamento,duracaoEmMinutos);
    }

    void avaliar (Scanner leitura) {
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

    double media () {
        double media = avaliacao / totalDeAvaliacoes;
        return Math.round(media * 100) / 100;
    }
}
