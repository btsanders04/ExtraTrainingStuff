import java.util.*;
public class ProductDB {

	private ArrayList<Product> products = new ArrayList<Product>();
	
	public ProductDB(){
		addProduct(new Product("java","Murach's Beginning Java",49.50));
		addProduct(new Product("jsps","Murach's Java Servlets and JSP",49.50));
		addProduct(new Product("banana","Banana",0.34));
		addProduct(new Product("hdd","2TB Mechanical Hard Drive",150.00));
		addProduct(new Product("flash","32Gb flash drive",23.68));
		addProduct(new Product("ssd","240GB Solid State Drive",200.00));
		addProduct(new Product("bal","David Baldacci's #1 Best Seller",23.50));
		addProduct(new Product("app","Best Android Application on the market",9.99));
		addProduct(new Product("cof","Starbucks Coffee",5.73));
		this.randomTaxes();
	}
	
	public Product getProduct(String code){
		for(Product p: products){
			if(Validator.correctCode(code, p)){
				return p;
			}
		}
		return null;
	}
	
	public void addProduct(Product p){
		products.add(p);
	}
	
	private void randomTaxes(){
		Random r = new Random();
		for(Product p: products){
			p.setTaxable(r.nextBoolean());
		}
	}
	
}
