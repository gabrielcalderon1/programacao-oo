/**
 * Classe PessoaJuridica.
 */
public class PessoaJuridica extends ContatoBase {
    private String cnpj;

/**
 * Método public String getCnpj().
 */
    public String getCnpj() { return cnpj; }
/**
 * Método public void setCnpj(String cnpj).
 */
    public void setCnpj(String cnpj) {
        if (!cnpj.matches("\\d{14}")) {
            throw new IllegalArgumentException("CNPJ deve conter 14 dígitos.");
        }
        this.cnpj = cnpj;
    }

    @Override
/**
 * Método public String toString().
 */
    public String toString() {
        return "PJ | Nome: " + getNome() + ", Telefone: " + getTelefone() + ", Email: " + getEmail() + ", CNPJ: " + cnpj;
    }
}