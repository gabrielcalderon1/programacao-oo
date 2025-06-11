/**
 * Classe PessoaFisica.
 */
public class PessoaFisica extends ContatoBase {
    private String cpf;

/**
 * Método public String getCpf().
 */
    public String getCpf() { return cpf; }
/**
 * Método public void setCpf(String cpf).
 */
    public void setCpf(String cpf) {
        if (!cpf.matches("\\d{11}")) {
            throw new IllegalArgumentException("CPF deve conter 11 dígitos.");
        }
        this.cpf = cpf;
    }

    @Override
/**
 * Método public String toString().
 */
    public String toString() {
        return "PF | Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Email: " + getEmail() + ", CPF: " + cpf;
    }
}