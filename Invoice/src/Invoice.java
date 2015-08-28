import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Invoice {

	private double taxableSubtotal, nonTaxableSubtotal, tax, taxTotal;
	private String name, address;
	private ArrayList<LineItem> invoice = new ArrayList<LineItem>();



	public Invoice() {
		super();
	}
	
	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public void customerInfo(String name, String address){
		
		this.name = name;
		this.address = address;
		
	}
	
	public void addLineItem(LineItem l){
		invoice.add(l);
		tax(l);
	}
	
	private void tax(LineItem item){
		Product p = item.getProduct();
		double total = item.getTotal();
		if(p.isTaxable()){
			taxableSubtotal+=(total);
			addTax(total);
		}
		else nonTaxableSubtotal+=(total);
	}
	
	private void addTax(double price){
		taxTotal+=tax*price;
	}
	
	@Override
	public String toString(){
		NumberFormat df = NumberFormat.getCurrencyInstance();
		String s="";
		s+=String.format("%-10s",name+"\n");
		s+=String.format("%-10s",address+"\n");
		s+=String.format("%-10s", SimpleDateFormat.getDateInstance().format(new Date())+"\n");
		s+="\n";
		s+=String.format("%-10s%-40s%-8s%-5s%-10s%-8s", "Code", "Description", "Price", "Qty", "Taxable", "Total");
		s+="\n";
		s+=String.format("%-10s%-40s%-8s%-5s%-10s%-8s", "----", "-----------", "-----", "---", "-----", "-------");
		s+="\n";
		for(LineItem item : invoice){
			s+=item+"\n";
		}
		s+="\n";
		s+=String.format("%-20s%-10s", "Taxable Subtotal: ",df.format(this.getTaxableSubtotal()));
		s+="\n";
		s+=String.format("%-20s%-10s", "Untaxable Subtotal: " ,df.format(this.getNonTaxableSubtotal()));
		s+="\n";
		s+=String.format("%-20s%-10s", "Tax: " ,df.format(this.getTaxTotal()));
		s+="\n";
		s+=String.format("%-20s%-10s", "Grand Total: " ,df.format(this.getGrandTotal()));
		s+="\n";
		return s;
	}



	public ArrayList<LineItem> getInvoice() {
		return invoice;
	}

	public double getGrandTotal(){
		return taxableSubtotal + nonTaxableSubtotal + taxTotal;
	}
	
	
	
	public double getTaxTotal() {
		return taxTotal;
	}


	public void setTaxTotal(double taxTotal) {
		this.taxTotal = taxTotal;
	}


	public double getTaxableSubtotal() {
		return taxableSubtotal;
	}

	public void setTaxableSubtotal(double taxableSubtotal) {
		this.taxableSubtotal = taxableSubtotal;
	}

	public double getNonTaxableSubtotal() {
		return nonTaxableSubtotal;
	}

	public void setNonTaxableSubtotal(double nonTaxableSubtotal) {
		this.nonTaxableSubtotal = nonTaxableSubtotal;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	
	
	
}
