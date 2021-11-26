package productDB5;

import java.util.Scanner;

public class ProductEx {
    public static void main(String[] args) {
        System.out.println("************************************");
        System.out.println("\t 제품 관리 프로그램");
        System.out.println("************************************");
        System.out.println("\t 메뉴에서 선택");
        System.out.println("************************************");
        System.out.println("1. 제품 등록");
        System.out.println("2. 제품 정보 조회");
        System.out.println("3. 제품 정보 수정");
        System.out.println("4. 제품 정보 삭제");
        System.out.println("5. 종료");
        System.out.println("************************************");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                ProductInsert productInsert = new ProductInsert();
                productInsert.productInsert();
                break;
            case 2:
                ProductSelect productSelect = new ProductSelect();
                productSelect.productSelect();
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