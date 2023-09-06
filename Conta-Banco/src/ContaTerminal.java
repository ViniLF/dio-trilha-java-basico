import java.io.*;
import java.util.Scanner;

public class ContaTerminal {
    private static final String ARQUIVO_CONTA = "conta.txt"; // Nome do arquivo de armazenamento da conta

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Verifica se a conta já existe no arquivo
        if (contaExiste()) {
            ContaBanco conta = lerConta();
            double saldo = conta.getSaldo();
            String nomeCliente = conta.getCliente().getNome();
            System.out
                    .println("Bem-vindo novamente " + nomeCliente + ", seu saldo é: " + saldo + " pronto para saque.");
        } else {
            System.out.println("Nenhuma conta encontrada. Vamos criar uma nova conta:");
            ContaBanco conta = criarConta(scanner);
            salvarConta(conta);
            conta.exibirMensagem();
        }

        scanner.close();
    }

    private static boolean contaExiste() {
        File arquivo = new File(ARQUIVO_CONTA);
        return arquivo.exists();
    }

    private static ContaBanco criarConta(Scanner scanner) {
        System.out.print("Por favor, digite o número da Agência: ");
        String agencia = scanner.nextLine();

        System.out.print("Por favor, digite o número da Conta: ");
        String numeroConta = scanner.nextLine();

        System.out.print("Por favor, digite o nome do Cliente: ");
        String nomeCliente = scanner.nextLine();

        System.out.print("Por favor, digite o saldo da conta: ");
        double saldo = scanner.nextDouble();

        Cliente cliente = new Cliente(nomeCliente, ""); // Você pode adicionar o CPF aqui, se necessário
        return new ContaBanco(agencia, numeroConta, saldo, cliente);
    }

    private static void salvarConta(ContaBanco conta) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTA))) {
            outputStream.writeObject(conta);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ContaBanco lerConta() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTA))) {
            return (ContaBanco) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
