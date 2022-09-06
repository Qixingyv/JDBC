package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC01 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");

        String url = "jdbc:mysql://120.26.81.186:3306/personal_information?useSSL=false";
        String name = "root";
        String password = "a3366554785";
        Connection conn = DriverManager.getConnection(url,name,password);

        String sql = "select * from account";
        Statement stmt = conn.createStatement();

        ResultSet result = stmt.executeQuery(sql);

//        while(result.next())
//        {
//            int id = result.getInt("id");
//            String name1 = result.getString("name");
//            double money = result.getDouble("money");
//
//            System.out.println(id);
//            System.out.println(name1);
//            System.out.println(money);
//        }
        while(result.next())
        {
            int id = result.getInt("id");
            String usrname = result.getString("name");
            double salary = result.getDouble("money");


        }

        stmt.close();
        conn.close();

    }
}
