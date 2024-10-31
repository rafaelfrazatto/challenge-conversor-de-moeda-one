import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConsultaCotacao consulta = new ConsultaCotacao();
        Scanner leitura = new Scanner(System.in);

        int selecaoMenuPrincipal = 1;
        int selecaoMenuMoedaOrigem = 1;
        int selecaoMenuMoedaDestino = 1;
        double valorParaConversao = 0;

        while (selecaoMenuPrincipal != 0) {
            System.out.println("""
                ******************************
                     CONVERSOR DE MOEDAS
                ******************************
                1 - Escolha a moeda de origem.
                2 - Escolha a moeda de destino.
                3 - Escolha para inserir o valor que será convertido.
                0 - Sair.
                ******************************
                Moeda de origem selecionada:""" + " " + consulta.getCodigoMoedaOrigem() + """
                
                Moeda de destino selecionada:""" + " " + consulta.getCodigoMoedaDestino() + """
                
                ******************************
                Selecione uma das opções:""");
            selecaoMenuPrincipal = leitura.nextInt();
            if (selecaoMenuPrincipal == 1){
                System.out.println("""
                            ******************************
                            SELECIONE A MOEDA DE ORIGEM
                            ******************************
                            1 - Real brasileiro (BRL).
                            2 - Dólar (USD).
                            3 - Euro (EUR).
                            4 - Peso Argentino (ARS).
                            5 - Libra Esterlina (GBP).
                            6 - Dólar Canadense (CAD).
                            ******************************
                            Selecione uma das opções:""");
                selecaoMenuMoedaOrigem = leitura.nextInt();
                if (selecaoMenuMoedaOrigem == 1) {
                    consulta.setCodigoMoedaOrigem("BRL");
                } else if (selecaoMenuMoedaOrigem == 2) {
                    consulta.setCodigoMoedaOrigem("USD");
                } else if (selecaoMenuMoedaOrigem == 3) {
                    consulta.setCodigoMoedaOrigem("EUR");
                } else if (selecaoMenuMoedaOrigem == 4) {
                    consulta.setCodigoMoedaOrigem("ARS");
                } else if (selecaoMenuMoedaOrigem == 5) {
                    consulta.setCodigoMoedaOrigem("GBP");
                } else if (selecaoMenuMoedaOrigem == 6) {
                    consulta.setCodigoMoedaOrigem("CAD");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
                System.out.println("Sua moeda de origem selecionada é: " + consulta.getCodigoMoedaOrigem());

            } else if (selecaoMenuPrincipal == 2){
                System.out.println("""
                            ******************************
                            SELECIONE A MOEDA DE DESTINO
                            ******************************
                            1 - Real brasileiro (BRL).
                            2 - Dólar (USD).
                            3 - Euro (EUR).
                            4 - Peso Argentino (ARS).
                            5 - Libra Esterlina (GBP).
                            6 - Dólar Canadense (CAD).
                            ******************************
                            Selecione uma das opções:""");
                selecaoMenuMoedaDestino = leitura.nextInt();
                if (selecaoMenuMoedaDestino == 1) {
                    consulta.setCodigoMoedaDestino("BRL");
                } else if (selecaoMenuMoedaDestino == 2) {
                    consulta.setCodigoMoedaDestino("USD");
                } else if (selecaoMenuMoedaDestino == 3) {
                    consulta.setCodigoMoedaDestino("EUR");
                } else if (selecaoMenuMoedaDestino == 4) {
                    consulta.setCodigoMoedaDestino("ARS");
                } else if (selecaoMenuMoedaDestino == 5) {
                    consulta.setCodigoMoedaDestino("GBP");
                } else if (selecaoMenuMoedaDestino == 6) {
                    consulta.setCodigoMoedaDestino("CAD");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
                System.out.println("Sua moeda de destino selecionada é: " + consulta.getCodigoMoedaDestino());

            } else if (selecaoMenuPrincipal == 3){
                System.out.println("Digite o valor que deseja converter:");
                valorParaConversao = leitura.nextDouble();
                System.out.println("******************************");
                System.out.println("Valor inserido: " + valorParaConversao + " " + consulta.getCodigoMoedaOrigem());
                consulta.calcularTaxaDeCambio(consulta.getCodigoMoedaOrigem(), consulta.getCodigoMoedaDestino());
                System.out.println("A taxa de câmbio foi definida em: " + consulta.getTaxaDeCambio());
                double valorResultado = valorParaConversao * consulta.getTaxaDeCambio();
                System.out.println("Valor convertido: " + valorResultado + " " + consulta.getCodigoMoedaDestino() + " .");
            } else if (selecaoMenuPrincipal == 0){
                System.out.println("O conversor de moedas será encerrado.");
            } else {
                System.out.println("Opção inválida, tente novamente.");
            }
        }
        System.out.println("Obrigado por fazer uso da aplicação.");
    }

}