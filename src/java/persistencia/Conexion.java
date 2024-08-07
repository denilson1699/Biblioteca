package persistencia;
import java.sql.*;
public class Conexion {

//conexion con sqlserver
public Connection getConexionSqlServer(){
  
    Connection cn;
    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        cn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-96VV661\\SQLEXPRESS:1433;databaseName=BD_BIBLIOTECA;user=sa;password=123;encrypt=true;trustServerCertificate=true");
        //DESKTOP-96VV661\SQLEXPRESS
    
    }catch(ClassNotFoundException e){
        System.out.println("error:"+e.getMessage());
        cn=null;
    }catch(SQLException e){
        System.out.println("error:"+e.getMessage());
        cn=null;
    } catch (Exception e) {
        cn=null;
    }
    return cn;
   
}
    
}
