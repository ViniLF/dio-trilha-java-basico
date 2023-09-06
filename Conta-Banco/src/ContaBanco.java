import java.io.Serializable;

public class ContaBanco implements Serializable {
    private String agencia;
    private String numeroConta;
    private double saldo;
    private Cliente cliente; // Usamos a classe Cliente para armazenar informações do cliente

    public ContaBanco(String agencia, String numeroConta, double saldo, Cliente cliente) {
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    // Método para exibir a mensagem formatada
    public void exibirMensagem() {
        System.out.println("Olá " + cliente.getNome() + ", obrigado por criar uma conta em nosso banco,");
        System.out.println("sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo " + saldo
                + " já está disponível para saque.");
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente("João da Silva", "123.456.789-00");
        ContaBanco conta = new ContaBanco("1021", "12345-6", 1000.0, cliente);

        conta.exibirMensagem();
    }
}
