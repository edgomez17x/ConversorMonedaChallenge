package mx.com.alura.challenge.module;

import mx.com.alura.challenge.record.CurrencyRec;

import java.util.HashMap;

public class Currency {
    private long time_last_update_unix;
    private String base_code;
    private HashMap<String, Double> conversion_Rates;

    public Currency(CurrencyRec currencyRec){
        time_last_update_unix = currencyRec.time_last_update_unix();
        base_code = currencyRec.base_code();
        conversion_Rates = currencyRec.conversion_rates();
    }

    public long getTime_last_update_unix() {
        return time_last_update_unix;
    }

    public void setTime_last_update_unix(long time_last_update_unix) {
        this.time_last_update_unix = time_last_update_unix;
    }

    public String getBase_code() {
        return base_code;
    }

    public void setBase_code(String base_code) {
        this.base_code = base_code;
    }

    public HashMap<String, Double> getConversion_Rates() {
        return conversion_Rates;
    }

    public void setConversion_Rates(HashMap<String, Double> conversion_Rates) {
        this.conversion_Rates = conversion_Rates;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "time_last_update_unix=" + time_last_update_unix +
                ", base_code='" + base_code + '\'' +
                ", conversion_Rates=" + conversion_Rates +
                '}';
    }
}
