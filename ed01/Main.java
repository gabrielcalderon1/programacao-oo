import java.util.Random;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Placar placar = new Placar();
 
        System.out.print("Informe o nome do jogador: ");
        String nome = scanner.nextLine();
 
        Jogador jogador = new Jogador(nome);
        Jogo jogo = new Jogo(jogador);
 
        boolean acertou = false;
 
        while (!acertou) {
            System.out.print("Digite um número (1 a 100): ");
            int tentativa = scanner.nextInt();
            String resultado = jogo.jogar(tentativa);
 
            if (resultado.equals("acertou")) {
                System.out.println("Parabéns! Você acertou!");
                System.out.println("Tentativas: " + jogador.getTentativas());
                System.out.println("Pontuação final: " + jogador.getPontuacao());
                acertou = true;
            } else {
                System.out.println("Tente um número " + resultado + "!");
            }
        }
 
        placar.adicionarJogador(jogador);
        placar.mostrarRanking();
 
        scanner.close();
    }
}