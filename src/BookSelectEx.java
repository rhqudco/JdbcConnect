import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Date;

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

            // 제목 출력
            System.out.println("\n도서 정보 조회");
            System.out.println("도서번호 \t\t 도서명 \t\t\t\t 저자 \t\t가격 \t 발행일 \t\t 재고 \t 출판사번호");
            // executeQuery() 실행 결과 받아온 ResultSet에서 데이터 추출
            // ResultSet의 next() 메소드 이용해서 논리적 커서를 이동하여 각 열의 데이트 바인딩해 옴
            // next() : 커서를 이동하면 다음 행 지정
            // 다음 행이 있으면 true, 없으면 false반환
            // 반복문 이용해서 ture인 동안 다음 행을 계속해서 가져옴
            // 데이터 타입에 맞춰 get@@@() 메소드 사용
            while(rs.next()) {
                // 1. next()하면서 항 행씩 데이터 가져와 변수에 저장
                String bookNo = rs.getString(1);
                String bookName = rs.getString(2);
                String bookAuthor = rs.getString(3);
                int bookPrice = rs.getInt(4);
                Date bookDate = rs.getDate(5);
                int bookStock = rs.getInt(6);
                String pubNo = rs.getString(7);
                // 2. 한 행씩 변수에 있는 값 출력
                System.out.format("%-10s \t %-25s \t %-10s \t %6d \t %13s \t%3d \t %s10 \n",
                        bookNo, bookName, bookAuthor, bookPrice, bookDate, bookStock, pubNo);
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
