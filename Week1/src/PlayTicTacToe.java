import java.util.*;
import java.io.*;

/*
 * LET'S GO TO WORK
 */

public class PlayTicTacToe {

	public static void main(String[] args) {
		TicTacToe gameBoard = new TicTacToe();
		Scanner sc = new Scanner(System.in);
		String player1, player2;
		int currentPlayer, posChosen;
		System.out.println("Welcom To TicTacToe");
		System.out.println("Player One Enter Name: ");
		player1=sc.next();
		System.out.println("Player Two Enter Name: ");
		player2=sc.next();
		System.out.println("Good Luck! Start Game");
		System.out.println(gameBoard.draw());
		currentPlayer=0;
		while (!gameBoard.gameOver()){
			
			if(currentPlayer == 0){
				System.out.println( player1 + " please choose position");
			}
			else if(currentPlayer == 1){
				System.out.println( player2 + " please choose position");
			}
			
			posChosen = sc.nextInt();
			gameBoard.play(currentPlayer, posChosen);
			System.out.println(gameBoard.draw());
			if(gameBoard.tie()){
				System.out.println("Game is a tie!");
				break;
			}
			currentPlayer=Math.abs(currentPlayer-1);
		}
		if(!gameBoard.tie()){
		if(Math.abs(currentPlayer-1) == 0){
			System.out.println("Game Over " + player1 + " wins!");
		}
		else {
			System.out.println("Game Over " + player2 + " wins!");
			}
		}
	}
}
	
