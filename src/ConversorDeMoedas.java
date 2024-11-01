import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConversorDeMoedas {
    private String moedaOrigem;
    private String moedaDestino;
    private double taxaDeCambio;
    private final Scanner leitura;
    private final ConsultaCotacao consulta;
    private final List<Conversao> historicoConversoes;

    public ConversorDeMoedas() {
        leitura = new Scanner(System.in);
        consulta = new ConsultaCotacao();
        moedaOrigem = "";
        moedaDestino = "";
        taxaDeCambio = 0;
        historicoConversoes = new ArrayList<>();
    }

    public void iniciar() {
        int selecaoMenuPrincipal = -1;
        while (selecaoMenuPrincipal != 0) {
            mostrarMenuPrincipal();
            selecaoMenuPrincipal = leitura.nextInt();

            switch (selecaoMenuPrincipal) {
                case 1:
                    selecionarMoedaOrigem();
                    break;
                case 2:
                    selecionarMoedaDestino();
                    break;
                case 3:
                    realizarConversao();
                    break;
                case 0:
                    System.out.println("O conversor de moedas será encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }
    }

    private void mostrarMenuPrincipal() {
        System.out.println("""
                ****************************************
                          CONVERSOR DE MOEDAS
                ****************************************
                1 - Escolha a moeda de origem.
                2 - Escolha a moeda de destino.
                3 - Insira o valor que será convertido.
                0 - Sair.
                ****************************************
                Moeda de origem selecionada:""" + " " + moedaOrigem + """
                
                Moeda de destino selecionada:""" + " " + moedaDestino + """
                
                ****************************************
                Selecione uma das opções:""");
    }

    private void selecionarMoedaOrigem() {
        System.out.println("""
                ****************************************
                      SELECIONE A MOEDA DE ORIGEM
                ****************************************
                1 - Real Brasileiro (BRL).
                2 - Dólar Americano (USD).
                3 - Euro (EUR).
                4 - Peso Argentino (ARS).
                5 - Libra Esterlina (GBP).
                6 - Dólar Canadense (CAD).
                ****************************************
                Selecione uma das opções:""");
        int selecao = leitura.nextInt();
        switch (selecao) {
            case 1: moedaOrigem = "BRL"; break;
            case 2: moedaOrigem = "USD"; break;
            case 3: moedaOrigem = "EUR"; break;
            case 4: moedaOrigem = "ARS"; break;
            case 5: moedaOrigem = "GBP"; break;
            case 6: moedaOrigem = "CAD"; break;
            default: System.out.println("Opção inválida. Tente novamente.");
        }
        consulta.setCodigoMoedaOrigem(moedaOrigem);
        System.out.println("Sua moeda de origem selecionada é: " + moedaOrigem);
    }

    private void selecionarMoedaDestino() {
        System.out.println("""
                ****************************************
                      SELECIONE A MOEDA DE DESTINO
                ****************************************
                1 - Real brasileiro (BRL).
                2 - Dólar Americano (USD).
                3 - Euro (EUR).
                4 - Peso Argentino (ARS).
                5 - Libra Esterlina (GBP).
                6 - Dólar Canadense (CAD).
                ****************************************
                Selecione uma das opções:""");
        int selecao = leitura.nextInt();
        switch (selecao) {
            case 1: moedaDestino = "BRL"; break;
            case 2: moedaDestino = "USD"; break;
            case 3: moedaDestino = "EUR"; break;
            case 4: moedaDestino = "ARS"; break;
            case 5: moedaDestino = "GBP"; break;
            case 6: moedaDestino = "CAD"; break;
            default: System.out.println("Opção inválida. Tente novamente.");
        }
        consulta.setCodigoMoedaDestino(moedaDestino);
        System.out.println("Sua moeda de destino selecionada é: " + moedaDestino);
    }

    private void salvarConversao(Conversao conversao) {
        historicoConversoes.add(conversao);

        try (FileWriter writer = new FileWriter("historico_conversoes.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(historicoConversoes, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar conversões: " + e.getMessage());
        }
    }

    private void realizarConversao() {
        System.out.println("Digite o valor que deseja converter:");
        double valorParaConversao = leitura.nextDouble();
        System.out.println("****************************************" +
                "\nValor inserido: " + valorParaConversao + " " + moedaOrigem + ".");

        taxaDeCambio = consulta.calcularTaxaDeCambio(moedaOrigem, moedaDestino);
        System.out.println("A taxa de câmbio foi definida em: " + taxaDeCambio);

        double valorResultado = valorParaConversao * taxaDeCambio;
        System.out.println("Valor convertido: " + valorResultado + " " + moedaDestino + ".");

        Conversao conversao = new Conversao(moedaOrigem, moedaDestino, valorParaConversao, valorResultado, taxaDeCambio);
        salvarConversao(conversao);
    }
}