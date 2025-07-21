package by.kufar.config;

import java.util.Properties;

public class WebDriverConfig {
    private static final Properties props = new Properties();

    static {
        try (var input = WebDriverConfig.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            props.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Error loading config.properties", e);
        }
    }

    public static String getBrowser() {
        return props.getProperty("browser", "chrome");
    }

    public static boolean isHeadless() {
        return Boolean.parseBoolean(props.getProperty("headless", "false"));
    }
}