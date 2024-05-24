import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost/hta";
    private static final String USER = "root";
    private static final String PASSWORD = "!ajdajddl123";
    public static Statement statement;
    public static Connection connection = null;

    public static Statement startConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
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
