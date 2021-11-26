package productPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductInsert {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";
            Connection con = DriverManager.getConnection(url, user, pwd);
            if(con != null) {
                System.out.println("연결 성공");
            }

            String prdNo = "1016";
            String prdName = "무선 보조배터리";
            int prdPrice = 30000;
            String prdMaker = "상성전자";
            String prdColor = "화이트";
            String ctgNo = "3";

            String sql = "insert into Product values(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            System.out.println("\n상품 정보 삽입");
            //System.out.println("상품번호 \t\t 상품명 \t\t\t\t 가격 \t\t제조사 \t 색상 \t\t 카테고리");
            pstmt.setString(1, prdNo);
            pstmt.setString(2, prdName);
            pstmt.setInt(3, prdPrice);
            pstmt.setString(4, prdMaker);
            pstmt.setString(5, prdColor);
            pstmt.setString(6, ctgNo);

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