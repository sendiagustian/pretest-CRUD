package absenkariawan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class koneksi {
    static Connection con;
    public static Connection getKoneksi(){
        try {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_absen","root","");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return con;
    }
}
