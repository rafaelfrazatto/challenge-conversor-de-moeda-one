import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCotacao {

    private String chaveAPI = "d0037b4468514b27f8d2dbb2";
    private String codigoMoedaOrigem;
    private String codigoMoedaDestino;
    private double taxaDeCambio;


    public double getTaxaDeCambio() {
        return taxaDeCambio;
    }

    public void setCodigoMoedaOrigem(String codigoMoedaOrigem) {
        this.codigoMoedaOrigem = codigoMoedaOrigem;
    }

    public void setCodigoMoedaDestino(String codigoMoedaDestino) {
        this.codigoMoedaDestino = codigoMoedaDestino;
    }

    public String getCodigoMoedaOrigem() {
        return codigoMoedaOrigem;
    }

    public String getCodigoMoedaDestino() {
        return codigoMoedaDestino;
    }

    public double calcularTaxaDeCambio (String codigoMoedaInicial, String codigoMoedaFinal) {
        String url = "https://v6.exchangerate-api.com/v6/" + chaveAPI + "/pair/" + codigoMoedaOrigem + "/" + codigoMoedaDestino;
        JsonObject jsonResponse = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            return taxaDeCambio = jsonResponse.get("conversion_rate").getAsDouble();
        } catch (Exception e) {
            System.out.println("Erro na aplicação. Não foi possivel obter a taxa de câmbio.");
        }
        return taxaDeCambio;
    }
}
