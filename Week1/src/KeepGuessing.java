import java.util.*; 
public class KeepGuessing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		int rdmNum,numChosen;
		rdmNum = r.nextInt(10)+1;
		System.out.println(rdmNum);
		numChosen=11;
		System.out.println("I have chosen a number between 1 and 10. Try to guess it");
		while(numChosen != rdmNum)
		{
			numChosen = sc.nextInt();
			System.out.println("Your guess: "+ numChosen);
			if(numChosen != rdmNum){
				System.out.println("That is incorrect. Guess again.");
			}
		}
		System.out.println("That is right! You're a good guesser.");
	}

}
