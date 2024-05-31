package day4.Test2;

import ConfigTest.ConfigTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpDAO {
    private final ArrayList<EmpTO> datas = new ArrayList<EmpTO>();
    private Connection conn = null;

    public ArrayList<EmpTO> searchEname(String strEname)
            throws ClassNotFoundException, SQLException {
        String url = ConfigTest.URL2.getValue();
        String user = ConfigTest.USER.getValue();
        String password = ConfigTest.PASSWORD.getValue();

        Class.forName(ConfigTest.DRIVER.getValue());
        this.conn = DriverManager.getConnection(url, user, password);

        String sql =
                "select id, ename, job, sal, grade, dept_id, dname, loc from emp e join dept d using (id) join salgrade s on (sal between s.losal and s.hisal) where ename = ?";
        PreparedStatement pstmt = this.conn.prepareStatement(sql);
        pstmt.setString(1, strEname);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            EmpTO data = new EmpTO();
            data.setEmpno(rs.getString("empno"));
            data.setEname(rs.getString("ename"));
            data.setJob(rs.getString("job"));
            data.setSal(rs.getString("sal"));
            data.setGrade(rs.getString("grade"));
            data.setDeptno(rs.getString("deptno"));
            data.setDname(rs.getString("dname"));
            data.setLoc(rs.getString("loc"));

            datas.add(data);
        }

        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }

        return datas;
    }
}