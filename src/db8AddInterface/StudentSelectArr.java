package db8AddInterface;


import java.util.ArrayList;

public class StudentSelectArr {
    public void studentSelect() {
        StudentDAO studentDAO = new StudentDAO();
        // 반환 값 받아야 함.
        ArrayList<StudentDTO> dataSet = new ArrayList<StudentDTO>();
        dataSet = studentDAO.selectStudent();
        for (StudentDTO dto : dataSet) {
            System.out.println(dto);
        }
    }
}
