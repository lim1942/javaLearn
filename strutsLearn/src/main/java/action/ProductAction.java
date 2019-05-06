package action;
import bean.Product;
import com.opensymphony.xwork2.ActionContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.apache.struts2.convention.annotation.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Namespace("/")
@ParentPackage("struts-default")
@Results({@Result(name="show", location="/show.jsp"),
        @Result(name="home", location="/index.jsp"),
        @Result(name="list", location="/list.jsp")})
public class ProductAction {

    //日志对象
    static Logger logger = LogManager.getLogger(ProductAction.class.getName());

    // 用于list页面的 已选择的商品类型
    private List<Integer> selectedProducts;
    public void setSelectedProducts(List<Integer> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }
    public List<Integer> getSelectedProducts() {
        return selectedProducts;
    }
    // 用于展示list页面的所有商品
    private List<Product> products;
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    public List<Product> getProducts() {
        return products;
    }
    // list 页面
    @Action("listProduct")
    public String list() {

        products= new ArrayList();
        selectedProducts = new ArrayList();

        Product p1 = new Product();
        p1.setId(1);
        p1.setName("product1");
        Product p2 = new Product();
        p2.setId(2);
        p2.setName("product2");
        Product p3 = new Product();
        p3.setId(3);
        p3.setName("product3");

        selectedProducts.add(2);
        selectedProducts.add(3);

        products.add(p1);
        products.add(p2);
        products.add(p3);

        return "list";

    }

    // 单个商品对象
    private Product product;
    // 用于jsp页面获取得到该对象
    public void setProduct(Product product) {
        this.product = product;
    }
    public Product getProduct() {
        return product;
    }
    @Action("showProduct")
    public String show() {
        HttpServletRequest request = ServletActionContext.getRequest();
        HttpServletResponse response = ServletActionContext.getResponse();
        System.out.println("request:\t" + request);
        System.out.println("response:\t" + response);
        System.out.println("调用Service");
        product = new Product();
        product.setName("iphone7");
        return "show";
    }
    @Action("addProduct")
    public String add(){
        System.out.println("product.name:"+product.getName());
        Map map = ActionContext.getContext().getSession();
        map.put("name", product.getName());
        return "show";
    }
}