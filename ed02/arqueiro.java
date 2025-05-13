import java.util.Random;

/**
 * Arqueiro: ataque com chance de crítico, habilidade com múltiplos ataques.
 */
public class Arqueiro extends Personagem {
    private Random random = new Random();

    public Arqueiro(String nome) {
        super(nome, 120, 25);
    }

    @Override
    public void atacar(Personagem inimigo) {
        boolean critico = random.nextInt(100) < 20; // 20% de chance
        int dano = critico ? ataqueBase * 2 : ataqueBase;
        inimigo.defender(dano);
    }

    @Override
    public void defender(int dano) {
        hp -= dano;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " dispara Chuva de Flechas!");
        // Três ataques
    }
}
