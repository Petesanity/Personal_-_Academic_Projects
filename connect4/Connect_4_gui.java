
package Connect4;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import Connect4.Player;
import Connect4.Connect4Interface;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Connect_4_gui extends JFrame {
	private JPanel mainPanel; //main JPanel
	private ConnectBoard jpBoard; //Connect4 Board
	private Score scoreBoard; //JPanel to keep score
	private Player player1; //player1
	private Player player2; //player2
	private Player currPlayer = player1; //current player
	public static final int row = 6; //row 
	public static final int col = 7; //col
	
	private int col1Counter = 5;
	private int col2Counter = 5;
	private int col3Counter = 5;
	private int col4Counter = 5;
	private int col5Counter = 5;
	private int col6Counter = 5;
	private int col7Counter = 5;

	Connect_4_gui(){	
		mainPanel = new JPanel();
		player1 = new Player("Goku", "p1");
		player2 = new Player("Jiren", "p2");
		currPlayer = player1;
		//instance of ConnectBoard class
		jpBoard = new ConnectBoard(); //createTTTBoard
		
		
		scoreBoard = new Score(); //instance of scoreboard class
		setLayout(new BorderLayout());
		setTitle("CONNECT 4");
		setSize(500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS)); //box layout to separate them in 2 halves
		mainPanel.add(jpBoard);
		mainPanel.add(scoreBoard);
		add(mainPanel);
		
	}
	public Player getPlayer1(){
		return player1;
	}
	public Player getPlayer2(){
		return player2;
	}
	public Player[] getPlayers(){
		return new Player [] {player1,player2};
	}

	public class Score extends JPanel{
		private JLabel lblChamp, lblLatestWinner, lblPlayer1Name, lblPlayer2Name,lblPlayer1NumWins, lblPlayer2NumWins,
		lblForChamp, lblForLatestWinner, lblPlaceHolder,lblForPlayerNames, lblForPlayerWins,
		lblForPlayer1Name, lblForPlayer2Name;
			
		private JPanel jpGenScoreInfo, jpPlayScoreInfo;
		public Score(){
			setLayout(new BorderLayout());
			jpGenScoreInfo = new JPanel(new GridLayout(2,2));
			jpGenScoreInfo.setBackground(Color.RED);
			jpGenScoreInfo.setBorder(BorderFactory.createRaisedBevelBorder());
			jpPlayScoreInfo = new JPanel(new GridLayout(3,3));
			jpPlayScoreInfo.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
			
			lblForChamp = new JLabel("Champion");
			lblChamp = new JLabel("---------");
			lblForLatestWinner = new JLabel("Latest Winner");
			lblLatestWinner = new JLabel("---------");
	
			lblPlaceHolder = new JLabel("          ");
			lblForPlayer1Name = new JLabel("Player1");
			lblForPlayer2Name = new JLabel("Player2");
	
			lblForPlayerNames = new JLabel("NAME");
			lblPlayer1Name = new JLabel(getPlayer1().getPlayerName());
			lblPlayer2Name = new JLabel(getPlayer2().getPlayerName());
	
			lblForPlayerWins = new JLabel("NUM WINS");
			lblPlayer1NumWins = new JLabel("---------");
			lblPlayer2NumWins = new JLabel("---------");
			JLabel [] genJLabels = {lblForChamp,lblChamp,lblForLatestWinner,lblLatestWinner};//put in 2x2 JPanel
			JLabel [] playerInfoJLabels = {  lblPlaceHolder, lblForPlayer1Name, lblForPlayer2Name,
													lblForPlayerNames, lblPlayer1Name, lblPlayer2Name,
													lblForPlayerWins,	lblPlayer1NumWins, lblPlayer2NumWins};//put in 3x3
	
			for(int i=0; i<genJLabels.length; i++){
				genJLabels[i].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
				jpGenScoreInfo.add(genJLabels[i]);
			}
			for(int i=0; i<playerInfoJLabels.length; i++){
				playerInfoJLabels[i].setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));
				jpPlayScoreInfo.add(playerInfoJLabels[i]);
			}
			//add the score label for champ and latest winner to JFrame
			add(jpGenScoreInfo, BorderLayout.NORTH);
			//add individual player information to JFrame
			add(jpPlayScoreInfo, BorderLayout.CENTER);
		}
		public JLabel getLblChamp() {
			return lblChamp;
		}
		public JLabel getLblLatestWinner() {
			return lblLatestWinner;
		}
		public JLabel getLblPlayer1Name(){
			return lblPlayer1Name;
		}
		public JLabel getLblPlayer2Name(){
			return lblPlayer2Name;
		}
		public JLabel getLblPlayer1NumWins() {
			return lblPlayer1NumWins;
		}
		public JLabel getLblPlayer2NumWins() {
			return lblPlayer2NumWins;
		}
		private void setLblChamp(String champ) {
			this.lblChamp.setText(champ);
		}
		private void setLblLatestWinner(String winnerName) {
			this.lblLatestWinner.setText(winnerName);
		}
		private void setLblPlayer1NumWins(int numWins) {
			this.lblPlayer1NumWins.setText(""+numWins);
		}
		private void setLblPlayer2NumWins(int numWins) {
			this.lblPlayer2NumWins.setText(""+numWins);
		}
	
	}
	private class ConnectBoard extends JPanel implements Connect4Interface, ActionListener{
		private JButton [][] board;
		
		public ConnectBoard(){
			setLayout(new GridLayout(6,7));
			displayBoard();
		}
			@Override
			public void displayBoard() { //method to display the board
				board = new JButton[6][7];
				for(int rows = 0; rows<= row -1;rows++){
					for(int cols = 0; cols<=col-1;cols++){
						board[rows][cols] = new JButton();
						board[rows][cols].setName(rows+ " "+cols);
						board[rows][cols].addActionListener(this);//listen
						board[rows][cols].setEnabled(true);//enable
						add(board[rows][cols]); //add to the JPanel
					}
				}
			}
		
			@Override
			public void clearBoard() { //method to clear the board
				for(int rows=0; rows<board.length; rows++){
					for(int cols=0; cols<board[rows].length;cols++){
						board[rows][cols].setText("");
						board[rows][cols].setEnabled(true);
					}	
				}
			}
		
			@Override
			public void takeTurn() { //method for player to take their turn
				if(currPlayer.equals(player1)){
					currPlayer = player2;
				}
				else{
					currPlayer = player1;
				}
				
			}	
		
			@Override
			public void displayWinner() { //method to show the winner
			
				currPlayer.addNumWins();//add the win
				int numWins = currPlayer.getNumWins();
				if(currPlayer.equals(player1)){
					scoreBoard.setLblPlayer1NumWins(numWins);
				}
				else{
					scoreBoard.setLblPlayer2NumWins(numWins);
				}
				
				
			}		
			
		
			@Override
			public boolean isFull() { //check if the board is Full
				for(int row=0; row<board.length; row++){
					for(int col=0; col<board[row].length;col++){
						String cellText = board[row][col].getText();
						//if(!(cellText.contains(player1.getPlayerSymbol())) && !(cellText.contains(player2.getPlayerSymbol()))   ){
						if(cellText.isEmpty()){
							return false;
						}
					}
				}
				return true;//visited all cells none are empty
			}
			
		
			@Override
			public boolean isEmpty() { //check if the board is empty
				return false;
						
			}
		
			@Override
			public boolean isWinner(String currPlayer) { //check if the current player is the winner
				//check rows
				for(int row=0; row<board.length; row++){
					int rowCount=0;//row match counter, resets on next row
					for(int col=0; col<board[row].length; col++){
						if(board[row][col].getText().trim().equalsIgnoreCase(currPlayer)){
							rowCount++;//increment counter
							if(rowCount == 4){
								return true;//found 4 in same row
							}
						}
						else{
							rowCount = 0;
						}
						
					}
				}
				//check columns
				for(int col=0; col<board.length; col++){
					int colCount=0;
					for(int row=0; row<6; row++){
						if(board[row][col].getText().trim().equalsIgnoreCase(currPlayer)){
							colCount++;
							if(colCount ==4){
								return true;//found 4 in same column
							}
						}
						else{
							colCount = 0;
						}
					}
				}
				//check diagonals
				//check main upward diagonal [5][0]
				int count1 = 0;
				
				for(int i = 5; i>=0;i--){
						if(board[i][5-i].getText().trim().equalsIgnoreCase(currPlayer)){
							count1++;
							if(count1==4){
								return true;
							}
						}
					
						else{
							count1 = 0;
						}
					
					
					
				}
				
				
				//check upward diagonal starting at [5][1]
				int count2 = 0;
				for(int i = 5;i>=0;i--){
						if(board[i][6-i].getText().trim().equalsIgnoreCase(currPlayer)){
							count2++;
							if(count2==4){
								return true;
							}
						}
						else{
							count2 = 0;
						}
					
				}
				
				//check upward diagonal starting at [5][2]
				int count3 = 0;
				for(int i = 5;i>=1;i--){
						if(board[i][7-i].getText().trim().equalsIgnoreCase(currPlayer)){
							count3++;
							if(count3==4){
								return true;
							}
						}
						else{
							count3 = 0 ;
						}
					
				}
				//check upward diagonal starting at [5][3]
				int count4 = 0;
				for(int i = 5;i>=2;i--){
						if(board[i][8-i].getText().trim().equalsIgnoreCase(currPlayer)){
							count4++;
							if(count4==4){
								return true;
							}
						}
						else{
							count4 = 0 ;
						}
					
				}
				//check upward diagonal starting at [4][0]
				int count5 =0;
				for(int i = 4;i>=0;i--){
						if(board[i][4-i].getText().trim().equalsIgnoreCase(currPlayer)){
							count5++;
							if(count5==4){
								return true;
							}
							
						}
						else{
							count5=0;
						}
					
				}
				//check upward diagonal starting at [3][0]
				int count6 =0;
				for(int i = 3;i>=0;i--){
						if(board[i][3-i].getText().trim().equalsIgnoreCase(currPlayer)){
							count6++;
							if(count6==4){
								return true;
							}
							
						}
						else{
							count6=0;
						}
					
				}
				
				//check downward diagonals
				//check downward diagonal starting at [2][0]
				int count7 = 0;
				for(int i = 0;i<=3;i++){
						if(board[2+i][i].getText().trim().equalsIgnoreCase(currPlayer)){
							count7++;
							if(count7==4){
								return true;
							}
						}
						else{
							count7 = 0;
						}
					
				}
				
				//check downward diagonal starting at [1][0]
				int count8 = 0;
				for(int i = 0;i<=4;i++){
						if(board[1+i][i].getText().trim().equalsIgnoreCase(currPlayer)){
							count8++;
							if(count8==4){
								return true;
							}
						}
						else{
							count8 = 0;
						}
					
				}
				// check downward diagonal starting at [0][0]
				int count9 = 0;
				for(int i = 0; i<=5;i++){
						if(board[i][i].getText().trim().equalsIgnoreCase(currPlayer)){
							count9++;
							if(count9==4){
								return true;
							}
						}
						else{
							count9=0;
						}
					
				}
				//check downward diagonal starting at [0][1]
				int count10 = 0;
				for(int i = 0; i<=5;i++){
						if(board[i][i+1].getText().trim().equalsIgnoreCase(currPlayer)){
							count10++;
							if(count10==4){
								return true;
							}
						}
						else{
							count10=0;
						}
					
				}
				//check downward diagonal starting at [0][2]
				int count11 = 0;
				for(int i = 0; i<=4;i++){
						if(board[i][i+2].getText().trim().equalsIgnoreCase(currPlayer)){
							count11++;
							if(count11==4){
								return true;
							}
						}
						else{
							count11=0;
						}
					
				}
				//check downward diagonal starting at [0][3]
				int count12 = 0;
				for(int i = 0; i<=3;i++){
						if(board[i][i+3].getText().trim().equalsIgnoreCase(currPlayer)){
							count12++;
							if(count12==4){
								return true;
							}
						}
						else{
							count12=0;
						}
					
				}
				
				
				return false;
			}
			
			private void promptPlayAgain() {
				
				//JOptionPane....
				int yesNo = JOptionPane.showConfirmDialog(null, "Play Again?","Yes or No", JOptionPane.YES_NO_OPTION);
				if(yesNo == JOptionPane.YES_OPTION ){
					//clear board if player wants to play again
					clearBoard();
					//reset the column counters so the drop doesn't get messed up 
					col1Counter=5;
					col2Counter=5;
					col3Counter=5;
					col4Counter=5;
					col5Counter=5;
					col6Counter=5;
					col7Counter=5;


				}
				else{
					System.exit(EXIT_ON_CLOSE);
				}
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e){
				
				JButton btnClicked = (JButton) e.getSource();//find out what button/cell was clicked
				
				
				//col 0
				String btn1 = btnClicked.getName(); //creating a string representation of the button clicked
				char btn1Row = btn1.charAt(0); // 1st index of string
				char btn1Col = btn1.charAt(2); //index 2 because there are 3 location coordinates and indices are from 0-2
				int x = Character.getNumericValue(btn1Row); //char to int
				int y = Character.getNumericValue(btn1Col); //char to int	
				
				if (x == 0 && y==0 && col1Counter>=0 ){ //row 0 col 0
					board[col1Counter][y].setText(currPlayer.getPlayerSymbol()); //set the text of button from position 5,0
					col1Counter--;
					
				}
				
				
					
				//col 1
				String btn2 = btnClicked.getName(); //creating a string representation of the button clicked
				char btn2Row = btn2.charAt(0);// 1st index of string
				char btn2Col = btn2.charAt(2);//index 2 because there are 3 location coordinates and indices are from 0-2
				
				int x1 = Character.getNumericValue(btn2Row); //char to int
				int y1 = Character.getNumericValue(btn2Col); //char to int

				if(x1 == 0 && y1 ==1 && col2Counter>=0 ){ //row 0 col 1
					board[col2Counter][y1].setText(currPlayer.getPlayerSymbol()); //pos 5,1
					col2Counter--;
				}
				//col 2
				String btn3 = btnClicked.getName(); //creating a string representation of the button clicked
				char btn3Row = btn3.charAt(0);// 1st index of string
				char btn3Col = btn2.charAt(2);//index 2 because there are 3 location coordinates and indices are from 0-2
				
				int x2 = Character.getNumericValue(btn3Row);//char to int
				int y2 = Character.getNumericValue(btn3Col); //char to int
				if(x2==0 && y2==2 && col3Counter>=0){ //row 0  col 2
					board[col3Counter][y2].setText(currPlayer.getPlayerSymbol()); //pos 5,2
					col3Counter--;
				}
				//col 3
				String btn4 = btnClicked.getName();//creating a string representation of the button clicked
				char btn4Row = btn4.charAt(0);// 1st index of string
				char btn4Col = btn4.charAt(2);//index 2 because there are 3 location coordinates and indices are from 0-2
				
				int x3 = Character.getNumericValue(btn4Row); //char to int
				int y3 = Character.getNumericValue(btn4Col); //char to int
				if(x3==0 && y3==3 && col4Counter>=0){  //row 0 col 3
					board[col4Counter][y3].setText(currPlayer.getPlayerSymbol()); //pos 5,3
					col4Counter--;
				}
				//col 4
				String btn5 = btnClicked.getName(); //creating a string representation of the button clicked
				char btn5Row = btn5.charAt(0);// 1st index of string
				char btn5Col = btn5.charAt(2);//index 2 because there are 3 location coordinates and indices are from 0-2
				
				int x4 = Character.getNumericValue(btn5Row); //char to int
				int y4 = Character.getNumericValue(btn5Col); //char to int
				if(x4==0 && y4==4 && col5Counter>=0){ //row 0 col 4
					board[col5Counter][y4].setText(currPlayer.getPlayerSymbol()); //pos 5,4
					col5Counter--;
				}
				//col 5
				String btn6 = btnClicked.getName();//creating a string representation of the button clicked
				char btn6Row = btn6.charAt(0);// 1st index of string
				char btn6Col =btn6.charAt(2);//index 2 because there are 3 location coordinates and indices are from 0-2
				
				int x5 = Character.getNumericValue(btn6Row); //char to int
				int y5 = Character.getNumericValue(btn6Col); //char to int
				if(x5==0 && y5==5 && col6Counter>=0){ //row 0 col 5
					board[col6Counter][y5].setText(currPlayer.getPlayerSymbol()); //pos 5,5
					col6Counter--;
					
				}
				//col 6
				String btn7 =  btnClicked.getName();//creating a string representation of the button clicked
				char btn7Row = btn7.charAt(0);// 1st index of string
				char btn7Col = btn7.charAt(2);//index 2 because there are 3 location coordinates and indices are from 0-2
				
				int x6 = Character.getNumericValue(btn7Row); //char to int
				int y6 = Character.getNumericValue(btn7Col); //char to int
				if(x6==0 && y6==6 && col7Counter>=0){ //row 0 col6
					board[col7Counter][y6].setText(currPlayer.getPlayerSymbol()); //pos 5,6
					col7Counter--;
				}		
					
				
				if(isWinner(currPlayer.getPlayerSymbol())){   //check for winner OR isFull   -->
					JOptionPane.showMessageDialog(null, "WINNER "+currPlayer.getPlayerName());
					displayWinner();//					display winner
					
					scoreBoard.setLblLatestWinner(currPlayer.getPlayerName());//set the latest winner
					
					//calculate the champion depending on who has more wins
					if(player1.getNumWins()> player2.getNumWins()){ 
						scoreBoard.setLblChamp(currPlayer.getPlayerName());
					}
					else if(player2.getNumGames()>player1.getNumGames()){
						scoreBoard.setLblChamp(currPlayer.getPlayerName());
					}
					else{
						scoreBoard.setLblChamp("---------");
					}
					promptPlayAgain();//playAgain
					
				}
				if(isFull()){
					JOptionPane.showMessageDialog(null, "DRAW");
					promptPlayAgain();
				}
				takeTurn();			//update current player and the display...take a turn
				
			}
	}
}
	

