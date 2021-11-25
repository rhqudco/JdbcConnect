import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultset;


    // DB연결 생성자
    public BookDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/sqldb1?serverTimezone=UTC";
            String user = "root";
            String pwd = "";

            connection = DriverManager.getConnection(url, user, pwd);

            if(connection != null) {
                System.out.println("연결 성공");
            }
        } catch (Exception e) {
            System.out.println("연결 오류 발생!");
            e.printStackTrace();
        }
    }
    public void selectBook()  {
        try {
            String sql = "select * from book order by bookNo";
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery(sql);

            while (resultset.next()) {
                String bookNo = resultset.getString(1);
                String bookTitle = resultset.getString(2);
                String bookAuthor = resultset.getString(3);
                int bookYear = resultset.getInt(4);
                int bookPrice = resultset.getInt(5);
                String bookPublisher = resultset.getString(6);
                System.out.format("%-10s \t %-10s\t %-10s\t %-10d\t %10d\t %s  \n",
                        bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
            }
        } catch(Exception e) {
            System.out.println("select 오류 발생!");
            e.printStackTrace();
        }
    }
    // insert Method
    public void insertBook(BookDTO bookDTO) {
        try{
            String sql = "insert into book values(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, bookDTO.getBookNo());
            preparedStatement.setString(2, bookDTO.getBookTitle());
            preparedStatement.setString(3, bookDTO.getBookAuthor());
            preparedStatement.setInt(4, bookDTO.getBookYear());
            preparedStatement.setInt(5, bookDTO.getBookPrice());
            preparedStatement.setString(6, bookDTO.getBookPublisher());
            int result = preparedStatement.executeUpdate();
            if(result > 0) {
                System.out.println("성공");
            }
        }catch (Exception e) {
            System.out.println("insert 오류 발생!");
            e.printStackTrace();
        }
    }
}