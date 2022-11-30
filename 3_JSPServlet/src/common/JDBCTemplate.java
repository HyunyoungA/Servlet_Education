package common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class JDBCTemplate {

    
   
   private JDBCTemplate() {}
   
   public static Connection getConnection() {
	  Connection conn = null;
	  Properties prop =  new Properties();
	  //내 클래스 정보를 가져오기 getResource("/sql/driver.properties")소스 부분.getPath();-->거기에 대한 경로를 가져오기
	  String fileName = JDBCTemplate.class.getResource("/sql/driver.properties").getPath();
      try {
    	  prop.load(new FileReader(fileName));
    	  
    	 //Class.forName("oracle.jdbc.driver.OracleDriver");
    	  Class.forName(prop.getProperty("driver"));
         //conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1522:orcl", "JSP_Servlet", "JSP_Servlet");
    	  conn = DriverManager.getConnection(prop.getProperty("url"),
    			  							 prop.getProperty("username"),
    			  							 prop.getProperty("password"));
      } catch (ClassNotFoundException e) {
			e.printStackTrace();
      } catch (SQLException e) {
			e.printStackTrace();
      } catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
      try {
		conn.setAutoCommit(false);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 

      return conn;
      
   }
   

   public static void close(Connection conn) {
      try {
         if (conn != null && !conn.isClosed()) {
            conn.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void close(Statement stmt) {
      // 다형성때문에 Statement 에 PreparedStatement를 받아줄 수 있어서. 따로 안만들어줘도 됨.
      try {
         if (stmt != null && !stmt.isClosed()) {
            stmt.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   public static void close(ResultSet rset) {
      try {
         if (rset != null && !rset.isClosed()) {
            rset.close();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   

   public static void commit(Connection conn) {
      try {
         if (conn != null && !conn.isClosed()) {
            conn.commit();
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   public static void rollback(Connection conn) {
	  try {
	     if (conn != null && !conn.isClosed()) {
	        conn.rollback();
	     }
	  } catch (SQLException e) {
	     e.printStackTrace();
	  }
   }

}
