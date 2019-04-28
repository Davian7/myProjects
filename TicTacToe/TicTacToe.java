import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import TicTacToe.GameBoardInterface;
public class TicTacToe extends JFrame{
	public interface GameBoardInterface{

	}

	private JPanel jpMain;
	private TicTacToeBoard jpBoard;//a JPanel containing the board made of buttons
	private ScoreBoard scoreBoard;//a JPanel showing the score made of labels
//	private String currPlayer = PLAYER_X_SYMBOL;
//	public static final String PLAYER_X_SYMBOL = "X";
//	public static final String PLAYER_O_SYMBOL = "O";
	private Player currPlayer;
	private Player player1;
	private Player player2;
	public TicTacToe(){
			
	player1 = new Player("Jaheim", "Jaheim");
	player2 = new Player("Reno", "Reno");
	currPlayer = player1;
	setLayout(new BorderLayout());
	//going to add my content here
	///here we build our gui
	//JPanels... initialize
	jpBoard = new TicTacToeBoard(); //createTTTBoard
	add(jpBoard, BorderLayout.CENTER);//add JPanels to JFrame
			
	scoreBoard = new ScoreBoard();
	add(scoreBoard, BorderLayout.NORTH);
	setSize(500,500);
	setVisible(true);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	
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
		
	private class ScoreBoard extends JPanel{
		private JLabel  lblChamp, lblLatestWinner, lblPlayer1Name, lblPlayer2Name,lblPlayer1NumWins, lblPlayer2NumWins,
						lblForChamp, lblForLatestWinner, lblPlaceHolder,lblForPlayerNames, lblForPlayerWins,
						lblForPlayer1Name, lblForPlayer2Name, lblForPlayer1NumWins, lblForPlayer2NumWins;
			/*private JLabel [] genJLabels = {lblForChamp,lblChamp,lblForLatestWinner,lblLatestWinner};//put in 2x2 JPanel
			private JLabel [] playerInfoJLabels  = {  lblPlaceHolder, lblForPlayer1Name, lblForPlayer2Name,
													lblForPlayerNames, lblPlayer1Name, lblPlayer2Name,
													lblForPlayerWins,	lblPlayer1NumWins, lblPlayer2NumWins};//put in 3x3
			*/
		private JPanel jpGenScoreInfo, jpPlayScoreInfo;
		public ScoreBoard(){
			setLayout(new BorderLayout());
			jpGenScoreInfo = new JPanel(new GridLayout(2,2));
			jpGenScoreInfo.setBackground(Color.YELLOW);
			jpGenScoreInfo.setBorder(BorderFactory.createRaisedBevelBorder());
			jpPlayScoreInfo = new JPanel(new GridLayout(3,3));
			jpPlayScoreInfo.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
				
			lblForChamp = new JLabel("Champion");
			lblChamp = new JLabel("---------");
			lblForLatestWinner = new JLabel("Latest Winner");
			lblLatestWinner = new JLabel("---------");

			lblPlaceHolder = new JLabel("          ");
			lblForPlayer1Name = new JLabel("Player 1");
			lblForPlayer2Name = new JLabel("Player 2");

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
				
			add(jpGenScoreInfo, BorderLayout.NORTH);
				
			add(jpPlayScoreInfo, BorderLayout.CENTER);
			
		}
			public JLabel getLblChamp() {
				return lblChamp;
			}
			
			public JLabel getLblLatestWinner() {
				return lblLatestWinner;
			}	
			
			public JLabel getLblPlayer1NumWins() {
				return lblPlayer1NumWins;
			}
			public JLabel getLblPlayer2NumWins() {
				return lblPlayer2NumWins;
			}
			
			private void setLblChamp(JLabel lblChamp) {
				this.lblChamp = lblChamp;
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
	private class TicTacToeBoard extends JPanel implements GameBoardInterface, ActionListener{
		private JButton [][] board;
			
		public TicTacToeBoard(){
			setLayout(new GridLayout(3,3));
			displayBoard();
		}
			
		public void populateBoard() {
			//use this method when creating a console based tic tac toe game
			board = new JButton[3][3];//initialize 2D array to 3x3
			for(int row=0; row<board.length; row++){
				for(int col=0; col<board[row].length;col++){
					board[row][col] = new JButton();
				}
			}
		}
		
		public void displayBoard() {//use this method when creating a GUI based
			board = new JButton[3][3];//initialize 2D array to 3x3
			for(int row=0; row<board.length; row++){
				for(int col=0; col<board[row].length;col++){
					board[row][col] = new JButton();
					board[row][col].addActionListener(this);//listen
					board[row][col].setEnabled(true);//enable
					add(board[row][col]); //add to the JPanel
					}
				}
		}
		
		public void clearBoard() {
			for(int row=0; row<board.length; row++){
				for(int col=0; col<board[row].length;col++){
					board[row][col].setText("");
					board[row][col].setEnabled(true);
				}
			}
		}
		
		public void takeTurn() {
			if(currPlayer.equals(player1)){
				currPlayer = player2;
			}
			else{
				currPlayer = player1;
				}
		}
		
		public void displayWinner() {
			// TODO Auto-generated method stub
			//update the JLabel or display using a JOptionPane
			currPlayer.addNumWins();//add the win
			int numWins = currPlayer.getNumWins();
			if(currPlayer.equals(player1)){
				scoreBoard.setLblPlayer1NumWins(numWins);
			}else{
				scoreBoard.setLblPlayer2NumWins(numWins);
				 }
		}
		
		public boolean isFull() {
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
		
		public boolean isEmpty() {
			//reverse logic of isFull()
			return false;
		}
		
		public boolean isWinner(String cp){
			//check rows
			for(int row=0; row<board.length; row++){
				int rowCount=0;//row match counter, resets on next row
				for(int col=0; col<board[row].length; col++){
					if(board[row][col].getText().trim().equalsIgnoreCase(cp)){
						rowCount++;//increment counter
						if(rowCount == 3){
							return true;//found 3 in same row
						}
					}
				}
			}
				//check columns
			for(int col=0; col<3; col++){
				int colCount=0;
				for(int row=0; row<3; row++){
					if(board[row][col].getText().trim().equalsIgnoreCase(cp)){
						colCount++;
						if(colCount ==3){
							return true;//found 3 in same column
						}
					}
				}
			}
				//check main diagonal [0][0],[1][1],[2][2]
			int diagCount=0;
			for(int i=0; i<board.length; i++){
				if(board[i][i].getText().trim().equalsIgnoreCase(cp)){
					diagCount++;
					if(diagCount ==3){
						return true;//found 3 same across main diagonal
					}
				}	
			}
				//check secondary diagonal
			int diag2Count=0;
			int row=board.length-1;
			int col = 0;
			while(row >=0 && col< board.length){
				if(board[row][col].getText().trim().equalsIgnoreCase(cp)){
					diag2Count++;
					if(diag2Count ==3){
						return true;//found 3 same across secondary diagonal
					}
				}
				row--;
				col++;
			}
			return false;
		}
		
		private void promptPlayAgain() {
			// TODO Auto-generated method stub
			//JOptionPane....
			int yesNo = JOptionPane.showConfirmDialog(null, "Play Again?","Yes or No", JOptionPane.YES_NO_OPTION);
			if(yesNo == JOptionPane.YES_OPTION ){
				//clear board
				clearBoard();
				//make sure the player is displayed...
			}
			else{
				System.exit(EXIT_ON_CLOSE);
			}
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btnClicked = (JButton) e.getSource();//find out what button/cell was clicked
			btnClicked.setText(currPlayer.getPlayerSymbol());//setText on button
			btnClicked.setEnabled(false);//on the button setEnabled(false)
				
			if(isWinner(currPlayer.getPlayerSymbol())){   //check for winner OR isFull   -->
				JOptionPane.showMessageDialog(null, "WINNER "+currPlayer.getPlayerName());
				displayWinner();
				//setLblLatestWinner(currPlayer.getPlayerName());//					display winner
				promptPlayAgain();//					playAgain???
			}
			if(isFull()){
				JOptionPane.showMessageDialog(null, "DRAW");
				promptPlayAgain();
			}
			
			takeTurn();			//update current player and the display...take a turn
				
		}

		
	}
		
	//public class SHOW_GAME {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				TicTacToe gui_game = new TicTacToe();
						
			}
		});
	}
}


