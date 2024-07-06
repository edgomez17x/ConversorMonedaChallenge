package mx.com.alura.challenge;

import mx.com.alura.challenge.module.Currency;
import mx.com.alura.challenge.module.Historial;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Principal {

    public static void main(String[] args) {
        List<Historial> historialList = new ArrayList<Historial>();
        DecimalFormat df = new DecimalFormat("0.00");
        List<String> validOptionsList = Arrays.asList("AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN",
                "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL",
                "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES",
                "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR",
                "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR",
                "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SLL", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS",
                "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL");
        String validOptions = """
                        Estas son las opciones validas:
                        AED AFN ALL AMD ANG AOA ARS AUD AWG AZN BAM BBD BDT BGN BHD BIF BMD BND BOB BRL BSD BTN BWP BYN 
                        BZD CAD CDF CHF CLP CNY COP CRC CUP CVE CZK DJF DKK DOP DZD EGP ERN ETB EUR FJD FKP FOK GBP GEL 
                        GGP GHS GIP GMD GNF GTQ GYD HKD HNL HRK HTG HUF IDR ILS IMP INR IQD IRR ISK JEP JMD JOD JPY KES 
                        KGS KHR KID KMF KRW KWD KYD KZT LAK LBP LKR LRD LSL LYD MAD MDL MGA MKD MMK MNT MOP MRU MUR MVR 
                        MWK MXN MYR MZN NAD NGN NIO NOK NPR NZD OMR PAB PEN PGK PHP PKR PLN PYG QAR RON RSD RUB RWF SAR 
                        SBD SCR SDG SEK SGD SHP SLE SLL SOS SRD SSP STN SYP SZL THB TJS TMT TND TOP TRY TTD TVD TWD TZS 
                        UAH UGX USD UYU UZS VES VND VUV WST XAF XCD XDR XOF XPF YER ZAR ZMW ZWL
                        """;
        String option = "";
        Double baseValue = 0D;
        String baseCurrencyName = "";
        String newCurrencyName = "";
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();
        historialList = conversor.getHistorial();
        System.out.println("¡Bienvenido al sistema de converión de moneda!");
        while(!option.equals("0")){
            System.out.println("""
                    ¿Que opción desea realizar??
                    0.- Salir
                    1.- Realizar conversión
                    2.- Ver Historial
                    3.- Borrar Historial""");
            option = scanner.next();
            switch(option) {
                case "1":
                {
                    do {
                        System.out.println("""
                                Por favor teclea la moneda base:
                                Ejemplos: USD, EUR, GBP, JPY, CAD, MXN
                                Si se quiere ver toda la lista favor de teclear 1
                                """);
                        baseCurrencyName = scanner.next().toUpperCase();
                        if (baseCurrencyName.equals("1")) {
                            System.out.println(validOptions);
                            baseCurrencyName = "0";
                        } else if (!validOptionsList.contains(baseCurrencyName)) {
                            System.out.println("Favor de teclear un tipo de moneda valido");
                            System.out.println(validOptions);
                            baseCurrencyName = "0";
                        }
                    } while (baseCurrencyName.equals("0"));
                    do {
                        try {
                            System.out.println("Cual es la cantidad a convertir: ");
                            String tempBaseValue = scanner.next();
                            baseValue = Double.valueOf(tempBaseValue);
                            if (baseValue.intValue() < 0) {
                                System.out.println("El valor ingresado es negativo, solo valores positivos.");
                                baseValue = 0D;
                            }
                        } catch (Exception e) {

                            System.out.println("El valor ingresado no es númerico.");
                            baseValue = 0D;
                        }
                    } while (baseValue.equals(0D));
                    do {
                        System.out.println("Cual es la moneda a la que se hara la conversión");
                        newCurrencyName = scanner.next().toUpperCase();
                        if (newCurrencyName.equals("1")) {
                            System.out.println(validOptions);
                            newCurrencyName = "0";
                        } else if (!validOptionsList.contains(newCurrencyName)) {
                            System.out.println("Favor de teclear un tipo de moneda valido");
                            System.out.println(validOptions);
                            newCurrencyName = "0";
                        }
                    } while (newCurrencyName.equals("0"));
                    Currency currency = conversor.obtenerValores(baseCurrencyName);
                    Double currencyValue = currency.getConversion_Rates().get(newCurrencyName);
                    Double convertedValue = conversor.convertirMoneda(baseValue, currencyValue);
                    System.out.println("Tu moneda base es: " + baseCurrencyName);
                    System.out.println("La cantidad a convertir es : " + df.format(baseValue));
                    System.out.println("La moneda a la que se convertira es: " + newCurrencyName);
                    System.out.println("Su actual valor contra 1 " + baseCurrencyName + " es: " + currencyValue);
                    System.out.println("Los " + df.format(baseValue) + baseCurrencyName + " son " + df.format(convertedValue) + newCurrencyName);
                    Historial historial = new Historial(baseCurrencyName, newCurrencyName, currencyValue, Double.parseDouble(df.format(baseValue)), Double.parseDouble(df.format(convertedValue)), System.currentTimeMillis());
                    historialList.add(historial);
                    break;
                }
                case "2": {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/YYYY HH:mm:ss");
                    for (Historial historial : historialList) {
                        System.out.println(sdf.format(new Date(historial.getProcessDate())) + " - Se convirtió " + historial.getBaseValue() + historial.getBaseCurrency() + " en " + historial.getNewValue() + historial.getNewCurrency() + " con una tasa de cambio de: " + historial.getCurrency());
                    }
                    break;
                }
                case "3":
                    historialList = new ArrayList<>();
                    break;
                default:
            }
        };
        System.out.println("Guardando actividades realizadas");
        conversor.saveHistorial(historialList);
        System.out.println("Gracias por usar el sistema de conversión de moneda");
    }


}
