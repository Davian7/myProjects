public class Player implements Comparable<Player>{
	private String playerSymbol;
	private String playerName;
	private int numGames;
	private int numWins;
	private int numLosses;

	public Player(){
		playerSymbol = " * ";
		playerName = "PlayDoe";
		numGames = 0;
		numWins = 0;
		numLosses = 0;
	}
	public Player(String symbol){
		playerSymbol = symbol;
		playerName = "Player Doe";
		numGames = 0;
		numWins = 0;
		numLosses = 0;
	}
	public Player(String name, String symbol){
		playerSymbol = symbol;
		playerName = name;
		numGames = 0;
		numWins = 0;
		numLosses = 0;
	}
	public void addNumWins(){
		numWins++;
		numGames++;
	}
	public void addNumLosses(){
		numLosses++;
			numGames++;
	}
		//no setter for numWins, numLosses, numGames
		//good public methods:  getPercentageOfWins,  getPercentageOfLosses
	public String getPlayerSymbol() {
		return playerSymbol;
	}
	public String getPlayerName() {
		return playerName;
	}
	public int getNumGames() { 
		return numGames;
	}
	public int getNumWins() { 
		return numWins;
	}
	public int getNumLosses() {
		return numLosses;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public void setPlayerSymbol(String playerSymbol) {
		this.playerSymbol = playerSymbol;
	}
	public boolean equals(Object o){
		if(o instanceof Player){
			Player otherPlayer = (Player)o;
			if(this.playerName.equalsIgnoreCase(otherPlayer.playerName)){
				if(this.playerSymbol.equalsIgnoreCase(otherPlayer.playerSymbol)){
					if(this.numGames == otherPlayer.numGames){
						if(this.numWins == otherPlayer.numWins){
							if(this.numLosses == otherPlayer.numLosses){
									return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Player [ playerName="
				+ playerName + ", playerSymbol=" + playerSymbol + ","
				+ " numGames=" + numGames + ", numWins="
				+ numWins + ", numLosses=" + numLosses + "]";
	}
		
	@Override
	public int compareTo(Player otherP) {//compare using numWins
		if(this.numWins < otherP.numWins)
			return -1;
		
		else if(this.numWins > otherP.numWins)
			return 1;
		
		else	//not less or greater must be equal
			return 0;
	}
}




