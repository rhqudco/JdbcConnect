package db8AddInterface;

import db6ArrayListVer.StudentDTOArr;

import java.util.ArrayList;

// 인터페이스 : 표준 규격을 정해놓음.
// @Override 오바리이드 해야 함.
public interface IStudentDAO {
    // 추상 메소드(바디 없음)
    // IStudentDAO 인터페이스를 구현하는 클래스에서 반드시 구현해야 함.
    public ArrayList<StudentDTO> selectStudent();
    public void insertStudent(StudentDTO studentDTO);
}
