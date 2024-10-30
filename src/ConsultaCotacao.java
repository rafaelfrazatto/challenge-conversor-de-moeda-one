import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaCotacao {

    private final String chaveAPI;

    public ConsultaCotacao(String chaveAPI) {
        this.chaveAPI = chaveAPI;
    }

    public double taxaDeCambio (String codigoMoedaInicial, String codigoMoedaFinal) {
        try {
            String linkApi = "https://v6.exchangerate-api.com/v6/" + chaveAPI + "/pair/" + codigoMoedaInicial + "/" + codigoMoedaFinal;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(linkApi))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(response.body(), JsonObject.class);
            return jsonResponse.get("conversion_rate").getAsDouble();
        } catch (Exception e){
            throw new RuntimeException("Erro na aplicação. Não foi possivel obter a taxa de câmbio.");
        }
    }
}
