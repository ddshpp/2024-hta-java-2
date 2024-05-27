package day1;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Statements {
    static Statement statement;

    public static void start() throws SQLException {
        statement = Connections.startConnection();
    }

    public static void getTable() throws SQLException {
        DatabaseMetaData databaseMetaData = Connections.databaseMetaDataTest();
        ResultSet resultSet = databaseMetaData.getTables(null, null, null, new String[]{"TABLE"});

        while (resultSet.next()) {
            String tableName = resultSet.getString("TABLE_NAME");
            System.out.println("<" + tableName + ">");

            ResultSet columns = databaseMetaData.getColumns(null, null, tableName, null);
            while (columns.next()) {
                String columnName = columns.getString("COLUMN_NAME");
                System.out.print(columnName + "\t");
            }

            System.out.println(System.lineSeparator());
        }
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
