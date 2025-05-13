import java.util.Random;

/**
 * Classe base para representar um personagem do jogo de RPG.
 */
public abstract class Personagem {
    protected String nome;
    protected int hp;
    protected int ataqueBase;

    /**
     * Construtor do personagem.
     * @param nome Nome do personagem.
     * @param hp Pontos de vida (vida máxima).
     * @param ataqueBase Dano de ataque básico.
     */
    public Personagem(String nome, int hp, int ataqueBase) {
        this.nome = nome;
        this.hp = hp;
        this.ataqueBase = ataqueBase;
    }

    /**
     * Ataca um inimigo.
     * @param inimigo Personagem a ser atacado.
     */
    public abstract void atacar(Personagem inimigo);

    /**
     * Defende-se de um ataque.
     * @param dano Quantidade de dano a ser recebido.
     */
    public abstract void defender(int dano);

    /**
     * Usa a habilidade especial do personagem.
     */
    public abstract void usarHabilidadeEspecial();

    /**
     * Exibe o status atual do personagem.
     */
    public void status() {
        System.out.println(nome + " | HP: " + hp);
    }
}

/**
 * Guerreiro: forte ataque físico, defesa reduz o dano pela metade.
 * Habilidade especial: Golpe Duplo (duplica o ataque na próxima ação).
 */
class Guerreiro extends Personagem {

    /**
     * Construtor do Guerreiro.
     * @param nome Nome do guerreiro.
     */
    public Guerreiro(String nome) {
        super(nome, 150, 30);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(nome + " ataca com espada!");
        inimigo.defender(ataqueBase);
    }

    @Override
    public void defender(int dano) {
        int reduzido = dano / 2;
        System.out.println(nome + " defende com escudo e recebe apenas " + reduzido + " de dano.");
        hp -= reduzido;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa Golpe Duplo!");
        ataqueBase *= 2;
    }
}

/**
 * Mago: ataque mágico forte, defesa fraca.
 * Habilidade especial: Bola de Fogo (dano em área - fictício).
 */
class Mago extends Personagem {

    /**
     * Construtor do Mago.
     * @param nome Nome do mago.
     */
    public Mago(String nome) {
        super(nome, 100, 40);
    }

    @Override
    public void atacar(Personagem inimigo) {
        System.out.println(nome + " ataca com magia!");
        inimigo.defender(ataqueBase);
    }

    @Override
    public void defender(int dano) {
        System.out.println(nome + " recebe " + dano + " de dano.");
        hp -= dano;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " lança Bola de Fogo!");
        // Efeito fictício de dano em área
    }
}

/**
 * Arqueiro: ataque médio com chance de crítico.
 * Habilidade especial: Chuva de Flechas (3 ataques consecutivos).
 */
class Arqueiro extends Personagem {
    private Random random = new Random();

    /**
     * Construtor do Arqueiro.
     * @param nome Nome do arqueiro.
     */
    public Arqueiro(String nome) {
        super(nome, 120, 25);
    }

    @Override
    public void atacar(Personagem inimigo) {
        boolean critico = random.nextInt(100) < 20; // 20% de chance
        int dano = critico ? ataqueBase * 2 : ataqueBase;
        System.out.println(nome + (critico ? " acerta um CRÍTICO!" : " ataca com flecha."));
        inimigo.defender(dano);
    }

    @Override
    public void defender(int dano) {
        System.out.println(nome + " recebe " + dano + " de dano.");
        hp -= dano;
    }

    @Override
    public void usarHabilidadeEspecial() {
        System.out.println(nome + " usa Chuva de Flechas!");
        // Três ataques fictícios
    }
}
