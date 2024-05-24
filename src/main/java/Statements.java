import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statements {
    static Statement statement;

    public static void start() throws SQLException {
        statement = Connections.startConnection();
    }

    public static void updateName(String name, int id) throws SQLException {
        String sql = "update emp set ename= \" " + name + "\" where id= \"" + id + "\"";
        System.out.println(statement.executeUpdate(sql));
    }

    public static void getEmp() throws SQLException {
        String sql = "select * from emp";

        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println(
                    resultSet.getInt(1)
                            + " " + resultSet.getString(2)
                            + " " + resultSet.getString(3));
        }
    }

    public static void close() throws SQLException {
        Connections.closeConnection();
        statement.close();
    }
}
