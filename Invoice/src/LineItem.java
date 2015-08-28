
public class LineItem {
	private Product product;
	private int quantity;
	private double total;
	
	public LineItem(Product p,  int q){
		quantity=q;
		product = p;
		total = product.getPrice()*quantity;
	}

	@Override
	public String toString() {
		return String.format("%-10s%-40s%-8s%-5s%-10s%4.2f",product.getCode(),product.getDescription(),
				product.getPrice(),quantity,product.isTaxable(),total);
	}

	public Product getProduct() {
		return product;
	}

	public double getTotal() {
		return total;
	}

	public int getQuantity() {
		return quantity;
	}

	
	
}
