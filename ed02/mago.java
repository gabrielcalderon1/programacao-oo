/**
 * Mago: ataque mágico, defesa fraca.
 */
public class Mago extends Personagem {

    public Mago(String nome) {
        super(nome, 100, 40);
    }

    @Override
    public void atacar(Personagem inimigo) {
        inimigo.defender(ataqueBase);
    }

    @Override
    public void defender(int dano) {
        hp -= dano;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " lança Bola de Fogo!");
        // Efeito de área fictício
    }
}
