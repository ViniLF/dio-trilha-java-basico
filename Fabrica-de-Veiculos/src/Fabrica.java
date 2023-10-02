import java.util.Scanner;

interface Veiculo {
    void acelerar();

    void parar();

    String getModelo();

    String getCor();

    int getAno();
}

abstract class VeiculoBase implements Veiculo {
    private String modelo;
    private String cor;
    private int ano;

    public VeiculoBase(String modelo, String cor, int ano) {
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public String getCor() {
        return cor;
    }

    public int getAno() {
        return ano;
    }
}

class Carro extends VeiculoBase {
    public Carro(String modelo, String cor, int ano) {
        super(modelo, cor, ano);
    }

    @Override
    public void acelerar() {
        System.out.println("Carro acelerando...");
    }

    @Override
    public void parar() {
        System.out.println("Carro parando...");
    }
}

class Moto extends VeiculoBase {
    public Moto(String modelo, String cor, int ano) {
        super(modelo, cor, ano);
    }

    @Override
    public void acelerar() {
        System.out.println("Moto acelerando...");
    }

    @Override
    public void parar() {
        System.out.println("Moto parando...");
    }
}

interface FabricaVeiculos {
    Veiculo criarVeiculo();
}

class FabricaCarros implements FabricaVeiculos {
    @Override
    public Veiculo criarVeiculo() {
        return new Carro("", "", 0); // Modelo, cor e ano serão configurados posteriormente
    }
}

class FabricaMotos implements FabricaVeiculos {
    @Override
    public Veiculo criarVeiculo() {
        return new Moto("", "", 0); // Modelo, cor e ano serão configurados posteriormente
    }
}

public class Fabrica {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Sistema de Criação de Veículos!");

        while (true) {
            System.out.println("\nEscolha o tipo de veículo a ser criado:");
            System.out.println("1. Carro");
            System.out.println("2. Moto");
            System.out.println("0. Sair");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Encerrando o programa. Até logo!");
                break;
            }

            FabricaVeiculos fabrica;
            String tipoVeiculo;

            if (choice == 1) {
                fabrica = new FabricaCarros();
                tipoVeiculo = "Carro";
            } else if (choice == 2) {
                fabrica = new FabricaMotos();
                tipoVeiculo = "Moto";
            } else {
                System.out.println("Escolha inválida. Tente novamente.");
                continue;
            }

            System.out.print("Digite o modelo do " + tipoVeiculo + ": ");
            String modelo = scanner.nextLine();

            System.out.print("Digite a cor do " + tipoVeiculo + ": ");
            String cor = scanner.nextLine();

            System.out.print("Digite o ano do " + tipoVeiculo + ": ");
            int ano = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Veiculo veiculo = fabrica.criarVeiculo();
            configurarVeiculo(veiculo, modelo, cor, ano);

            System.out.println("Veículo criado:");
            System.out.println("Tipo: " + tipoVeiculo);
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Cor: " + veiculo.getCor());
            System.out.println("Ano: " + veiculo.getAno());

            veiculo.acelerar();
            veiculo.parar();
        }

        // Fechar o scanner para evitar vazamento de recursos
        scanner.close();
    }

    private static void configurarVeiculo(Veiculo veiculo, String modelo, String cor, int ano) {
        if (veiculo instanceof Carro) {
            ((Carro) veiculo).setModelo(modelo);
            ((Carro) veiculo).setCor(cor);
            ((Carro) veiculo).setAno(ano);
        } else if (veiculo instanceof Moto) {
            ((Moto) veiculo).setModelo(modelo);
            ((Moto) veiculo).setCor(cor);
            ((Moto) veiculo).setAno(ano);
        }
    }
}
