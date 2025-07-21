package by.kufar.utils;

import java.io.InputStream;
import java.util.Properties;

public final class LoggerUtil {
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream is = LoggerUtil.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (is == null) throw new RuntimeException("config.properties не найден");
            PROPS.load(is);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private LoggerUtil() { }

    public static String get(String key) {
        String v = PROPS.getProperty(key);
        if (v == null) throw new RuntimeException("Свойство '" + key + "' не найдено");
        return v;
    }

    public static int getInt(String key) {
        return Integer.parseInt(get(key));
    }
}
