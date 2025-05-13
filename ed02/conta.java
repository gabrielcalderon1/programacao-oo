/**
 * Classe base que representa uma conta bancária genérica.
 */
public abstract class Conta {
    protected String cliente;
    protected double saldo;

    /**
     * Construtor da conta.
     * @param cliente Nome do cliente.
     * @param saldo Saldo inicial da conta.
     */
    public Conta(String cliente, double saldo) {
        this.cliente = cliente;
        this.saldo = saldo;
    }

    /**
     * Deposita um valor na conta.
     * @param valor Valor a ser depositado.
     */
    public void depositar(double valor) {
        saldo += valor;
    }

    /**
     * Realiza um saque da conta.
     * @param valor Valor a ser sacado.
     */
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        }
    }

    /**
     * Transfere um valor para outra conta.
     * @param destino Conta de destino.
     * @param valor Valor a ser transferido.
     */
    public void transferir(Conta destino, double valor) {
        if (saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
        }
    }

    /**
     * Retorna o saldo da conta.
     * @return Saldo atual.
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Imprime o extrato da conta.
     */
    public abstract void imprimirExtrato();

    /**
     * Aplica os juros diários na conta.
     */
    public abstract void aplicarJurosDiarios();
}
