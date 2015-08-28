import java.text.DecimalFormat;
import java.util.*;
public class InvoiceStorage {

	private static ArrayList<Invoice> invoices = new ArrayList<Invoice>();
	private static HashMap<String,double[]> salesOrder = new HashMap<String,double[]>();

	public InvoiceStorage(){}
	
	public void addInvoice(Invoice i){
		invoices.add(i);
	}

	@Override
	public String toString() {
		String s="";
		for(Invoice i : invoices){
			s+= i;
		}
		
		return s;
	}
	
	private void consolidateInvoices(){
	
		
		for(Invoice i : invoices){
			for(LineItem l : i.getInvoice()){
				String code = l.getProduct().getCode();
				int quant = l.getQuantity();
				double total = l.getTotal();
				double price = l.getProduct().getPrice();
				double[] sale = new double[3]; 
				if(salesOrder.containsKey(code)){
					sale=salesOrder.get(code);
					sale[0]+=quant;
					sale[1]+=total;
					}
				else{
					sale[0]=quant;
					sale[1]=total;
					}
				sale[2]=0;
				salesOrder.put(code,sale);
			
			}
		}

		Iterator<Map.Entry<String, double[]>> entries = salesOrder.entrySet().iterator();
	
		while(entries.hasNext()){
			Map.Entry<String, double[]> entry = entries.next();
			String code = entry.getKey();
			double[] sale = entry.getValue();
			sale[2]=sale[1]/sale[0];
			salesOrder.put(code,sale);
			
		}
	}
	
	public String salesReport(){
		String s="Sales Order\n";
		String key="";
		double[] order;
		DecimalFormat df = new DecimalFormat("#0.00");
		consolidateInvoices();
		s+=String.format("%-10s%-10s%-10s%-10s", "Code", "Qty", "Total", "Average Price");
		s+="\n";
		s+=String.format("%-10s%-10s%-10s%-10s", "----", "---", "-----", "-------------");
		s+="\n";
		
		for(Map.Entry<String,double[]> entry : salesOrder.entrySet()){
			key = entry.getKey();
			order = entry.getValue();
			s+=String.format("%-10s%-10s%-10s%-10s",key,order[0],df.format(order[1]),df.format(order[2]));
			s+="\n";
		}
		
		return s;
	}
	
	
}
