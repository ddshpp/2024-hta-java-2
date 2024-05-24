import ConfigTest.ConfigTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
    public static Statement statement;
    public static Connection connection = null;

    public static Statement startConnection() throws SQLException {
        try {
            Class.forName(ConfigTest.DRIVER.getValue());
            connection = DriverManager.getConnection(ConfigTest.URL.getValue(),
                    ConfigTest.USER.getValue(), ConfigTest.PASSWORD.getValue());
            System.out.println("연결 성공");
        } catch (Exception e) {
            throw new RuntimeException("연결 안됐어요!!!!!!!!!!!!!");
        }
        return statement = connection.createStatement();
    }

    public static void closeConnection() {
        try {
            connection.close();
            System.out.println("연결 종료");
        } catch (Exception e) {
            System.out.println("우헤헤헤헤 오류~~!!!");
        }
    }
}
