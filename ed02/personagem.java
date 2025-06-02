/**
 * Classe base para representar um personagem do jogo.
 */
public abstract class Personagem {
    protected String nome;
    protected int hp;
    protected int ataqueBase;

    public Personagem(String nome, int hp, int ataqueBase) {
        this.nome = nome;
        this.hp = hp;
        this.ataqueBase = ataqueBase;
    }

    /**
     * Ataca um inimigo.
     * @param inimigo Personagem alvo do ataque.
     */
    public abstract void atacar(Personagem inimigo);

    /**
     * Recebe um ataque.
     * @param dano Dano a ser sofrido.
     */
    public abstract void defender(int dano);

    /**
     * Usa a habilidade especial do personagem.
     */
    public abstract void usarHabilidadeEspecial();

    /**
     * Mostra o status atual do personagem.
     */
    public void status() {
        System.out.println(nome + " | HP: " + hp);
    }
}
