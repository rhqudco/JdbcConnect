package db5;

import java.util.Scanner;

public class StudentEx {
    public static void main(String[] args) {
        System.out.println("************************************");
        System.out.println("\t 학생 관리 프로그램");
        System.out.println("************************************");
        System.out.println("\t 메뉴에서 선택");
        System.out.println("************************************");
        System.out.println("1. 학생 등록");
        System.out.println("2. 학생 정보 조회");
        System.out.println("3. 학새 정보 수정");
        System.out.println("4. 학생 정보 삭제");
        System.out.println("5. 종료");
        System.out.println("************************************");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                StudentInsert studentInsert = new StudentInsert();
                studentInsert.studentInsert();
                break;
            case 2:
                StudentSelect studentSelect = new StudentSelect();
                studentSelect.studentSelect();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.println("잘못된 입력");
                break;
        }
    }
}
