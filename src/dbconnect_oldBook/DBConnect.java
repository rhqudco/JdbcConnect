package dbconnect_oldBook;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args)  {
        try {
            // JDBC Driver 클래스의 객체 생성 런타임시 로드
            //Class.forName("com.mysql.cj.jdbc.Driver");
            // 연결 주소, 사용자 계정, 패스워드 문자열 변수 등록
            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";

            // DB연결 위한 객체 생성
            // DriverManager 통해 Connection 객체 생성
            //MySQL 서버 연결 : 주소, 사용자 계정, 패스워드 전송
            Connection con = DriverManager.getConnection(url, user, pwd);

            if(con != null) {
                System.out.println("연결 성공");
            }
        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }

    }
}
