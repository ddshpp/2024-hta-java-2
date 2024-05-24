import ConfigTest.ConfigTest;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.pool.HikariPool;
import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HikariTest {
    private static final Logger log = LoggerFactory.getLogger(HikariTest.class);
    static HikariConfig hikariConfig = new HikariConfig();
    static HikariDataSource dataSource;
    private final HikariPool hikariPool;

    public static void main(String[] args) throws SQLException {
        createDataSource();
        Connection connection = getConnection();
        log.info(connection.toString());
        connectionTest();

        log.getName();
    }

    private HikariTest(HikariPool hikariPool) {
        this.hikariPool = hikariPool;
    }

    public static Connection getConnection() throws SQLException {
        System.out.println("dd2");
        return dataSource.getConnection();
    }

    private static void createDataSource() {
        hikariConfig.setDriverClassName(ConfigTest.DRIVER.getValue());
        hikariConfig.setJdbcUrl(ConfigTest.URL.getValue());
        hikariConfig.setUsername(ConfigTest.USER.getValue());
        hikariConfig.setPassword(ConfigTest.PASSWORD.getValue());
        dataSource = new HikariDataSource(hikariConfig);
        System.out.println("dd1");
    }


    public static void connectionTest() throws SQLException {
        dataSource.getConnection();
        System.out.println("dd3");
    }

    public HikariPool getHikariPool() {
        return hikariPool;
    }
}
