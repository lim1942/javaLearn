package com.helin.action;

import com.helin.dao.ProductDAO;
import com.helin.pojo.Product;
import org.apache.struts2.convention.annotation.*;

import java.util.List;


@Namespace("/")
@ParentPackage("struts-default")
@Results({@Result(name="edit", location="/product/edit.jsp"),
//        跳转向action不能用chain，必须用redirect
        @Result(name="list",type="redirect",location="/listProduct.action"),
        @Result(name="listJsp", location="/product/list.jsp")})
public class ProductAction {

    ProductDAO pdao = new ProductDAO();
    private Product product;
    private List<Product> products;

    public List<Product> getProducts() {
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    @Action("addProduct")
    public String add() {
        pdao.add(product);
        return "list";
    }
    @Action("editProduct")
    public String edit() {
        product =pdao.get(product.getId());
        return "edit";
    }
    @Action("deleteProduct")
    public String delete() {
        pdao.delete(product.getId());
        return "list";
    }
    @Action("updateProduct")
    public String update() {
        pdao.update(product);
        return "list";
    }
    @Action("listProduct")
    public String list() {
        products = pdao.listProduct();
        return "listJsp";
    }

}