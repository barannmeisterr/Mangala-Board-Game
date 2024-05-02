//-----------------------------------------------------
// Title: MangalaDirectedGraphImplementation class
// Author: Arda Baran
// Description: Mangala is a traditional board strategy game and played with two person . The aim of the game is to capture 
//as many stones as possible which means if player makes its own all pits zero ,player wins.
/*
What You Need :

12 Pits(Holes) . 6 Pits For Player 1 and 6 Pits For Player 2
2 Castle . One of the Castle for player 1 the other one is for player 2.
48 stones. 24 for player1 and 24 for player 2. Each 12 Pits contain 4 stones at the beggining. Player 1 castle and Player 2 
castle does not contain stone at the beggining.

Why Directed Graph Implementation Is Used ?

Because all pits are connected together and the stones are moving anti-clockwise on edges which means there is a direction.
The Connections and legal moves in this game are ;

Directed Edges :
Player 2 Castle connected with Player 1's first pit
Player 1' first pit connected with Player1's second pit. 
Player 1' second pit connected with Player1's third pit. 
Player 1' third pit connected with Player1's fourth pit. 
Player 1' fourth pit connected with Player1's fifth pit. 
Player 1' fifth pit connected with Player1's sixth pit. 
Player 1' sixth pit connected with Player1 Castle. 
Player 1 Castle connected with Player 2's first pit
Player 2' first pit connected with Player2's second pit. 
Player 2' second pit connected with Player2's third pit. 
Player 2' third pit connected with Player2's fourth pit. 
Player 2' fourth pit connected with Player2's fifth pit. 
Player 2' fifth pit connected with Player2's sixth pit. 
Player 2' sixth pit connected with Player2 Castle. 

Indexes Of Pits:

Player 2 Castle = 0
Player 1'first pit=1 
Player 1'second pit=2  
Player 1'third pit=3  
Player 1'fourth pit=4 
Player 1'fifth pit=5  
Player 1'sixth pit=6  
Player 1 Castle = 7
Player 2'first pit=8 
Player 2'second pit=9 
Player 2'third pit=10  
Player 2'fourth pit=11 
Player 2'fifth pit=12  
Player 2'sixth pit=13 

I implemented Pit structure as Vertex/Node of Directed Graph  then I added edges between connected pits.
I implemented adjacency matrix as two dimensional array.
I used dfs algorithm for distributing stones to pits.

How To Play:
Players take turns moving the stones from one of their pits and placing each one of the stone in a pit moving anti-clockwise.
The game ends when one of the player has no more stones in their six circles. The remaining stones go to the player’s
Store.Other player's lose.
 

Rules Of Mancala:

Rule 1 : 
Player  selects a pit then distribute all stones in the selected pit ,for example if player selects 4.th pit and there is 4 
stone in the 4.pit , player distrubute stones to one by one 4th pit , 5th pit ,6th pit and 7th pit which is its castle.
the stones in pit 4 is 1 ,pit 5 is 5 ,pit 6 is 6 and pit 7 is 1.Pit 7 is castle.

Special Cases for rule 1:
1)Player  selects a pit and if there is only one stone in the selected pit,distribute that stone to the next pit.
  Such as if player selects pit 4 and there is only one stone in pit 4 , player distrubutes the stone to pit 5.
  The stones in pit 4 is 0 , pit 5 is = (the stones in pit 5 + the stone that came from pit 4)


Rule 2:
While player distributing its stones and the number of stones in players castle is incremented , then player plays again.
But this play turn limited with 2.A player cannot play contionusly more than 2.

Rule 3 :
Player  selects a pit then distribute all stones in the selected pit ,for example if player selects 4.th pit and there is only
1 stone in 4th pit , player only distribute the stone to 5th pit. 

Rule 4 :
After Player  selects a pit then distribute all stones in the selected pit , if player makes one of the pit of opponent 
even , player gets all stones from that pit. 

Rule 5:

After Player  selects a pit then distribute all stones in the selected pit , if the last stone that player distribute goes 
to a empty pit that must  belong to player who distrubute stones , player captures all the stones on the opposite pit
if number of stones in opposite pit is not 0.


 | <------<----------<-------<--------<---------<---------<----------<--------<-------<---^
 v  +----------+----------+---------+---------+---------+---------+---------+---------+   |  
 |  |Player 1  | Player 1 |Player 1 | Player1 | Player 1| Player 1|Player 1 | Player 2|   ^  
 v  |Castle    |    6.pit |   5.pit | 4.pit   |  3.pit  |  2.pit  | 1.Pit   | Castle  |   |   
 |  |(Mancala) |----------+---------+---------+---------+---------+---------|(Mancala)|   ^  
 v  |          |Player 2  |Player 2 | Player 2| Player 2| Player 2| Player 2|         |   |  
 |  |          |  1.pit   |  2.pit  |   3.pit |  4.pit  |   5.pit |  6.pit  |         |   ^  
 v  +----------+----------+---------+---------+---------+---------+---------+---------+   |   
 ---->------->------>----->------>------->------>----->------>------->------>----->------>                                                                                         



Initial Board:

+----------+----------+---------+---------+---------+---------+---------+---------+
|          |     4    |     4   |      4  |     4   |     4   |     4   |         |
|     0    |----------+---------+---------+---------+---------+---------|    0    |
|          |     4    |     4   |      4  |     4   |     4   |     4   |         |
+----------+----------+---------+---------+---------+---------+---------+---------+
*/
//-----------------------------------------------------
public class MangalaDirectedGraphImplementation {
public Pit[] pits ;
int numberOfPits;
int numberOfEdges;
int[][] matrix;//adj matrix.I implemented it as 2 dimensional array.
public MangalaDirectedGraphImplementation(int numberOfPits) {
	this.numberOfPits=numberOfPits;
this.matrix=new int[numberOfPits][numberOfPits];
this.pits=new Pit[numberOfPits];
for(int i = 0 ; i<pits.length;i++) {
	this.pits[i]=new Pit(i);
}
//connections are added to the directed graph
addEdge(pits[0],pits[1]);
addEdge(pits[1],pits[2]);
addEdge(pits[2],pits[3]);
addEdge(pits[3],pits[4]);
addEdge(pits[4],pits[5]);
addEdge(pits[5],pits[6]);
addEdge(pits[6],pits[7]);
addEdge(pits[7],pits[8]);
addEdge(pits[8],pits[9]);
addEdge(pits[9],pits[10]);
addEdge(pits[10],pits[11]);
addEdge(pits[11],pits[12]);
addEdge(pits[12],pits[13]);
addEdge(pits[13],pits[0]);
//the number of stones for all pits except castles are arranged to 4 at the beginning
for(int i=0;i<pits.length;i++) {
	if(i!=0 && i!=7) {
		pits[i].setNumOfStones(4);
	}
}
}
public boolean isPitEmpty(Pit pit) {
	/*---------------------------------------------------
	Summary:returns true if parameter pit is empty	
		    for distributing stones.		
	----------------------------------------------------*/	
	if(pit.getNumOfStones()==0) {
		return true;		
	}
return false;
}
public Pit makePitEmpty(Pit pit) {
	if(pit==null) {
		return null;
	}
pit.setNumOfStones(0);
return pit;
}
public boolean isNumberOfStonesInPitEven(Pit pit) {
	if(pit.getNumOfStones()!=0 && pit.getNumOfStones()%2==0) {
		return true;
	}
return false;
}
public Pit incrementNumberOfStonesInPit(Pit pit) {
/*---------------------------------------------------
Summary:Increments the number of stones in a pit by one.Used for distributing stones.
----------------------------------------------------*/
int current=pit.getNumOfStones();
current=current+1;
pit.setNumOfStones(current);
return pit;
}
public Pit[] getPits() {
	return pits;
}
public void setPits(Pit[] pit) {
	this.pits = pit;
}
public int getNumberOfPits() {
	return numberOfPits;
}
public void setNumberOfPits(int numberOfPits) {
	this.numberOfPits = numberOfPits;
}
public int getNumberOfEdges() {
	return numberOfEdges;
}
public void setNumberOfEdges(int numberOfEdges) {
	this.numberOfEdges = numberOfEdges;
}
public int[][] getMatrix() {
	return matrix;
}
public void setMatrix(int[][] matrix) {
	this.matrix = matrix;
}
public void addEdge(Pit pit1,Pit pit2) {
//-----------------------------------------------
//Summary:adds connection from pit 1 to pit 2.	
//-----------------------------------------------	
	if(pit1==null || pit2==null) {
		return;
	}
matrix[pit1.getPitIdx()][pit2.getPitIdx()]=1;

}
public void printMangala() {
//prints the game board.
int[] arr = new int[getNumberOfPits()];
for(int i =0;i<arr.length;i++) {
	arr[i]=this.pits[i].getNumOfStones();
}	
if(arr[7]>9&&arr[0]<10) {
System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");	
System.out.println("|           |     "+arr[6]+"    |     "+arr[5]+"   |      "+arr[4]+"  |     "+arr[3]+"   |     "+arr[2]+"   |     "+arr[1]+"   |"+"         |");
System.out.println("|     "+arr[7]+"    |----------+---------+---------+---------+---------+---------|    "+arr[0]+"    |");
System.out.println("|           |     "+arr[8]+"    |     "+arr[9]+"   |      "+arr[10]+"  |     "+arr[11]+"   |     "+arr[12]+"   |     "+arr[13]+"   |"+"         |");
System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");	
}else if(arr[0]>9 && arr[7]<10) {
	System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");	
	System.out.println("|           |     "+arr[6]+"    |     "+arr[5]+"   |      "+arr[4]+"  |     "+arr[3]+"   |     "+arr[2]+"   |     "+arr[1]+"   |"+"         |");
	System.out.println("|     "+arr[7]+"     |----------+---------+---------+---------+---------+---------|    "+arr[0]+"   |");
	System.out.println("|           |     "+arr[8]+"    |     "+arr[9]+"   |      "+arr[10]+"  |     "+arr[11]+"   |     "+arr[12]+"   |     "+arr[13]+"   |"+"         |");
	System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");		
}else if(arr[7]>9&&arr[0]>9) {
	System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");	
	System.out.println("|           |     "+arr[6]+"    |     "+arr[5]+"   |      "+arr[4]+"  |     "+arr[3]+"   |     "+arr[2]+"   |     "+arr[1]+"   |"+"         |");
	System.out.println("|     "+arr[7]+"    |----------+---------+---------+---------+---------+---------|    "+arr[0]+"   |   ");
	System.out.println("|           |     "+arr[8]+"    |     "+arr[9]+"   |      "+arr[10]+"  |     "+arr[11]+"   |     "+arr[12]+"   |     "+arr[13]+"   |"+"         |");
	System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");		
}
else {
System.out.println("+----------+----------+---------+---------+---------+---------+---------+---------+");	
System.out.println("|          |     "+arr[6]+"    |     "+arr[5]+"   |      "+arr[4]+"  |     "+arr[3]+"   |     "+arr[2]+"   |     "+arr[1]+"   |"+"         |");
System.out.println("|     "+arr[7]+"    |----------+---------+---------+---------+---------+---------|    "+arr[0]+"    |");
System.out.println("|          |     "+arr[8]+"    |     "+arr[9]+"   |      "+arr[10]+"  |     "+arr[11]+"   |     "+arr[12]+"   |     "+arr[13]+"   |"+"         |");
System.out.println("+----------+----------+---------+---------+---------+---------+---------+---------+");			
}
}
public void printBoard() {
//prints all pits with their indexes and stones that they hold.
	
	for (Pit pit : this.pits) {
    if(pit==null) {
    	return;
    }
		System.out.println("Pit " + pit.getPitIdx() + ": Stones = " + pit.getNumOfStones());
    }

}
public void printAdjacencyMatrix(int[][] matrix) {
    // Loop through all rows
    for (int i = 0; i < matrix.length; i++) {
       System.out.print("Pit "+i+": ");
    	// Loop through all elements of current row
        for (int j = 0; j < matrix[i].length; j++) {
            System.out.print(matrix[i][j] + " ");
        }
        System.out.println(); // Move to the next line after printing each row
    }
}
public Pit findNeighborPit(Pit pit) {
//--------------------------------------	
//Summary:Find Neighbor of Parameter Pit	
//--------------------------------------
	for(Pit p:this.pits) {
	if(matrix[pit.getPitIdx()][p.getPitIdx()]==1 ) {
		return p;
	}
}
return null;
}
public Pit FindAncestorPit(Pit pit) {
	//--------------------------------------	
	//Summary:Find Ancestor of Pit	
	//--------------------------------------	
	for(Pit p:this.pits) {
	if(matrix[p.getPitIdx()][pit.getPitIdx()]==1 ) {
		return p;
	}
}
return null;
}
public Pit[] dfsAlgorithmForStoneDistribution(int playerChosenPit) {
//------------------------------------------------------------------
//Summary: player selects a pit and the selected pit has stones. player must distrubute all stones one by one.  	
//So that A stack structure is created with the number of stones in the selected pit which can be considered as
//the capacity of the stack.Then add all connections to the stack until stack capacity is full then return the 
//all added pits. return type is pit array.
//-------------------------------------------------------------------	
	Pit pit = new Pit(playerChosenPit);       
	int indexOfThePitThatPlayerChosen = pit.getPitIdx();
	int numberOfStonesPlayerChosenPit=pits[indexOfThePitThatPlayerChosen].getNumOfStones();
    Stack stack = new Stack(numberOfStonesPlayerChosenPit);
//if there is more than one stones in the selected pit ,add all connected pits to the stack 
// and return the array of stack which is type of Pit.  
    if(numberOfStonesPlayerChosenPit!=0 && numberOfStonesPlayerChosenPit!=1) {
    stack.addPitToStack(pit);        
    while(!stack.isFull()) {
    	   if(findNeighborPit(pit)!=null) {
    		   pit=findNeighborPit(pit);    	     
    		   stack.addPitToStack(pits[pit.getPitIdx()]);    	     
    	   }else {
    		   pit=stack.getTop();
    	   }           
       }
       return stack.getBag();       
 }else {
//if there is only one stone in the selected pit , return the selected pit's neighbor.only neighbor is added to stack.
//selected pit is not added to stack.	 		 
 if(pits[indexOfThePitThatPlayerChosen].getPitIdx()==13) {//hidden case , if the selected pit is 13 and there is only one 
	 stack.addPitToStack(pits[0]);                        //stone , we cannot go to pit 0 directly with indexes so we must 
 return stack.getBag();                                   //add only player 2 castle to the stack.
 }	 
	 stack.addPitToStack(pits[indexOfThePitThatPlayerChosen+1]);
return stack.getBag();
 }
}
}
