package readProperties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {

    Config config = readConfig();

    static Config readConfig()
    {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String URL = readConfig().getString("url");

    String TEST_USERNAME = readConfig().getString("userParam.test.username");
    String TEST_PASSWORD = readConfig().getString("userParam.test.password");
    String PRODUCT_NAME = readConfig().getString("productName");
}
