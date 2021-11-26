package db5;

import java.sql.*;

// 생성자에서 DB 연결
// select 기능 메소드 구현
// insert 기능 메소드 구현
public class StudentDAO {
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

            if(connection != null) {
                System.out.println("연결 성공");
            }
        } catch (Exception e) {
            System.out.println("연결 오류 발생!");
            e.printStackTrace();
        }
    }
    // select Method
    public void selectStudent()  {
        try {
            String sql = "select * from student order by stdNo";
            preparedStatement = connection.prepareStatement(sql);
            resultset = preparedStatement.executeQuery(sql);

            while (resultset.next()) {
                String stdNo = resultset.getString(1);
                String stdName = resultset.getString(2);
                int stdYear = resultset.getInt(3);
                String stdAddress = resultset.getString(4);
                Date stdBirthday = resultset.getDate(5);
                String dptNo = resultset.getString(6);
                System.out.format("%-10s \t %-10s\t %-4d\t %-20s\t %13s\t %s  \n",
                        stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
            }
        } catch(Exception e) {
            System.out.println("select 오류 발생!");
            e.printStackTrace();
        }
    }
    // insert Method
    public void insertStudent(StudentDTO studentDTO) {
        try{
            String sql = "insert into student values(?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, studentDTO.getStdNo());
            preparedStatement.setString(2, studentDTO.getStdName());
            preparedStatement.setInt(3, studentDTO.getStdYear());
            preparedStatement.setString(4, studentDTO.getStdAddress());
            preparedStatement.setString(5, studentDTO.getStdBirthday());
            preparedStatement.setString(6, studentDTO.getDptNo());
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
