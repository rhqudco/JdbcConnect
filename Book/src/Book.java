import java.util.Scanner;

public class Book {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();
        //studentDAO.selectStudent();

        System.out.print("도서 번호 입력 ");
        String bookNo = scan.nextLine();

        System.out.print("도서 제목 입력 ");
        String bookTitle = scan.nextLine();

        System.out.print("저자 입력 ");
        String bookAuthor = scan.nextLine();

        System.out.print("발행연도 입력 ");
        int bookYear = scan.nextInt();
        scan.nextLine();

        System.out.print("가격 입력 ");
        int bookPrice = scan.nextInt();
        scan.nextLine();

        System.out.print("출판사 입력 ");
        String bookPublisher = scan.nextLine();

        BookDTO bookDTO =
                new BookDTO(bookNo, bookTitle, bookAuthor, bookYear, bookPrice, bookPublisher);
        bookDAO.insertBook(bookDTO);
        bookDAO.selectBook();
    }
}