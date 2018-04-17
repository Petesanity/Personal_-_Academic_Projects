package Connect4;

public interface Connect4Interface {
	
		public void displayBoard();
		public void clearBoard();
		public void takeTurn();
		public void displayWinner();
		public boolean isFull();
		public boolean isEmpty();
		public boolean isWinner(String currPlayer);
		
	}


