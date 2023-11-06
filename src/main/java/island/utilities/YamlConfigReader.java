package island.utilities;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;

public class YamlConfigReader {
    private final HashMap<String, Object> configMap;

    public YamlConfigReader(Class<?> clazz) {
        Config Config = clazz.getAnnotation(Config.class);
        if (Config == null) {
            throw new IllegalArgumentException("Class must be annotated with @Config");
        }

        String yamlFilePath = Config.fileName();
        Yaml yaml = new Yaml();

        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(yamlFilePath)) {
            configMap = yaml.load(inputStream);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    public HashMap<String, Object> getConfigMap() {
        return configMap;
    }
}
