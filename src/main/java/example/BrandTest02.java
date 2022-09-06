package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 添加
 * 1. SQL：insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?);
 * 2. 参数：需要，除了id之外的所有参数信息
 * 3. 结果：boolean
 */
public class BrandTest02 {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("C:/WorkSpace/Maven-Project/JDBC/src/Druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection conn = dataSource.getConnection();

        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values(?,?,?,?,?)";
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 1;

        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,brandName);
        pstm.setString(2,companyName);
        pstm.setInt(3,ordered);
        pstm.setString(4,description);
        pstm.setInt(5,status);

        int value = pstm.executeUpdate();
        System.out.println(value);



    }
}
