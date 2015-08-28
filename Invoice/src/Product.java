
public class Product {

	private String code;
	private String description;
	private double price;
	private boolean taxable = false;
	


	public Product(String c, String d, double p){
		code=c;
		description=d;
		price=p;
	}

	public String getCode() {
		return code;
	}

	
	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

	public boolean isTaxable() {
		return taxable;
	}

}
