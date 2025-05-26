interface Autenticavel {
    boolean autenticar(String senha);
}

interface Gerenciavel {
    void alterarSenha(String novaSenha);
    void bloquearUsuario();
}

interface Logavel {
    void registrarLog(String operacao);
}

abstract class Usuario {
    protected String login;
    protected String senha;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public void exibirLogin() {
        System.out.println("Login: " + login);
    }
}

class Administrador extends Usuario implements Autenticavel, Gerenciavel, Logavel {

    public Administrador(String login, String senha) {
        super(login, senha);
    }

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        System.out.println("Senha alterada com sucesso.");
    }

    public void bloquearUsuario() {
        System.out.println("Usuário bloqueado com sucesso.");
    }

    public void registrarLog(String operacao) {
        System.out.println("Log registrado: " + operacao);
    }
}

class Visitante extends Usuario {
    public Visitante(String login, String senha) {
        super(login, senha);
    }

    @Override
    public void exibirLogin() {
        System.out.println("Visitante - acesso restrito ao sistema.");
    }
}

class Cliente extends Usuario implements Autenticavel {
    public Cliente(String login, String senha) {
        super(login, senha);
    }

    public boolean autenticar(String senha) {
        return senha.length() > 6 && this.senha.equals(senha);
    }
}

public class ProgramaLogin {
    public static void main(String[] args) {
        Administrador admin = new Administrador("admin", "admin123");
        Visitante guest = new Visitante("guest", "qualquer");
        Cliente joao = new Cliente("joao", "segredo123");

        admin.exibirLogin();
        System.out.println("Autenticação com 'admin123': " + admin.autenticar("admin123"));
        System.out.println("Autenticação com 'errada': " + admin.autenticar("errada"));
        admin.alterarSenha("novaSenha");
        admin.bloquearUsuario();
        admin.registrarLog("Exclusão de conta");
        System.out.println();

        guest.exibirLogin();
        System.out.println();

        joao.exibirLogin();
        System.out.println("Autenticação com 'segredo123': " + joao.autenticar("segredo123"));
        System.out.println("Autenticação com '12345': " + joao.autenticar("12345"));
    }
}
