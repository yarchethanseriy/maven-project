package app;

import java.io.IOException;
import java.util.Objects;
import java.io.InputStream;
import java.util.Properties;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class App {
    public static String greet(String name) {
        Objects.requireNonNull(name, "Имя не может быть NULL");
        if (name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        String greeting = "Привет, " + name + "!";
        return greeting;
    }

    public static void main(String[] args) throws IOException {
        try (InputStream input = App.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties properties = new Properties();
            if (input == null) {
                throw new IOException("Файл app.properties не найден.");
            }

            properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
            String name = properties.getProperty("student.name");
            System.out.println(App.greet(name));
        }

    }
}