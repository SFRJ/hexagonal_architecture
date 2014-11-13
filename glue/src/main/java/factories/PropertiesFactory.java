package factories;

import org.glassfish.hk2.api.Factory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFactory implements Factory<Properties> {

    public static final String PROPERTIES_FILENAME = "necesary.properties";

    @Override
    public Properties provide() {
        try (final InputStream input = new FileInputStream(PROPERTIES_FILENAME)) {
            final Properties properties = new Properties();
            properties.load(input);
            return properties;
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while loading properties file.", e);
        }
    }

    @Override
    public void dispose(Properties instance) {
    }
}

