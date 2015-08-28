import java.util.*;
public class Validator {

	public static boolean correctCode(String code, Product product){
		if(product.getCode().equalsIgnoreCase(code)){
			return true;
		}
		return false;
	}
	
	public static boolean checkPrice(double price){
		if(price>= 0 && price<1000){
			return true;
		}
		return false;
	}
	

	public static boolean checkQuantity(int amount){
		if(amount > 0 && amount < 50){
			return true;
		}
		return false;
	}
	
}
