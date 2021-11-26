package productPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class ProductSelect {
    public static void main(String[] args) {
        try {

            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";
            Connection con = DriverManager.getConnection(url, user, pwd);

            if(con != null) {
                System.out.println("연결 성공");
            }

            String sql = "select * from Product order by PrdNo";
            PreparedStatement pstmt = con.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery(sql);


            System.out.println("\n상품 정보 조회");
            //System.out.println("상품번호 \t\t 상품명 \t\t\t\t 가격 \t\t제조사 \t 색상 \t\t 카테고리");
            while(rs.next()) {
                // 1. next()하면서 항 행씩 데이터 가져와 변수에 저장
                String prdNo = rs.getString(1);
                String prdName = rs.getString(2);
                int prdPrice = rs.getInt(3);
                String prdMaker = rs.getString(4);
                String prdColor = rs.getString(5);
                String ctgNo = rs.getString(6);
                // 2. 한 행씩 변수에 있는 값 출력
                System.out.format("%-10s %-25s %-10d %6s %13s %3s  \n",
                        prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
            }
            rs.close();
            pstmt.close();
            con.close();

        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }
    }
}
