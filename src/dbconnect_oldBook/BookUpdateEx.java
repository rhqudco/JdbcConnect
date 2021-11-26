package dbconnect_oldBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class BookUpdateEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("수정 할 도서번호 ");
        String bookNo = scan.nextLine();

        System.out.print("수정 할 도서명 ");
        String bookName = scan.nextLine();

        System.out.print("수정 할 저자명 ");
        String bookAuthor = scan.nextLine();

        System.out.print("수정 할가격 ");
        int bookPrice = scan.nextInt();
        scan.nextLine();

        System.out.print("수정 할 발행일 ");
        String bookDate = scan.nextLine();

        System.out.print("수정 할 재고 ");
        int bookStock = scan.nextInt();
        scan.nextLine();

        System.out.print("출판사 번호  ");
        String pubNo = scan.nextLine();

        try {
            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";
            Connection con = DriverManager.getConnection(url, user, pwd);
            if(con != null) {
                System.out.println("연결 성공");
            }


            String sql = "update book set bookName=?, bookAuthor=?, bookPrice=?, bookDate=?," +
                    "bookStock=?, pubNo=? where bookNo=?";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, bookName);
            pstmt.setString(2, bookAuthor);
            pstmt.setInt(3, bookPrice);
            pstmt.setString(4, bookDate);
            pstmt.setInt(5, bookStock);
            pstmt.setString(6, pubNo);
            pstmt.setString(7, bookNo);
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
