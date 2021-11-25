package db4;

import java.sql.*;

public class ProductDAO {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultset;


    // DB연결 생성자
    public ProductDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";

            connection = DriverManager.getConnection(url, user, pwd);

            if(connection != null) {
                System.out.println("연결 성공");
            }
        } catch (Exception e) {
            System.out.println("연결 오류 발생!");
            e.printStackTrace();
        }
    }
    public void selectProduct()  {
        try {
            String sql = "select * from product order by prdNo";
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery(sql);

            while (resultset.next()) {
                String prdNo = resultset.getString(1);
                String prdName = resultset.getString(2);
                int prdPrice = resultset.getInt(3);
                String prdMaker = resultset.getString(4);
                String prdColor = resultset.getString(5);
                String ctgNo = resultset.getString(6);
                System.out.format("%-10s \t %-10s\t %-4d\t %-20s\t %13s\t %s  \n",
                        prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            }
        } catch(Exception e) {
            System.out.println("select 오류 발생!");
            e.printStackTrace();
        }
    }
    // insert Method
    public void insertProduct(ProductDTO productDTO) {
        try{
            String sql = "insert into product values(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, productDTO.getPrdNo());
            preparedStatement.setString(2, productDTO.getPrdName());
            preparedStatement.setInt(3, productDTO.getPrdPrice());
            preparedStatement.setString(4, productDTO.getPrdMaker());
            preparedStatement.setString(5, productDTO.getPrdColor());
            preparedStatement.setString(6, productDTO.getCtgNo());
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("성공");
            }
        }catch (Exception e) {
            System.out.println("insert 오류 발생!");
            e.printStackTrace();
        }
    }
}