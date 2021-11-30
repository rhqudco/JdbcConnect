package db8AddInterface;

import student.StudentDAO;
import student.StudentDTO;

import java.util.Scanner;

public class StudentInsertArr {
    public void studentInsert () {
        Scanner scan = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();

        System.out.print("학번 입력 ");
        String stdNo = scan.nextLine();

        System.out.print("이름 입력 ");
        String stdName = scan.nextLine();

        System.out.print("학년 입력 ");
        int stdYear = scan.nextInt();
        scan.nextLine();

        System.out.print("주소 입력 ");
        String stdAddress = scan.nextLine();

        System.out.print("생년월일 입력 ");
        String stdBirthday = scan.nextLine();

        System.out.print("학과코드 입력 ");
        String dptNo = scan.nextLine();

        StudentDTO studentDTO =
                new StudentDTO(stdNo, stdName, stdYear, stdAddress, stdBirthday, dptNo);
        studentDAO.insertStudent(studentDTO);
    }
}
