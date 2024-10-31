import java.util.Scanner;

public class Menu extends ConsultaCotacao {
    Scanner leitura = new Scanner(System.in);
    ConsultaCotacao consulta = new ConsultaCotacao();


    int selecaoMenuPrincipal = 0;
    int selecaoMenuMoedaOrigem = 0;
    int selecaoMenuMoedaDestino = 0;

    public void solicitarChaveApi() {
        System.out.println("Insira sua API KEY (Exchange Rate API):");
    }


    public void exibirMenuPrincipal(){
        System.out.println("""
                ******************************
                CONVERSOR DE MOEDAS
                ******************************
                1 - Escolha a moeda de origem.
                2 - Escolha a moeda de destino.
                3 - Para ver mais opções de moedas.
                4 - Sair.
                ******************************
                """);
    }

    public void exibirMenuMoedaOrigem () {
        System.out.println("""
                Selecione sua moeda de origem:
                1 - Real brasileiro (BRL).
                2 - Dólar (USD).
                3 - Euro (EUR).
                4 - Peso Argentino (ARS).
                5 - Libra Esterlina (GBP).
                6 - Dólar Canadense (CAD).
                """);
        selecaoMenuMoedaOrigem = leitura.nextInt();
        switch (selecaoMenuMoedaOrigem){
            case 1:


        }
    }

}
