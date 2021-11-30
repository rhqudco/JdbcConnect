package db6ArrayListVer;
import student.StudentDTO;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentSelectArr {
    public void studentSelect() {
        StudentDAOArr studentDAO = new StudentDAOArr();
        // 반환 값 받아야 함.
        ArrayList<StudentDTOArr> dataSet = new ArrayList<StudentDTOArr>();
        dataSet = studentDAO.selectStudent();
        for (StudentDTOArr dto : dataSet) {
            System.out.println(dto);
        }
    }
}
