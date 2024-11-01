import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Conversao {
    private final String moedaOrigem;
    private final String moedaDestino;
    private final double valorOrigem;
    private final double valorConvertido;
    private final double taxaDeCambio;
    private final String dataHora;

    public Conversao(String moedaOrigem, String moedaDestino, double valorOrigem, double valorConvertido, double taxaDeCambio) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.valorOrigem = valorOrigem;
        this.valorConvertido = valorConvertido;
        this.taxaDeCambio = taxaDeCambio;
        this.dataHora = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

    @Override
    public String toString() {
        return String.format("Conversao{moedaOrigem='%s', moedaDestino='%s', valorOrigem=%.2f, valorConvertido=%.2f, taxaDeCambio=%.4f, dataHora='%s'}",
                moedaOrigem, moedaDestino, valorOrigem, valorConvertido, taxaDeCambio, dataHora);
    }
}
