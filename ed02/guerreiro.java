/**
 * Guerreiro: ataque físico forte, defesa reduz dano pela metade.
 */
public class Guerreiro extends Personagem {

    public Guerreiro(String nome) {
        super(nome, 150, 30);
    }

    @Override
    public void atacar(Personagem inimigo) {
        inimigo.defender(ataqueBase);
    }

    @Override
    public void defender(int dano) {
        hp -= dano / 2;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa Golpe Duplo!");
        // Dano duplo
        ataqueBase *= 2;
    }
}
