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
     * Retorna o saldo atual da conta.
     * @return Saldo da conta.
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

/**
 * Conta Corrente com aplicação de 0.1% de juros ao dia.
 */
class ContaCorrente extends Conta {

    /**
     * Construtor da Conta Corrente.
     * @param cliente Nome do cliente.
     * @param saldo Saldo inicial.
     */
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

/**
 * Conta Poupança com aplicação de 0.08% de juros ao dia.
 */
class ContaPoupanca extends Conta {

    /**
     * Construtor da Conta Poupança.
     * @param cliente Nome do cliente.
     * @param saldo Saldo inicial.
     */
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

/**
 * Conta Salário que não aplica juros.
 */
class ContaSalario extends Conta {

    /**
     * Construtor da Conta Salário.
     * @param cliente Nome do cliente.
     * @param saldo Saldo inicial.
     */
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
