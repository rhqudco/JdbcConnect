import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookSelectEx {
    public static void main(String[] args) {
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

            // select 쿼리문 문자열 작성
            String sql = "select * from book order by bookNo";

            // 쿼리문 전송을 위한 PreparedStatement 객체 생성
            // Connection 인터페이스와 PreparedStatement() 메소드 사용하여 객체 생성
            PreparedStatement pstmt = con.prepareStatement(sql);

            // 쿼리문 실행하고 결과 받아옴
            // select 구문이므로 executeQuery() 메소드 사용
            // 반환되는 결과는 ResultSet객체가 반응
            ResultSet rs = pstmt.executeQuery(sql);

            // executeQuery() 실행 결과 받아온 ResultSet에서 데이터 추출
        } catch (Exception e) {
            System.out.println("오류 발생!");
            e.printStackTrace();
        }
    }
}
