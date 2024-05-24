import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException {
        Statements.start();
        Statements.updateName("테스트입력", 213);
        Statements.getEmp();
        Statements.close();
        Statements.getTable();
    }
}
