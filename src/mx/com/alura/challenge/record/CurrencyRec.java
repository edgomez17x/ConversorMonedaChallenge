package mx.com.alura.challenge.record;

import java.util.HashMap;

public record CurrencyRec(long time_last_update_unix, String base_code, HashMap<String, Double> conversion_rates) {

}
