package dbconnect_oldBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BookDeleteEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("삭제할 도서번호 입력");
        String bookNo = scan.next();
        try {
            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";
            Connection con = DriverManager.getConnection(url, user, pwd);
            if (con != null) {
                System.out.println("연결 성공");
            }

            String sql = "delete from book where bookNo=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookNo);
            // 성공 여부를 출력하기 위해 result에 값을 넣어서 확인
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