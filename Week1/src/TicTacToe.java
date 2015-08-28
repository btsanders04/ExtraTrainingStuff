
public class TicTacToe {

	String[] board = new String[9];
	
	public TicTacToe(){
		
		for(int i=0; i<9;i++){
			board[i]=""+ i + "";
		}
	}
	
	public String draw(){
		
		return board[0] + "|" + board[1] + "|" + board[2] + " \n"  
			 + "-------\n"  
			 + board[3] + "|" + board[4] + "|" + board[5] + " \n" 
			 + "-------\n"
			 + board[6] + "|" + board[7] + "|" + board[8] + " \n";
	}		
	
	public void play(int player, int pos){
		String gamePiece = "";
		if(player == 0){
			gamePiece = "X";
		}
		else if(player == 1){
			gamePiece = "O";
		}
		
		board[pos]=gamePiece;		
	}
	
	public boolean gameOver(){
		if (board[0] == board[1] && board[1] == board[2] ||
			board[0] == board[3] && board[3] == board[6] ||
			board[0] == board[4] && board[4] == board[8] ||
			board[3] == board[4] && board[4] == board[5] ||
			board[6] == board[7] && board[7] == board[8] ||
			board[6] == board[4] && board[4] == board[2] ||
			board[1] == board[4] && board[4] == board[7] ||
			board[2] == board[5] && board[5] == board[8])
			return true;
		else return false;	
	}
	
	public boolean tie(){
		for(String pos : board){
			
			if(pos!="X" && pos != "O")
				return false;
		}
		return true;
	}
	
	
	
	
	
}
