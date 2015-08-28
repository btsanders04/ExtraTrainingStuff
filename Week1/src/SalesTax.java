import java.util.*;

public class SalesTax {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int custNum;
		double saleAmt, taxAmt, total;
		String name, taxCode;
		System.out.println("Enter customer number: ");
		custNum=sc.nextInt();
		System.out.println("Enter name: ");
		name = sc.next();
		System.out.println("Enter sales amount: ");
		saleAmt=sc.nextDouble();
		System.out.println("Enter tax code: ");
		taxCode=sc.next();
		
		switch(taxCode){
		
		case("NRM"): taxAmt = .06;
		break;
		
		case("NPF"): taxAmt = 0;
		break;
		
		case("BIZ"): taxAmt = .045;
		break;
		
		default: taxAmt=0;
		break;
		}
		total = saleAmt + saleAmt*taxAmt;
		System.out.println("Total is: $" + total);

	}

}
