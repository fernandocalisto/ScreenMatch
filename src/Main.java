import java.util.Scanner;

public class Main {
    public static void main (String[] args){

        Scanner leitura = new Scanner(System.in);

        Filme meuFilme = new Filme();

        meuFilme.nome =  "Shaolin Soccer";
        meuFilme.anoDeLancamento = 2001;
        meuFilme.duracaoEmMinutos = 113;

        meuFilme.exibirFichaTecnica();

        System.out.println("Hora de Avaliar!");
        char continuar;
        do {
            meuFilme.avaliar(leitura);
            System.out.print("Deseja continuar lançando notas? (S para sim e N para não): ");
            continuar = leitura.nextLine().toUpperCase().charAt(0);
        } while (continuar != 'N');

        System.out.println("A média de notas para o filme " + meuFilme.nome + " foi de: " + meuFilme.media());
    }
}