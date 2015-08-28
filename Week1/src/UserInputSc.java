import java.util.*;
public class UserInputSc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		outer:
		for(int i=0; i<4; i++){
			while(true){
				num = sc.nextInt();
				if(num == 666){
					break outer;
				}
			}
		}
	}

}
