package mx.com.alura.challenge;

import mx.com.alura.challenge.module.Currency;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00");
        List<String> validOptionsList = Arrays.asList("AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTN", "BWP", "BYN",
                "BZD", "CAD", "CDF", "CHF", "CLP", "CNY", "COP", "CRC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "FOK", "GBP", "GEL",
                "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES",
                "KGS", "KHR", "KID", "KMF", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRU", "MUR", "MVR",
                "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR",
                "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLE", "SLL", "SOS", "SRD", "SSP", "STN", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TVD", "TWD", "TZS",
                "UAH", "UGX", "USD", "UYU", "UZS", "VES", "VND", "VUV", "WST", "XAF", "XCD", "XDR", "XOF", "XPF", "YER", "ZAR", "ZMW", "ZWL");
        Conversor conversor = new Conversor();
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
        String option = "0";
        Double baseValue = 0D;
        String baseCurrencyName = "";
        String newCurrencyName = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("¡Bienvenido al sistema de converión de moneda!");
        do{
            do{
                System.out.println("""
                    Por favor teclea la moneda base:
                    Ejemplos: USD, EUR, GBP, JPY, CAD, MEX
                    Si se quiere ver toda la lista favor de teclear 1
                    """);
                baseCurrencyName = scanner.next();
                if(baseCurrencyName.equals("1")){
                    System.out.println(validOptions);
                    baseCurrencyName = "0";
                }else if(!validOptionsList.contains(baseCurrencyName)){
                    System.out.println("Favor de teclear un tipo de moneda valido");
                    System.out.println(validOptions);
                    baseCurrencyName = "0";
                }
            }while(baseCurrencyName.equals("0"));
            do{
                try{
                    System.out.println("Cual es la cantidad a convertir: ");
                    String tempBaseValue = scanner.next();
                    baseValue = Double.valueOf(tempBaseValue);
                    if(baseValue.intValue()<0){
                        System.out.println("El valor ingresado es negativo, solo valores positivos.");
                        baseValue = 0D;
                    }
                }catch (Exception e){

                    System.out.println("El valor ingresado no es númerico.");
                    baseValue = 0D;
                }
            }while(baseValue.equals(0D));
            do{
                System.out.println("Cual es la moneda a la que se hara la conversión");
                newCurrencyName = scanner.next();
                if(newCurrencyName.equals("1")){
                    System.out.println(validOptions);
                    newCurrencyName = "0";
                }else if(!validOptionsList.contains(newCurrencyName)){
                    System.out.println("Favor de teclear un tipo de moneda valido");
                    System.out.println(validOptions);
                    newCurrencyName = "0";
                }
            }while(newCurrencyName.equals("0"));
            Currency currency = conversor.obtenerValores(baseCurrencyName);
            Double currencyValue = currency.getConversion_Rates().get(newCurrencyName);
            Double convertedValue = conversor.convertirMoneda(baseValue, currencyValue);
            System.out.println("Tu moneda base es: " + baseCurrencyName);
            System.out.println("La cantidad a convertir es : " + df.format(baseValue));
            System.out.println("La moneda a la que se convertira es: " + newCurrencyName);
            System.out.println("Su actual valor contra 1 " + baseCurrencyName + " es: " + currencyValue);
            System.out.println("Los " + df.format(baseValue) + baseCurrencyName + " son " + df.format(convertedValue) + newCurrencyName);
            System.out.println("""
                    ¿Desea salir del sistema?
                    0.- Para continuar
                    1.- Para Salir""");
            option = scanner.next();
        }while(option.equals("0"));
        System.out.println("Gracias por usar el sistema de conversión de moneda");
    }


}
