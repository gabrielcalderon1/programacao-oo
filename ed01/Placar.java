import java.util.Random;

public class Placar {
    
    private ArrayList<Jogador> ranking;

    
    public Placar() {
        ranking = new ArrayList<>();
    }

    
    public void adicionarJogador(Jogador j) {
        
        for (Jogador jogador : ranking) {
            if (jogador.getNome().equalsIgnoreCase(j.getNome())) {
                return; 
            }
        }
        ranking.add(j);
    }

    
    public void mostrarRanking() {
        System.out.println("===== Ranking de Jogadores =====");
        for (Jogador jogador : ranking) {
            System.out.println(jogador.getNome() + " - Pontuação: " + jogador.getPontuacao());
        }
        System.out.println("================================");
    }
}
