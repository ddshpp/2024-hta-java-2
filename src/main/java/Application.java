import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        Statements.start();
        Statements.updateName("우히히히", 213);
        Statements.getEmp();
        Statements.close();
    }
}
