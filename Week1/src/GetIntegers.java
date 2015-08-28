import java.util.Scanner;

public class GetIntegers {
    public static void main (String[] args)
    {
        Scanner keyboard = new Scanner(System.in);
        
        int num, total = 0;
        
        for(int i=0; i< 10; i++){
        	num = keyboard.nextInt();
        	total += num;
        }
        
        System.out.println("The total of all 10 numbers is " + total);
    }
}