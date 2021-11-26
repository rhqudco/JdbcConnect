package productDB5;

public class ProductSelect {
    public void productSelect() {
        ProductDAO productDAO = new ProductDAO();
        productDAO.selectProduct();
    }
}
