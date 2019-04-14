package travel.storage.fromSQL;

import travel.common.buisness.database.datasource.HikariCpDataSource;
import travel.common.solutions.utils.CollectionUtils;

import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.*;

public class H2DbInitor {

    private static final String DATABASE_CONFIG_PATH = "config.properties";
    private static final String DDL_SCRIPT_PATH = "create-schema.sql";

    public void init() {
        try {
            prepareDataSourceConfig();
            createDataBaseStructure();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void prepareDataSourceConfig() throws Exception {
        HikariCpDataSource.HikariCpDataSourceBuilder hikariCpDataSourceBuilder = new HikariCpDataSource.HikariCpDataSourceBuilder();
        Map<DataBaseConfig, String> dbConfigs = readDbConfigFromResources();

        dbConfigs.forEach((param, value) -> {
            switch (param) {

                case URL: {
                    hikariCpDataSourceBuilder.appendUrl(value);
                    break;
                }
                case USER: {
                    hikariCpDataSourceBuilder.appendUserName(value);
                    break;
                }
                case PASSWORD: {
                    hikariCpDataSourceBuilder.appendPassword(value);
                    break;
                }

                case DRIVER: {
                    hikariCpDataSourceBuilder.appendDriver(value);
                    break;
                }
            }
        });
        HikariCpDataSource.init(hikariCpDataSourceBuilder);
    }

    private Map<DataBaseConfig, String> readDbConfigFromResources() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream(DATABASE_CONFIG_PATH));//this.getClass().getResourceAsStream(DATABASE_CONFIG_PATH));

        Map<DataBaseConfig, String> result = new HashMap<>();
        Arrays.stream(DataBaseConfig.values()).forEach(dbConfig ->
                result.put(dbConfig, props.getProperty(dbConfig.getPropName())));

        return result;
    }

    private void createDataBaseStructure() throws Exception {
        List<String> ddl = Files.readAllLines(Paths.get(DDL_SCRIPT_PATH));//this.getClass().getResource(DDL_SCRIPT_PATH).toURI()));

        try (Connection con = HikariCpDataSource.getInstance().getConnection();
             Statement statement = con.createStatement()) {
            statement.execute(String.join("", ddl));
        }
    }


    private void execSql(String sql) throws Exception {
        try (Connection con = HikariCpDataSource.getInstance().getConnection();
             Statement statement = con.createStatement()) {
            statement.execute(sql);
        }
    }
}
