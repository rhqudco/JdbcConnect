package db4;

import java.util.Scanner;

public class ProductEx {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductDAO productDAO = new ProductDAO();
        //studentDAO.selectStudent();

        System.out.print("제품번호 입력 ");
        String prdNo = scan.nextLine();

        System.out.print("제품명 입력 ");
        String prdName = scan.nextLine();

        System.out.print("가격 입력 ");
        int prdPrice = scan.nextInt();
        scan.nextLine();

        System.out.print("제조사 입력 ");
        String prdMaker = scan.nextLine();

        System.out.print("색상 입력 ");
        String prdColor = scan.nextLine();

        System.out.print("카테고리 입력 ");
        String ctgNo = scan.nextLine();

        ProductDTO productDTO =
                new ProductDTO(prdNo, prdName, prdPrice, prdMaker, prdColor, ctgNo);
        productDAO.insertProduct(productDTO);
        productDAO.selectProduct();
    }
}