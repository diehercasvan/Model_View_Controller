
package Model_;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DIEGO CASALLAS
 */
public class ConnectionDataBase {
   protected Connection con;
    protected Statement stmt;
    private final String sServerName = "localhost";
    private final String sPortNumber = "3306";
    private final String sDataBaseName = "ConnectionMVC";
    private final String sUrl = "jdbc:mysql://"+sServerName+":"+sPortNumber+"/" + sDataBaseName;
    private final String sUserName = "root";
    private final String sPassword = "";
    private String sErrorString; 
     public ConnectionDataBase() {

    }

    private String getConnectionUrl() {
        return sUrl;
    }

    public Connection connect() {
        con = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(getConnectionUrl(),sUserName,sPassword);
            stmt=con.createStatement();
            System.out.println("Connect");  
        }
        catch(ClassNotFoundException | SQLException e)
        {
        this.sErrorString="An error occurred while connecting wing database";
        System.out.println(sErrorString);
        return null;
        }
        return con;

    }

    public  void disconnect(){
        
        try
        {
            stmt.close();
            con.close();
        }
        catch(SQLException e){
        
        }
    
    }
    public  Statement getStmt(){
    
    return this.stmt;
    
    }
}
