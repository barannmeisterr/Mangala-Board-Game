//-----------------------------------------------------
// Title: Player class
// Author: Arda Baran
// Description:  
//Pit Structure of Mangala game.Player can be a person or computer who plays Mangala game.
//Each player who plays Mangala game has turn, a castle and set of pits 
//------------------------------------------------------
public class Player {
    public boolean turn;
    public Pit playerCastle;
    public Pit[] playerPits;
    public Player(boolean turn, Pit playerCastle, Pit[] playerPits) {
        this.turn = turn;
        this.playerCastle = playerCastle;
        this.playerPits = playerPits;
    }
    public boolean isTurn() {
        return turn;
    }
    public void setTurn(boolean turn) {
        this.turn = turn;
    }
    public Pit getPlayerCastle() {
        return playerCastle;
    }
    public void setPlayerCastle(Pit playerCastle) {
        this.playerCastle = playerCastle;
    }
    public Pit[] getPlayerPits() {
        return playerPits;
    }
    public void setPlayerPits(Pit[] playerPits) {
        this.playerPits = playerPits;
    }
}