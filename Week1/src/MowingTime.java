import java.util.*;

public class MowingTime {

	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		double l,w,area;
		System.out.println("Enter yard length ");
		l = sc.nextDouble();
		System.out.println("Enter yard width ");
		w = sc.nextDouble();
		area = l*w;
		
		System.out.println("Square yardage is " + area + " sq. yards" + 
				" and the mowing time will be " + area*2 + " minutes");
		
	}
}
