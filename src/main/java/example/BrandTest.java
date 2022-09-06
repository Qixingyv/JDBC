package example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import pojo.Brand;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.util.*;

public class BrandTest {

    public static void main(String[] args) throws Exception {

        Properties properties = new Properties();
        properties.load(new FileInputStream("C:/WorkSpace/Maven-Project/JDBC/src/Druid.properties"));

        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection conn = dataSource.getConnection();

        String sql = "select * from tb_brand";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);

        ResultSet resultSet = preparedStatement.executeQuery();

        Collection brands = new ArrayList();
        while(resultSet.next())
        {
            Brand brand = new Brand();
            brand.setId(resultSet.getInt("id"));
            brand.setBrand_name(resultSet.getString("brand_name"));
            brand.setCompanyName(resultSet.getString("company_name"));
            brand.setDescription(resultSet.getString("description"));
            brand.setOrdered(resultSet.getInt("ordered"));
            brand.setStatus(resultSet.getInt("status"));
            brands.add(brand);
        }


        Iterator iterator = brands.iterator();
        while (iterator.hasNext())
        {
            Brand b = (Brand) iterator.next();
            System.out.println(b.toString());
        }
    }
}
