package db8AddInterface;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StudentDAO implements IStudentDAO {
    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultset;

    // DB연결 생성자
    public StudentDAO() {
        try {
            String url = "jdbc:mysql://localhost:3306/sqldb6?serverTimezone=UTC";
            String user = "root";
            String pwd = "";

            connection = DriverManager.getConnection(url, user, pwd);

            if (connection != null) {
                System.out.println("연결 성공");
            }
        } catch (Exception e) {
            System.out.println("연결 오류 발생!");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<StudentDTO> selectStudent() {
        ArrayList<StudentDTO> dataSet = null;
        try {
            String sql = "select * from student order by stdNo";
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery(sql);

            dataSet = new ArrayList<StudentDTO>();

            while (resultset.next()) {
                dataSet.add(new StudentDTO(resultset.getString(1),
                        resultset.getString(2),
                        resultset.getInt(3),
                        resultset.getString(4),
                        resultset.getDate(5).toString(),
                        resultset.getString(6))); // DTO 1개가 1행에 해당
            }
        } catch (Exception e) {
            System.out.println("select 오류 발생!");
            e.printStackTrace();
        }
        return dataSet; // ArrayList<StudentDTOArr> 타입
    }

    @Override
    public void insertStudent(StudentDTO studentDTO) {
        try {
            String sql = "insert into student values(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentDTO.getStdNo());
            preparedStatement.setString(2, studentDTO.getStdName());
            preparedStatement.setInt(3, studentDTO.getStdYear());
            preparedStatement.setString(4, studentDTO.getStdAddress());
            preparedStatement.setString(5, studentDTO.getStdBirthday());
            preparedStatement.setString(6, studentDTO.getDptNo());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                System.out.println("성공");
            }
        } catch (Exception e) {
            System.out.println("insert 오류 발생!");
            e.printStackTrace();
        }
    }
}





