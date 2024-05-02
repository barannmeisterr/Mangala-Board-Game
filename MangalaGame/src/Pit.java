//-----------------------------------------------------
// Title: Pit class
// Author: Arda Baran
// Description:  
//Pit Structure of Mangala game.All Pits have index for implementation in directed graph data structure and stones.
//------------------------------------------------------
public class Pit {
int numOfStones,pitIdx;
public Pit(int pitIdx) {
	this.pitIdx=pitIdx;
	this.numOfStones=0;
}
public int getNumOfStones() {
	return numOfStones;
}
public void setNumOfStones(int numOfStones) {
	this.numOfStones = numOfStones;
}
public int getPitIdx() {
	return pitIdx;
}
public void setPitIdx(int pitIdx) {
	this.pitIdx = pitIdx;
}
}
