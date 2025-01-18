import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import org.json.JSONObject;

public class WeatherApp {
    private static final String API_KEY = "8baef8cffba8344f2c07c745e36b60e8";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new WeatherApp().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Weather Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JLabel cityLabel = new JLabel("Enter City:");
        JTextField cityField = new JTextField(15);
        JButton getWeatherButton = new JButton("Get Weather");
        JTextArea resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);

        JPanel inputPanel = new JPanel();
        inputPanel.add(cityLabel);
        inputPanel.add(cityField);
        inputPanel.add(getWeatherButton);

        JPanel resultPanel = new JPanel();
        resultPanel.add(new JScrollPane(resultArea));

        frame.getContentPane().add(inputPanel, BorderLayout.NORTH);
        frame.getContentPane().add(resultPanel, BorderLayout.CENTER);

        getWeatherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String city = cityField.getText().trim();
                if (!city.isEmpty()) {
                    String weatherInfo = getWeather(city);
                    resultArea.setText(weatherInfo);
                } else {
                    resultArea.setText("Please enter a valid city name.");
                }
            }
        });

        frame.setVisible(true);
    }

    private String getWeather(String city) {
        try {
            String urlString = String.format("%s?q=%s&appid=%s&units=metric", BASE_URL, city, API_KEY);
            URI uri = new URI(urlString);
            URL url = uri.toURL();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            return parseWeatherResponse(response.toString());
        } catch (Exception e) {
            return "Error fetching weather data: " + e.getMessage();
        }
    }

    private String parseWeatherResponse(String jsonResponse) {
        JSONObject jsonObject = new JSONObject(jsonResponse);
        String cityName = jsonObject.getString("name");
        JSONObject main = jsonObject.getJSONObject("main");
        double temperature = main.getDouble("temp");
        int humidity = main.getInt("humidity");
        JSONObject weather = jsonObject.getJSONArray("weather").getJSONObject(0);
        String description = weather.getString("description");

        return String.format("City: %s\nTemperature: %.2f°C\nHumidity: %d%%\nDescription: %s",
                cityName, temperature, humidity, description);
    }
}
