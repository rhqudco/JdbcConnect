package db5;
import student.StudentDTO;
import java.util.Scanner;

public class StudentSelect{
    public void studentSelect() {
        StudentDAO studentDAO = new StudentDAO();
        studentDAO.selectStudent();
    }
}
