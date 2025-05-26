abstract class Funcionario {
    protected String nome;
    protected double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário Base: " + salarioBase);
    }

    public abstract double calcularSalario();
}

class FuncionarioCLT extends Funcionario {
    public FuncionarioCLT(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    public double calcularSalario() {
        return salarioBase + 300;
    }
}

class FuncionarioTemporario extends Funcionario {
    public FuncionarioTemporario(String nome, double salarioBase) {
        super(nome, salarioBase);
    }

    public double calcularSalario() {
        return salarioBase - 100;
    }
}

public class ProgramaFolha {
    public static void main(String[] args) {
        Funcionario f1 = new FuncionarioCLT("Carlos", 2000.0);
        Funcionario f2 = new FuncionarioTemporario("Ana", 2000.0);

        f1.exibirDados();
        System.out.println("Salário Final: " + f1.calcularSalario());
        System.out.println();

        f2.exibirDados();
        System.out.println("Salário Final: " + f2.calcularSalario());
    }
}
