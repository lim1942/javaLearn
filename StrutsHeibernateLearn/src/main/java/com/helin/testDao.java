package com.helin;
import com.helin.dao.ProductDAO;
import com.helin.pojo.Product;

public class testDao {
    public static void main(String[] args){
        Product product = new Product();
        product.setName("iphone8");
        product.setPrice(5888);
        ProductDAO productDAO = new ProductDAO();
        productDAO.add(product);
        System.out.println(productDAO.listProduct());
        productDAO.delete(1);
    }
}
