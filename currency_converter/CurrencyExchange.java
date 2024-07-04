package currency_converter;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient;
import java.net.URI;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The CurrencyExchange class provides a method to fetch currency exchange rates
 * from the ExchangeRate-API and store them in a HashMap.
 */
public class CurrencyExchange {

    private static Map<String, Double> exchangeRates;

    /**
     * The constructor fetches the currency exchange rates and stores them.
     *
     * @param from The base currency code.
     * @param to The target currency code.
     * @param amount The amount to convert.
     */
    public CurrencyExchange(String from,double amount) {

        if (from == null || from.isEmpty() || from.equals("Select From Currency") ) {
            System.err.println("Error: Base currency code is required.");
            return;
        }
        String apiKey = "3611169a96cef61207a9f69e";
        String baseCurrency = from;
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;

        exchangeRates = new HashMap<>();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .GET()
                    .build();

            HttpClient client = HttpClient.newHttpClient();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                parseAndStoreExchangeRates(response.body());

                System.out.println(amount + from);
            } else {
                System.err.println("Error: Unable to fetch exchange rates. Status code: " + response.statusCode());
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            
        }
    }

    /**
     * Parses the JSON response and stores the exchange rates in a HashMap.
     *
     * @param responseBody The JSON response body as a string.
     */
    private void parseAndStoreExchangeRates(String responseBody) {
        String[] parts = responseBody.split("\"conversion_rates\":\\{")[1].split("\\}\\}")[0].split(",");
        
        for (String rate : parts) {
            String[] keyValue = rate.split(":");
            if (keyValue.length == 2) {
                String currency = keyValue[0].replace("\"", "").trim();
                try {
                    double value = Double.parseDouble(keyValue[1].trim());
                    exchangeRates.put(currency, value);
                } catch (NumberFormatException e) {
                    System.err.println("Error parsing exchange rate for currency: " + currency);
                    
                }
            }
        }
    }

    /**
     * Converts the given amount from the base currency to the target currency.
     *
     * @param to The target currency code.
     * @param amount The amount to convert.
     * @return The converted amount.
     */
    double convertCurrency(String to, double amount) {
        if(to.equals("Select to Currency") || to.equals("Select From Currency")){
            System.err.println("Error: Please select a currency");
            return 0.0;
        }
        if (exchangeRates.containsKey(to)) {
            return amount * exchangeRates.get(to);
        } else {
            System.err.println("Error: Unsupported target currency " + to);
            return 0.0;
        }
    }

    public static Map<String, Double> getExchangeRates() {
        return exchangeRates;
    }

}
