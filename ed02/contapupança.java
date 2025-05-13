/**
 * Conta Poupança com aplicação de 0.08% de juros ao dia.
 */
public class ContaPoupanca extends Conta {

    public ContaPoupanca(String cliente, double saldo) {
        super(cliente, saldo);
    }

    @Override
    public void aplicarJurosDiarios() {
        saldo *= 1.0008; // 0.08%
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("Extrato Conta Poupança - Cliente: " + cliente + " | Saldo: " + saldo);
    }
}
