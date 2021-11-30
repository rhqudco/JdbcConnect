package productDB6ArrayListVer;

import db6ArrayListVer.StudentDTOArr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    // select Method
    public ArrayList<ProductDTO> selectProduct() {
        ArrayList<ProductDTO> dataSet = null;
        try {
            String sql = "select * from product order by prdNo";
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery(sql);

            dataSet = new ArrayList<ProductDTO>();

            while (resultset.next()) {
                dataSet.add(new ProductDTO(resultset.getString(1),
                        resultset.getString(2),
                        resultset.getInt(3),
                        resultset.getString(4),
                        resultset.getString(5),
                        resultset.getString(6))); // DTO 1개가 1행에 해당
            }
        } catch (Exception e) {
            System.out.println("select 오류 발생!");
            e.printStackTrace();
        }
        return dataSet; // ArrayList<ProductDTO> 타입
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
