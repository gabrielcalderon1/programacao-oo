/**
 * Classe class.
 */
public abstract class ContatoBase implements Contato {
    private String nome;
    private String telefone;
    private String email;

/**
 * Método public String getNome().
 */
    public String getNome() { return nome; }
/**
 * Método public void setNome(String nome).
 */
    public void setNome(String nome) {
        if (nome == null || nome.length() < 3) {
            throw new IllegalArgumentException("Nome deve ter pelo menos 3 caracteres.");
        }
        this.nome = nome;
    }

/**
 * Método public String getTelefone().
 */
    public String getTelefone() { return telefone; }
/**
 * Método public void setTelefone(String telefone).
 */
    public void setTelefone(String telefone) { this.telefone = telefone; }

/**
 * Método public String getEmail().
 */
    public String getEmail() { return email; }
/**
 * Método public void setEmail(String email).
 */
    public void setEmail(String email) { this.email = email; }
}