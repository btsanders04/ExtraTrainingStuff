import java.util.*;
public class InvoiceApp {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double price, tax;
		String cont, name, address, code;
		Product product;
		ProductDB database = new ProductDB();
		InvoiceStorage records = new InvoiceStorage();
		boolean taxable;
		int quantity;
		
		System.out.println("Welcome to the Invoice Application.");
		System.out.println("Enter Name: ");
		name = sc.nextLine();
		System.out.println("Enter Address: ");
		address = sc.nextLine();
		System.out.println();
		do{
		Invoice inv = new Invoice();
		inv.customerInfo(name, address);
		System.out.println("Enter Tax Rate: ");
		tax=sc.nextDouble();
		sc.nextLine();
		inv.setTax(tax);
		System.out.println("To Exit Invoice type 'Exit' under Product");
		invoiceLoop:
		do{
			do{
			System.out.println("Enter Product Code: ");
			code = sc.nextLine();
			product = database.getProduct(code);
			if(product==null){
				System.out.print("Error! Code not recognized. ");
			}
			if(code.equalsIgnoreCase("exit")){
				break invoiceLoop;
			}
			}while(product==null);

			do{
			System.out.println("Enter Quantity: ");
			quantity = sc.nextInt();
			sc.nextLine();
			if(!Validator.checkQuantity(quantity)){
				System.out.println("Error, wrong quantity.");
			}
			}while(!Validator.checkQuantity(quantity));
			inv.addLineItem(new LineItem(product,quantity));
		}while(!code.equalsIgnoreCase("exit"));
		records.addInvoice(inv);
		System.out.println("Would you like to create another invoice? (y/n)");
		}while(sc.nextLine().equalsIgnoreCase("y"));
		System.out.println(records.salesReport());
		
		
		}
	}

