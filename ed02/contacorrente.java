/**
 * Conta Corrente com aplicação de 0.1% de juros ao dia.
 */
public class ContaCorrente extends Conta {

    public ContaCorrente(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        saldo *= 1.001; // 0.1%
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Corrente - Cliente: " + cliente + " | Saldo: " + saldo);
    }
}
