package org.example.demosql2;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {


    public Connection get_connection(){

        Connection connection=null;

        try {
            //Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3307/test?serverTimezone=UTC&useLegacyDatetimeCode=false";
            String user = "root";
            String password = "usbw";
            connection = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Erro de conexão");
        }
        return connection;
    }

}
