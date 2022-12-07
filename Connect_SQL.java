
package qlsv.form;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.*;

public class Connect_SQL {
    
    Connection conn = null;
    
    public Connect_SQL(){
        try {
            
                String dbURL = 
                "jdbc:sqlserver://LUONGETO\\SQLEXPRESS:1433;" +
                "databaseName=QLSV;integratedSecurity=true;" +
                "encrypt=true;trustServerCertificate=true";
                String user = "sa";
                String pass = "sa";
                conn = DriverManager.getConnection(dbURL, user, pass);
                if (conn != null) {
                    DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
                    System.out.println("Connect successful");
                }               
    
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (conn != null && !conn.isClosed()) {
                        conn.close();
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
    }
    public static void main(String[] args) {
            System.out.println("Connect SQL:");
            Connect_SQL test = new Connect_SQL();
    }
 

}


