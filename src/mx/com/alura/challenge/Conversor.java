package mx.com.alura.challenge;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import mx.com.alura.challenge.module.Currency;
import mx.com.alura.challenge.module.Historial;
import mx.com.alura.challenge.record.CurrencyRec;

import java.io.*;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Conversor {

    private static final String URL = "https://v6.exchangerate-api.com/v6/92cd80198f84e220b14febdc/latest/";

    public List<Historial> getHistorial(){
        try {
            BufferedReader br = new BufferedReader(new FileReader("Historial.json"));
            String tmpStr;
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String jsonFile = "";
            while ((tmpStr = br.readLine()) != null){
                jsonFile += tmpStr;
            }
            br.close();
            if (!jsonFile.isEmpty()){
                List<Historial> historialList = new ArrayList<Historial>();
                Historial[] historials = gson.fromJson(jsonFile, Historial[].class);
                for (Historial historial : historials){
                    historialList.add(historial);
                }
                return historialList;
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura del archivo");
        }
        return new ArrayList<Historial>();
    }

    public void saveHistorial(List<Historial> historialList) {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fw  = new FileWriter("Historial.json");
            fw.write(gson.toJson(historialList));
            fw.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir el archivo");
        }
    }

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
