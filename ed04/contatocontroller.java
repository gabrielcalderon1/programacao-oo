import java.util.*;

/**
 * Classe ContatoController.
 */
public class ContatoController {
    private List<Contato> contatos = new ArrayList<>();

/**
 * Método public void adicionar(Contato contato).
 */
    public void adicionar(Contato contato) {
        if (contato instanceof PessoaFisica pf) {
            for (Contato c : contatos) {
                if (c instanceof PessoaFisica existente && existente.getCpf().equals(pf.getCpf())) {
                    throw new IllegalArgumentException("CPF já cadastrado.");
                }
            }
        } else if (contato instanceof PessoaJuridica pj) {
            for (Contato c : contatos) {
                if (c instanceof PessoaJuridica existente && existente.getCnpj().equals(pj.getCnpj())) {
                    throw new IllegalArgumentException("CNPJ já cadastrado.");
                }
            }
        }
        contatos.add(contato);
    }

/**
 * Método public void remover(String documento).
 */
    public void remover(String documento) {
        contatos.removeIf(c -> 
            (c instanceof PessoaFisica pf && pf.getCpf().equals(documento)) ||
            (c instanceof PessoaJuridica pj && pj.getCnpj().equals(documento))
        );
    }

/**
 * Método public List<Contato> listar().
 */
    public List<Contato> listar() {
        return contatos;
    }
}