package mx.com.alura.challenge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import mx.com.alura.challenge.module.Currency;
import mx.com.alura.challenge.record.CurrencyRec;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    private static final String URL = "https://v6.exchangerate-api.com/v6/92cd80198f84e220b14febdc/latest/";

    public String obtenerValoresApi(String BaseCurrencyName) throws IOException, InterruptedException {
        String newUrl = URL + BaseCurrencyName;
        HttpClient httpClient =HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(newUrl)).build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

    public Currency obtenerValores(String BaseCurrencyName){
        try {
            String json = obtenerValoresApi(BaseCurrencyName);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            return new Currency(gson.fromJson(json, CurrencyRec.class));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Double convertirMoneda(Double baseValue, Double currencyValue){
        return baseValue * currencyValue;
    }

}
