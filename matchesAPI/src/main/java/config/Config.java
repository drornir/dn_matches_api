package config;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.File;

import static java.lang.System.exit;

/**
 * Created by Dror Nir on 26/05/2017.
 */
public class Config {
    private static Config ourInstance = new Config();
    private static Configuration config;

    public static Configuration get() {
        return config;
    }

    private Config() {
        Configurations configs = new Configurations();
        try {
            config = configs.properties("matchesapi.properties");
        } catch (ConfigurationException cex) {
            System.err.println("Unable to read configuration: " + cex.getMessage());
            System.err.println("HINT: should be placed in ./matchesapi.properties");
            cex.printStackTrace(System.err);
            exit(1);
        }
    }
}
