import java.util.Scanner;

// Define uma classe personalizada de exceção chamada ParametrosInvalidosException.
class ParametrosInvalidosException extends Exception {
    // Construtor que permite definir uma mensagem para a exceção.
    public ParametrosInvalidosException(String message) {
        super(message);
    }
}

public class Contador {
    public static void main(String[] args) {
        // Cria uma instância do Scanner para ler dados do terminal.
        Scanner terminal = new Scanner(System.in);

        System.out.print("Digite o primeiro parâmetro (número inteiro): ");
        int parametroUm = terminal.nextInt(); // Lê o valor do primeiro parâmetro.

        System.out.print("Digite o segundo parâmetro (número inteiro): ");
        int parametroDois = terminal.nextInt(); // Lê o valor do segundo parâmetro.

        try {
            // Chama o método contar com os parâmetros lidos.
            contar(parametroUm, parametroDois);
        } catch (ParametrosInvalidosException e) {
            // Captura e trata a exceção ParametrosInvalidosException, imprimindo a mensagem
            // de erro.
            System.out.println(e.getMessage());
        } finally {
            terminal.close(); // Fecha o scanner no bloco finally para garantir que ele seja sempre fechado.
        }
    }

    // Método estático contar que realiza a contagem e lança uma exceção se o
    // primeiro parâmetro for maior ou igual ao segundo.
    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Verifica se o primeiro parâmetro é maior ou igual ao segundo.
        if (parametroUm >= parametroDois) {
            // Lança a exceção ParametrosInvalidosException com a mensagem apropriada.
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro.");
        }

        // Calcula a quantidade de números a serem impressos.
        int contagem = parametroDois - parametroUm;

        // Usa um loop for para imprimir os números no intervalo especificado.
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + (parametroUm + i));
        }
    }
}