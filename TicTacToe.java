import java.util.*; 
public class TicTacToe {
	
	static String[] board;
	static String turn;
	
	//method to check winner
	static String checkWinner() {
		for(int a=0; a<8; a++) {
			String line = null;
			switch(a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			
			// if winner is X
			if(line.equals("XXX")) {
				return "X";
			}
			
			//if winner is O
			else if(line.equals("OOO")) {
				return "O";
			}
		}
		// if game is draw
			for(int a=0; a<9; a++) {
					if(Arrays.asList(board).contains(String.valueOf(a+1))) {
						break;
					}
					else if(a==8) {
						return "draw";
					}
				}
			// to enter X or O at exact place
			System.out.println(turn + "'s turn , Enter a slot number to place "+turn+" in");
			return null;
	}
	
	// for printing board
	
	static void printBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| "+board[0]+" | "+board[1]+" | "+board[2]+" |");
		System.out.println("|-----------|");
		System.out.println("| "+board[3]+" | "+board[4]+" | "+board[5]+" |");
		System.out.println("|-----------|");
		System.out.println("| "+board[6]+" | "+board[7]+" | "+board[8]+" | ");
		System.out.println("|---|---|---|");
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		board = new String[9];
		turn = "X";
		String winner = null;
		
		for(int a=0; a<9; a++) {
			board[a] = String.valueOf(a+1);
		}
		System.out.println("Wellcome to Tic Tac Toe Game!");
		printBoard();
		
		System.out.println("X will play First. Enter a slot to place X in :");
		while(winner == null) {
			int numInput;
			
			// input must be in range of 1 to 9
			// so there is need of exception handling
			// if it break the range it shows "Invalid Input"
			try {
				numInput = sc.nextInt();
				if(!(numInput > 0 && numInput <= 9)) {
					System.out.println("Invalid Input!");
					continue;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Invalid input, Please re-enter slot...");
				continue;
			}
			if(board[numInput - 1].equals(String.valueOf(numInput))) {
				board[numInput - 1] = turn;
				
				if(turn.equals("X")) {
					turn = "O";
				}
				else {
					turn = "X";
				}
				printBoard();
				winner = checkWinner();
			}
			else {
				System.out.println("Slot is already taken, enter aother slot...");
			}
		}
		
		//if no one wins 
		if(winner.equalsIgnoreCase("draw")) {
			System.out.println("Game is Draw! Thanks for Playing!");
		}
		
		else {
			System.out.println("Congratulations! "+winner+"'s have won!");
		}
	
	}

}
