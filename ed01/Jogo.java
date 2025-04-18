import java.util.Random;

public class Jogo {
    
    private Jogador jogador;
    private int numeroSecreto;

    
    public Jogo(Jogador jogador) {
        this.jogador = jogador;
        Random rand = new Random();
        this.numeroSecreto = rand.nextInt(100) + 1; 
    }

   
    public String jogar(int tentativa) {
        jogador.incrementarTentativas();

        if (tentativa < numeroSecreto) {
            return "O número secreto é MAIOR.";
        } else if (tentativa > numeroSecreto) {
            return "O número secreto é MENOR.";
        } else {
            
            int pontos = calcularPontuacao();
            jogador.atualizarPontuacao(pontos);
            return "Parabéns! Você acertou o número secreto. Pontos ganhos: " + pontos;
        }
    }

    
    private int calcularPontuacao() {
        
        int base = 100;
        int pontos = Math.max(10, base - jogador.getTentativas() * 10);
        return pontos;
    }
}
