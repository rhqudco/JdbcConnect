package dbconnect_oldBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BookInsertInputEx {
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
            System.out.print("도서번호 ");
            String bookNo = scan.next();
            System.out.print("도서명 ");
            String bookName = scan.nextLine();
            System.out.print("저자명 ");
            String bookAuthor = scan.next();
            System.out.print("가격 ");
            int bookPrice = scan.nextInt();
            System.out.print("발행일 ");
            String bookDate = scan.next();
            System.out.print("재고 ");
            int bookStock = scan.nextInt();
            System.out.print("출판사 번호  ");
            String pubNo = scan.next();

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
