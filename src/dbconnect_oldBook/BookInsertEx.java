package dbconnect_oldBook;

import java.sql.*;
import java.util.Date;
import java.util.Scanner;

public class BookInsertEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try {
            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";
            Connection con = DriverManager.getConnection(url, user, pwd);
            if (con != null) {
                System.out.println("연결 성공");
            }
            String bookNo = "1006";
            String bookName = "알고리즘";
            String bookAuthor = "김철수";
            int bookPrice = 25000;
            String bookDate = "김철수";
            int bookStock = 10;
            String pubNo = "1";

            String sql = "insert into book values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            pstmt.setString(2, bookName);
            pstmt.setString(3, bookAuthor);
            pstmt.setInt(4, bookPrice);
            pstmt.setString(5, bookDate);
            pstmt.setInt(6, bookStock);
            pstmt.setString(7, pubNo);
            int result = pstmt.executeUpdate();
            if(result > 0) {
                System.out.println("성공");
            }
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }
    }
}
