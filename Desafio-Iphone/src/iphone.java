public class iphone {
    public static void main(String[] args) {
        iphone myIphone = new iphone();

        // Chamando os métodos correspondentes aos comportamentos esperados
        myIphone.tocar();
        myIphone.pausar();
        myIphone.selecionarMusica();

        myIphone.ligar();
        myIphone.atender();
        myIphone.iniciarCorreioVoz();

        myIphone.exibirPagina();
        myIphone.adicionarNovaAba();
        myIphone.atualizarPagina();
    }

    // Implementações das interfaces
    public void tocar() {
        System.out.println("Reproduzindo música...");
    }

    public void pausar() {
        System.out.println("Pausando música...");
    }

    public void selecionarMusica() {
        System.out.println("Selecionando música...");
    }

    public void ligar() {
        System.out.println("Ligando o iPhone...");
    }

    public void atender() {
        System.out.println("Atendendo chamada...");
    }

    public void iniciarCorreioVoz() {
        System.out.println("Iniciando correio de voz...");
    }

    public void exibirPagina() {
        System.out.println("Exibindo página na Internet...");
    }

    public void adicionarNovaAba() {
        System.out.println("Adicionando nova aba no navegador...");
    }

    public void atualizarPagina() {
        System.out.println("Atualizando página na Internet...");
    }
}
