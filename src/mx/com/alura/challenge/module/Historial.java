package mx.com.alura.challenge.module;

public class Historial {
    private String baseCurrency;
    private String newCurrency;
    private Double currency;
    private Double baseValue;
    private Double newValue;
    private Long processDate;

    public Historial(String baseCurrency, String newCurrency, Double currency, Double baseValue, Double newValue, Long processDate){
        this.baseCurrency = baseCurrency;
        this.baseValue = baseValue;
        this.currency = currency;
        this.newValue = newValue;
        this.processDate = processDate;
        this.newCurrency = newCurrency;
    }

    public Long getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Long processDate) {
        this.processDate = processDate;
    }

    public Double getNewValue() {
        return newValue;
    }

    public void setNewValue(Double newValue) {
        this.newValue = newValue;
    }

    public Double getBaseValue() {
        return baseValue;
    }

    public void setBaseValue(Double baseValue) {
        this.baseValue = baseValue;
    }

    public Double getCurrency() {
        return currency;
    }

    public void setCurrency(Double currency) {
        this.currency = currency;
    }

    public String getNewCurrency() {
        return newCurrency;
    }

    public void setNewCurrency(String newCurrency) {
        this.newCurrency = newCurrency;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    @Override
    public String toString() {
        return "Historial{" +
                "baseCurrency='" + baseCurrency + '\'' +
                ", newCurrency='" + newCurrency + '\'' +
                ", currency=" + currency +
                ", baseValue=" + baseValue +
                ", newValue=" + newValue +
                ", processDate='" + processDate + '\'' +
                '}';
    }
}
