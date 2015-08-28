import java.util.Scanner;

public class PairProcess {
	public static void main(String[] args) {
		int num1, num2, sum, product;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print( "First Number? :" );
		num1 = keyboard.nextInt();
		
		System.out.print( "Last Number?  :" );
		num2 = keyboard.nextInt();
		
		sum = num1 + num2;
		product = num1 * num2;
		System.out.print("Sum is: " + sum);
		
		if(sum > 200){
			System.out.println("*");
		}
		
		System.out.println("Product is: " + product);
		
	}
}