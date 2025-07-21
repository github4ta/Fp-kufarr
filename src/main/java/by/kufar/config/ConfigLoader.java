package by.kufar.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties props = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (input != null) {
                props.load(input);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties", e);
        }
    }

    public static String getBaseUrl() {
        return props.getProperty("base.url", "https://www.kufar.by");
    }

    public static String getApiBaseUrl() {
        return props.getProperty("api.url", "https://api.kufar.by");
    }

    public static int getWaitTimeout() {
        return Integer.parseInt(props.getProperty("wait.timeout", "15"));
    }

    public static String getCookieBannerLocator() {
        return props.getProperty("cookie.banner.locator");
    }

    public static String getCookieAcceptLocator() {
        return props.getProperty("cookie.accept.locator");
    }
}