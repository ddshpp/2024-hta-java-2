package day4.Test2;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class EmpTableModel extends AbstractTableModel {
    private final String[] columnNames = {"사원번호", "사원명", "직책", "급여", "호봉", "부서번호", "부서이름", "부서위치"};
    private final ArrayList<EmpTO> datas;

    public EmpTableModel(String strEname) throws ClassNotFoundException, SQLException {
        EmpDAO dao = new EmpDAO();
        datas = dao.searchEname(strEname);
    }

    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return datas.size();
    }

    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return 8;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String result = "";
        EmpTO to = datas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                result = to.getEmpno();
                break;
            case 1:
                result = to.getEname();
                break;
            case 2:
                result = to.getJob();
                break;
            case 3:
                result = to.getSal();
                break;
            case 4:
                result = to.getGrade();
                break;
            case 5:
                result = to.getDeptno();
                break;
            case 6:
                result = to.getDname();
                break;
            case 7:
                result = to.getLoc();
                break;
        }
        return result;
    }
}