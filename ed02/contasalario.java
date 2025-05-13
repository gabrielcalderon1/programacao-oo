/**
 * Conta Salário que não aplica juros.
 */
public class ContaSalario extends Conta {

    public ContaSalario(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        // Sem juros
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Salário - Cliente: " + cliente + " | Saldo: " + saldo);
    }
}
