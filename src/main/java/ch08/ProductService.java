package ch08;
import java.util.HashMap;
import java.util.*;
import java.util.Map;


public class ProductService {
	Map<String,Product> products = new HashMap<>();
	
	public ProductService() {
		Product p = new Product("101","애플사과폰 12","애플전자",1200000,"2020.12.12");
		products.put("101", p);
		p = new Product("102","삼전우주폰 21","삼전전자",1300000,"2021.2.2");
		products.put("102", p);
		p = new Product("103","엘스 듀얼폰","엘스전자",1500000,"2021.3.2");
		products.put("103", p);
	}
	
	public List<Product> findAll(){
		return new ArrayList<>(products.values());
		
		/*
		 * List<Product> rtn = new ArrayList<>(); for(Product product :
		 * products.values()) { rtn.add(product); } return rtn;
		 */
	}
	
	public Product find(String id) {
		return products.get(id);
	}
	
}
