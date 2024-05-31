package day5.swingTest1;

import ConfigTest.ConfigTest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDAO {
	private Connection conn;
	
	public DepartmentDAO() {
		// TODO Auto-generated constructor stub
		
		String url = ConfigTest.URL.getValue();
		String user = ConfigTest.USER.getValue();
		String password = ConfigTest.PASSWORD.getValue();
		
		try {
			Class.forName( ConfigTest.DRIVER.getValue() );
			this.conn = DriverManager.getConnection( url, user, password );
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		}
	}
	
	// 2차 배열 / ArrayList
	public ArrayList<ArrayList<String>> listDept() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
		
		try {
			String sql = "select id, dname, loc from dept";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				ArrayList<String> value = new ArrayList<String>();
				value.add( rs.getString( "id" ) );
				value.add( rs.getString( "dname" ) );
				value.add( rs.getString( "loc" ) );
				
				values.add( value );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {};
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {};
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {};		
		}
		
		return values;
	}
	
	public ArrayList<DepartmentTO> listDept2() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<DepartmentTO> values = new ArrayList<DepartmentTO>();
		
		try {
			String sql = "select id, dname, loc from dept";
			pstmt = conn.prepareStatement( sql );
			
			rs = pstmt.executeQuery();
			
			while( rs.next() ) {
				DepartmentTO to = new DepartmentTO();
				to.setId( rs.getString( "id" ) );
				to.setDname( rs.getString( "dname" ) );
				to.setLoc( rs.getString( "loc" ) );
				
				values.add( to );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println( "[에러] : " + e.getMessage() );
		} finally {
			if( rs != null ) try { rs.close(); } catch( SQLException e ) {};
			if( pstmt != null ) try { pstmt.close(); } catch( SQLException e ) {};
			if( conn != null ) try { conn.close(); } catch( SQLException e ) {};		
		}
		
		return values;
	}
}





