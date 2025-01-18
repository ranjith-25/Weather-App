# Weather Application

## Overview
This Java-based Weather Application fetches and displays real-time weather information for a specified city using the OpenWeatherMap API. The application features a graphical user interface (GUI) built with Swing and parses JSON responses using the `org.json` library.

---

## Features
- **Real-Time Weather Data**: Fetches current temperature, humidity, and a description of the weather.
- **User-Friendly GUI**: Easy-to-use interface created with Swing.
- **Input Validation**: Ensures valid city names are entered.
- **Error Handling**: Provides feedback for invalid inputs, API errors, and network issues.

---

## Prerequisites
1. **Java Development Kit (JDK)**: Ensure JDK 11 or later is installed.
2. **OpenWeatherMap API Key**: Obtain an API key by signing up at [OpenWeatherMap](https://openweathermap.org/api).
3. **org.json Library**: Include the `org.json` library in your project.
   - Download from [Maven Repository](https://mvnrepository.com/artifact/org.json/json).

---

## Setup and Installation

### 1. Clone the Repository
```bash
git clone <repository-url>
cd weather-application
```

### 2. Add Dependencies
#### Using Maven
Add this dependency to your `pom.xml` file:
```xml
<dependency>
    <groupId>org.json</groupId>
    <artifactId>json</artifactId>
    <version>20230618</version>
</dependency>
```

#### Manual Download
1. Download the `json` JAR file from [Maven Repository](https://mvnrepository.com/artifact/org.json/json).
2. Add it to your project classpath:
   - **IntelliJ IDEA**: Go to **File > Project Structure > Libraries > + > Java**, and select the downloaded JAR.
   - **Eclipse**: Right-click the project, choose **Build Path > Add External Archives**, and select the JAR file.

### 3. Set Your API Key
Replace `YOUR_API_KEY` in the source code with your OpenWeatherMap API key.

### 4. Compile and Run the Application
#### Using IDE
1. Open the project in IntelliJ IDEA or Eclipse.
2. Run the `WeatherApp` class.

#### Using Command Line
1. Navigate to the project directory.
2. Compile the application:
   ```bash
   javac -cp .:json-20230618.jar WeatherApp.java
   ```
   (Use `;` instead of `:` on Windows.)
3. Run the application:
   ```bash
   java -cp .:json-20230618.jar WeatherApp
   ```

---

## Usage
1. Enter the name of a city in the input field.
2. Click the **"Get Weather"** button.
3. View the current weather details in the displayed result area.

---

## Error Handling
- Displays appropriate messages for:
  - Invalid city names.
  - Network issues.
  - API errors.
  - JSON parsing issues.

---

## Future Enhancements
1. **Database Integration**: Save user preferences and recent searches using SQLite.
2. **Extended Forecasts**: Show weather forecasts for multiple days.
3. **Localization**: Add support for multiple languages.
4. **Modern UI**: Upgrade to JavaFX for a more modern look.

---

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.

---

