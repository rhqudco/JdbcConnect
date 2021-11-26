package productPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class ProductUpdate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("수정 할 제품번호 ");
        String prdNo = scan.nextLine();

        System.out.print("수정 할 제품명 ");
        String prdName = scan.nextLine();

        System.out.print("수정 할 가격 ");
        int prdPrice = scan.nextInt();
        scan.nextLine();

        System.out.print("수정 제조사 ");
        String prdMaker = scan.nextLine();


        System.out.print("수정 할 색상 ");
        String prdColor = scan.nextLine();

        System.out.print("수정 할 카테고리  ");
        String ctgNo = scan.nextLine();

        try {
            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";
            Connection con = DriverManager.getConnection(url, user, pwd);
            if(con != null) {
                System.out.println("연결 성공");
            }

            String sql = "update Product set prdName=?, prdPrice=?, prdMaker=?, prdColor=?," +
                    "ctgNo=? where prdNo=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, prdName);
            pstmt.setInt(2, prdPrice);
            pstmt.setString(3, prdMaker);
            pstmt.setString(4, prdColor);
            pstmt.setString(5, ctgNo);
            pstmt.setString(6, prdNo);
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