package currency_converter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Hashtable;
import org.json.JSONObject;

/**
 * The CurrencyExchange class provides a method to fetch currency exchange rates
 * from the ExchangeRate-API and store them in a Hashtable.
 */
public class CurrencyExchange {

    /**
     * The main method which executes the currency exchange rate fetching and storing process.
     *
     * @param args Command-line arguments (not used).
     */
    public CurrencyExchange(String from, String to, double amount) {
        String apiKey = "3611169a96cef61207a9f69e";
        String baseCurrency = from;
        String apiUrl = "https://v6.exchangerate-api.com/v6/" + apiKey + "/latest/" + baseCurrency;
        
        Hashtable<String, Double> exchangeRates = new Hashtable<>();

        try {
            // Create a URL object
            URL url = new URL(apiUrl);

            // Open a connection to the URL
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                // Read the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the response as JSON
                JSONObject jsonResponse = new JSONObject(response.toString());
                JSONObject rates = jsonResponse.getJSONObject("conversion_rates");

                // Store the exchange rates in the Hashtable
                for (String key : rates.keySet()) {
                    exchangeRates.put(key, rates.getDouble(key));
                }

                // Print the exchange rates
                System.out.println("Exchange Rates: " + exchangeRates);

            } else {
                System.out.println("GET request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
