import java.util.Scanner;
//-----------------------------------------------------
//Title: MangalaGame class
//Author: Arda Baran
//Description: all required fundamental elements of Mangala game are combined in this class whose are 
//a directed graph data structure,two players and their pits and castles,Pit array etc.
//Rules of Mangala Game and all possible scenarios are applied in this class.
//Rule 1 ,Rule 2 , Rule 3 ,Rule 4 and Rule 5 are applied.
//The Winner of the game is determined.
//Directed Graph DFS algorithm is applied.
//------------------------------------------------------
public class MangalaGame {
Player player1,player2;
MangalaDirectedGraphImplementation game;
Pit[] player1Pits,player2Pits;
Pit[]allPits;
Pit player1Castle,player2Castle;
boolean player1Turn,player2Turn;
Scanner sc ;
public MangalaGame(MangalaDirectedGraphImplementation game) {
	this.game=game;
	this.allPits=game.getPits();
	this.player1Pits= new Pit[] {allPits[1],allPits[2],allPits[3],allPits[4],allPits[5],allPits[6]};	
    this.player2Pits=new Pit[] {allPits[8],allPits[9],allPits[10],allPits[11],allPits[12],allPits[13]};    
    this.player1Castle=allPits[7];  
     this.player2Castle=allPits[0];
     this.player1Turn=false;
     this.player2Turn=false;
this.player1=new Player(player1Turn,player1Castle,player1Pits);
this.player2=new Player(player2Turn,player2Castle,player2Pits);
sc=new Scanner(System.in);
}
public Player getPlayer1() {
	return player1;
}
public void setPlayer1(Player player1) {
	this.player1 = player1;
}
public Player getPlayer2() {
	return player2;
}
public void setPlayer2(Player player2) {
	this.player2 = player2;
}
public MangalaDirectedGraphImplementation getGame() {
	return game;
}
public void setGame(MangalaDirectedGraphImplementation game) {
	this.game = game;
}
public Pit[] getPlayer1Pits() {
	return player1Pits;
}
public void setPlayer1Pits(Pit[] player1Pits) {
	this.player1Pits = player1Pits;
}
public Pit[] getPlayer2Pits() {
	return player2Pits;
}
public void setPlayer2Pits(Pit[] player2Pits) {
	this.player2Pits = player2Pits;
}
public Pit[] getAllPits() {
	return allPits;
}
public void setAllPits(Pit[] allPits) {
	this.allPits = allPits;
}
public Pit getPlayer1Castle() {
	return player1Castle;
}
public void setPlayer1Castle(Pit player1Castle) {
	this.player1Castle = player1Castle;
}
public Pit getPlayer2Castle() {
	return player2Castle;
}
public void setPlayer2Castle(Pit player2Castle) {
	this.player2Castle = player2Castle;
}
public boolean isPlayer1Turn() {
	return player1Turn;
}
public void setPlayer1Turn(boolean player1Turn) {
	this.player1Turn = player1Turn;
}
public boolean isPlayer2Turn() {
	return player2Turn;
}
public void setPlayer2Turn(boolean player2Turn) {
	this.player2Turn = player2Turn;
}
public boolean isThereAWinner(){
//----------------------------------
//Summary:if one of the players wins the game returns true,else returns false
//-----------------------------------	
Pit[] player1Pits=getPlayer1Pits();	
Pit[] player2Pits=getPlayer2Pits();	
if((player1Pits[0].getNumOfStones()==0 && player1Pits[1].getNumOfStones()==0 && player1Pits[2].getNumOfStones()==0 && player1Pits[3].getNumOfStones()==0 && player1Pits[4].getNumOfStones()==0 && player1Pits[5].getNumOfStones()==0)||(player2Pits[0].getNumOfStones()==0 && player2Pits[1].getNumOfStones()==0 && player2Pits[2].getNumOfStones()==0 && player2Pits[3].getNumOfStones()==0 && player2Pits[4].getNumOfStones()==0 && player2Pits[5].getNumOfStones()==0)) {
	return true;
}
return false;		
}
public boolean isPlayer1Win() {
	//----------------------------------
	//Summary:if there is no stone in player 1's all pits at the same time ,player 1 wins
	//-----------------------------------		
	Pit[] player1Pits=getPlayer1Pits();		
	if((player1Pits[0].getNumOfStones()==0 && player1Pits[1].getNumOfStones()==0 && player1Pits[2].getNumOfStones()==0 && player1Pits[3].getNumOfStones()==0 && player1Pits[4].getNumOfStones()==0 && player1Pits[5].getNumOfStones()==0)) {
		return true;
	}
return false;	
}
public boolean isPlayer2Win() {
	//----------------------------------
	//Summary:if there is no stone in player 2's all pits at the same time ,player 1 wins
	//-----------------------------------		
	Pit[] player2Pits=getPlayer2Pits();	
if((player2Pits[0].getNumOfStones()==0 && player2Pits[1].getNumOfStones()==0 && player2Pits[2].getNumOfStones()==0 && player2Pits[3].getNumOfStones()==0 && player2Pits[4].getNumOfStones()==0 && player2Pits[5].getNumOfStones()==0)) {
	return true;
}
return false;	
}
public boolean isPlayerCastleIncremented(Pit[] pit) {
//-----------------------------------------------
//Summary:Rule 2 is applied.
//the parameter is dfs result,if stones visited castle after dfs algorithm applied returns true
//------------------------------------------------	
   for(Pit traversedPits:pit) {
	if(traversedPits==getPlayer1Castle() || traversedPits==getPlayer2Castle()) {
		return true;
	}
}
return false;
}
public void takeAllStonesFromTheOpponentPitThatYouMadeStonesEven(int playerID,Pit [] traversalPits,Pit[] opponentPits) {
	//-----------------------------------------------
	//Summary:Rule 4 is applied.
	//the parameters are player id who makes move, dfs traversal result and pits of opponent. 
	//the aim is the find common pits between opponent pits and dfs traversal result,such as player id is 1 and 
	//dfs result is 5-6-7-8 and opponent pits are 8-9-10-11-12-13 then common pits between dfs and player 2 pits are 8.
	//if id=1 , dfs result is 6-7-8-9 and opponent pits are 8-9-10-11-12-13 then common pits between dfs 
	//and player 2 pits are 8-9.
	//------------------------------------------------	 		
	int player1CastleIdx=getPlayer1Castle().getPitIdx();
	int player2CastleIdx=getPlayer2Castle().getPitIdx();
	int numberOfStonesInPlayer1Castle=allPits[player1CastleIdx].getNumOfStones();
	int numberOfStonesInPlayer2Castle=allPits[player2CastleIdx].getNumOfStones();
    Pit[] opponent=getOpponentTraversedPitsAfterDfs(traversalPits,opponentPits);//common pits between dfs and opponent	
    if(playerID==1) {
    	if(opponent==null) {//if there is no common then the method does not do anything.
    		return ;
    	}else {    		
    		for(Pit pit :opponent) {
    			if(pit.getNumOfStones()!=0&&pit.getNumOfStones()%2==0) {
    				numberOfStonesInPlayer1Castle+=pit.getNumOfStones();//capture all stones if player made one of the 
    				                                               //opponent's pit even.Then add these to player's castle.
    				allPits[player1CastleIdx].setNumOfStones(numberOfStonesInPlayer1Castle);
    				pit.setNumOfStones(0);//set number of stones to 0 in the opponent pit which player make the stones even     				
    			}
    		}    		
    	}		
	}else if(playerID==2) {
		if(opponent==null) {
    		return ;
		}else {
    		
    		for(Pit pit :opponent) {
    			if(pit.getNumOfStones()%2==0) {
    				numberOfStonesInPlayer2Castle+=pit.getNumOfStones();
    				allPits[player2CastleIdx].setNumOfStones(numberOfStonesInPlayer2Castle);
    				pit.setNumOfStones(0);    				
    			}
    		}	
    	}				
	}else {		
		System.out.println("Invalid Player Index...");
	}		
}
public void captureOpponentStonesIfYouFillYourEmptyPit(int playerID,MangalaDirectedGraphImplementation game,Pit[]emptyPits,Pit[] dfsResult) {
//----------------------------------------------------------------------------------------	
//Summary:Rule 5 is applied.(This rule is known as "Tilki Kurali" in Turkish.	
//if last stone that player distribute goes to a pit which has no stones , and if that pit one of the player's own pit	
//such as while player 1 playing the game making his move and his last stone after dfs algorithm work goes to 
//his/her own empty pit , player captures opposite pit which belongs to player 2 and the pit which player just filled.	
//-----------------------------------------------------------------------------------------		
	int player1CastleIdx=getPlayer1Castle().getPitIdx();
	int player2CastleIdx=getPlayer2Castle().getPitIdx();
	int numberOfStonesInPlayer1Castle=allPits[player1CastleIdx].getNumOfStones();
	int numberOfStonesInPlayer2Castle=allPits[player2CastleIdx].getNumOfStones();
    Pit[] p1Pits = getPlayer1Pits();
	Pit[] p2Pits=getPlayer2Pits();
    if(playerID==1) {	 	
	for(Pit a : emptyPits) {    	
    		if(a==dfsResult[dfsResult.length-1] && isPitBelongToAPlayer(a,p1Pits) ) {
            //if the empty pit is the distributed pit of the dfs result and belongs to the player not belongs to opponent   			
    			int player1Opponent=getPitIdAcrossOpponentSide(a);//takes index of opposite pit of empty pit
    			if(allPits[player1Opponent].getNumOfStones()!=0) {//if opposite is not empty
    			numberOfStonesInPlayer1Castle+=1;//increment castle by one.
    			numberOfStonesInPlayer1Castle+=allPits[player1Opponent].getNumOfStones();//capture all stones in opposite pit to the castle
    		    allPits[player1CastleIdx].setNumOfStones(numberOfStonesInPlayer1Castle);
  //set stones to 0 for empty pit(filled after dfs) and opposite pit. 			
    		    a.setNumOfStones(0);
    			allPits[player1Opponent].setNumOfStones(0);
    			}
    			}    	
    }
	}else {		
		for(Pit a : emptyPits) {	    	
    		if(a==dfsResult[dfsResult.length-1] && isPitBelongToAPlayer(a,p2Pits) ) {    			
    			int player2Opponent=getPitIdAcrossOpponentSide(a);
    			if(allPits[player2Opponent].getNumOfStones()!=0) {
    			numberOfStonesInPlayer2Castle+=1;
    			numberOfStonesInPlayer2Castle+=allPits[player2Opponent].getNumOfStones();
    		    allPits[player2CastleIdx].setNumOfStones(numberOfStonesInPlayer2Castle);
    			a.setNumOfStones(0);
    			allPits[player2Opponent].setNumOfStones(0);
    			}
    			}   	
    }		
	}
}
public boolean isPitBelongToAPlayer(Pit pit,Pit[]playerPits) {
	//----------------------------------------------------------------------------------------	
	//Summary:If parameter pit instance belongs to the parameter pit array , returns true.		
	//-----------------------------------------------------------------------------------------		
	for(Pit pp:playerPits) {
		if(pit==pp) {
			return true;
		}
	}
	return false;
}
public int getPitIdAcrossOpponentSide(Pit pit) {
	//----------------------------------------------------------------------------------------	
	//Summary:Returns to the index of opposite of the parameter pit.For Rule 5.		
	//-----------------------------------------------------------------------------------------			
	int pitIdx=pit.getPitIdx();
	switch(pitIdx) {
	case 1 :
		return 13;
	case 2 :
		return 12 ;
	case 3 :
		return 11;
	case 4:
		return 10;
	case 5:
		return 9;
	case 6:
		return 8;
	case 8:
		return 6;
	case 9:
		return 5;
	case 10:
		return 4;
	case 11:
		return 3;
	case 12:
		return 2;
	case 13 :
		return 1;
 default:
	 return -1;
 }	
}
public boolean controlTraversalResultContainsOpponentPits(Pit [] traversalPits,Pit[] opponentPits) {
	//----------------------------------------------------------------------------------------	
	//Summary:returns true if dfs contains one of the selected player's pit.	
	//-----------------------------------------------------------------------------------------		
	for(Pit a : traversalPits) {
        for(Pit b : opponentPits) {
        if(a==b) {
        	return true;
        }       
        }
        	}
	return false;	
}
public int controlHowManyPitsInTraversalBelongsToTheOpponent(Pit [] traversalPits,Pit[] opponentPits) {
	//----------------------------------------------------------------------------------------	
	//Summary:returns the number of elements in common aray between dfs result and player pits.	
	//-----------------------------------------------------------------------------------------			
	int count = 0;
	for(Pit a : traversalPits) {
        for(Pit b : opponentPits) {
        if(a==b) {
        	count++;
        }       
        }
        	}
	return count;
}
public int getNumberOfEmptyPitsForPlayer(Pit [] playerPits) {
	//----------------------------------------------------------------------------------------	
	//Summary:returns the total number of pits which has no contain stone in parameter pit array.	
	//-----------------------------------------------------------------------------------------				
	int count = 0;
	for(Pit a : playerPits) {
		if(a.getNumOfStones()==0) {
			count++;
		}
	}
    return count;        	
}
public boolean doesPlayerPitsContainEmptyStone(int playerID) {
//switch cases are for players while they playing and making their moves.
//if player 1's one of the stone is empty returns true , else returns false. Same for Player 2.	
switch(playerID) {
case 1 :
if(allPits[1].getNumOfStones()==0||allPits[2].getNumOfStones()==0||allPits[3].getNumOfStones()==0||allPits[4].getNumOfStones()==0||allPits[5].getNumOfStones()==0||allPits[6].getNumOfStones()==0) {
		return true;
	}else {
		return false;
	}
case 2 :
	if(allPits[8].getNumOfStones()==0||allPits[9].getNumOfStones()==0||allPits[10].getNumOfStones()==0||allPits[11].getNumOfStones()==0||allPits[12].getNumOfStones()==0||allPits[13].getNumOfStones()==0) {
		return true;
	}else {
		return false;
	}
default:
	return false;
}	
}
public Pit[] getPlayersOwnTraversedPitsAfterDfs(Pit [] traversalPits,Pit[] playerPits){
	Pit[]playerOwnPits=new Pit[controlHowManyPitsInTraversalBelongsToTheOpponent(traversalPits,playerPits)];
    int i =0;
   if(!controlTraversalResultContainsOpponentPits(traversalPits,playerPits) ) {
	   return null;
   }else {    
    while(i<controlHowManyPitsInTraversalBelongsToTheOpponent(traversalPits,playerPits)) {
    	for(Pit a : traversalPits) {
            for(Pit b : playerPits) {
            if(a==b) {
            	playerOwnPits[i]=a;
            i++;            
            }           
            }    	
    }
   }
return playerOwnPits;
   }	
}
public Pit[] getEmptyPits(Pit[]playerPit) {

/*if(getNumberOfEmptyPitsForPlayer(playerPit)==0) {
	return null;
}*/
Pit[] playerEmptyPits=new Pit[getNumberOfEmptyPitsForPlayer(playerPit)];
int i = 0;
while(i<getNumberOfEmptyPitsForPlayer(playerPit)) {
	for(Pit a:playerPit) {
		if(a.getNumOfStones()==0) {
			playerEmptyPits[i]=a;
		       i++;
		}
	}
}
return playerEmptyPits;
}
public Pit[] getOpponentTraversedPitsAfterDfs(Pit [] traversalPits,Pit[] opponentPits) {
	//----------------------------------------------------------------------------------------	
	//Summary:returns to the traversed pits after dfs and these pits must belong to the opponent.
	//-----------------------------------------------------------------------------------------		
	Pit[]opponent=new Pit[controlHowManyPitsInTraversalBelongsToTheOpponent(traversalPits,opponentPits)];
    int i =0;
   if(!controlTraversalResultContainsOpponentPits(traversalPits,opponentPits) ) {
	   return null;
   }else {    
    while(i<controlHowManyPitsInTraversalBelongsToTheOpponent(traversalPits,opponentPits)) {
    	for(Pit a : traversalPits) {
            for(Pit b : opponentPits) {
            if(a==b) {
            	opponent[i]=a;
            i++;            
            }           
            }    	
    }
   }
return opponent;
   }
}
public void incrementStonesInTraversedPits(MangalaDirectedGraphImplementation game,Pit[] pit) {
	//----------------------------------------------------------------------------------------	
	//Summary:Rule 1 is applied.	
	//all traversed pits are incremented by one.
	//-----------------------------------------------------------------------------------------			
	int chosenPitIndex=pit[0].getPitIdx();  
    if(pit.length>1) {//if traversed pits more than one.
	for(Pit traversedPits:pit) {			
		game.incrementNumberOfStonesInPit(allPits[traversedPits.getPitIdx()]);
	}
allPits[chosenPitIndex].setNumOfStones(1);
}
    else{//if there is only one stone in the selected pit.
     allPits[chosenPitIndex].setNumOfStones(allPits[chosenPitIndex].getNumOfStones() + 1);
    allPits[game.FindAncestorPit(pit[0]).getPitIdx()].setNumOfStones(0);   
    }
}
public void makePlayer1PlayTheGame(MangalaDirectedGraphImplementation game,int player1ChosenPit) {
	//----------------------------------------------------------------------------------------	
	//Summary:Player 1 makes move.	
	//-----------------------------------------------------------------------------------------		
	Pit[]player1Pits=getPlayer1Pits();
	 Pit[] player2Pits=getPlayer2Pits();	
    Pit [] player1EmptyPits=getEmptyPits(player1Pits);
    Pit[]player1DfsTraversal=applyDfs(game,allPits[player1ChosenPit].getPitIdx());
    incrementStonesInTraversedPits(game, player1DfsTraversal);
    takeAllStonesFromTheOpponentPitThatYouMadeStonesEven(1, player1DfsTraversal, player2Pits);
    captureOpponentStonesIfYouFillYourEmptyPit(1,game, player1EmptyPits, player1DfsTraversal);
    PrintMangala(game);
}
public void makePlayer2PlayTheGame(MangalaDirectedGraphImplementation game,int player2ChosenPit) {
	//----------------------------------------------------------------------------------------	
	//Summary:Player 2 makes move.	
	//-----------------------------------------------------------------------------------------		
	Pit[]player1Pits=getPlayer1Pits();
	 Pit[] player2Pits=getPlayer2Pits();	
   Pit [] player2EmptyPits=getEmptyPits(player2Pits);   
   Pit[]player2DfsTraversal=applyDfs(game,allPits[player2ChosenPit].getPitIdx());
   incrementStonesInTraversedPits(game, player2DfsTraversal);
   takeAllStonesFromTheOpponentPitThatYouMadeStonesEven(2, player2DfsTraversal, player1Pits);
   captureOpponentStonesIfYouFillYourEmptyPit(2,game, player2EmptyPits, player2DfsTraversal);
   PrintMangala(game);		
}
public int convertInputToPitArrayIndexForPlayer2(int input) {
	//----------------------------------
	//Summary:Converts input to array index.This method is used for player 2 because indexes of player 2 pits are
	//Player 2'first pit=8 
	//Player 2'second pit=9 
	//Player 2'third pit=10  
	//Player 2'fourth pit=11 
	//Player 2'fifth pit=12  
	//Player 2'sixth pit=13 
	//-----------------------------------	
Pit[] allPits=getAllPits();
switch(input) {
case 1:
	return 8;
case 2:
return 9;
case 3:
	return 10;
case 4 :
	return 11;
case 5 :
 return 12;
case 6 :
return 13;
default:
	return -1;
}	
}
public void PlayGame(MangalaDirectedGraphImplementation game, Scanner sc) {
    int player1Choice, player2Choice;
    int convertPlayer2ChoiceToIndex;
    Pit[] player2DfsResult, player1DfsResult;
    boolean player1ExtraMove = false;
    boolean player2ExtraMove = false;    
 System.out.println("===================================================================================");
    System.out.println("              THE MANGALA BOARD AT THE BEGINNING OF THE GAME");
    System.out.println("              PLAYER 1 STARTS THE GAME AT THE BEGINNING...");
    PrintMangala(game);
    System.out.println("===================================================================================");  
    // Player 1 starts the game at the begginning
    while (!isThereAWinner()) {
        // Player 1 Turn
        System.out.println("Player 1 Turn... Please Choose a Pit That is Not Empty.");
        player1Choice = sc.nextInt();
        player1DfsResult = applyDfs(game, player1Choice);
        makePlayer1PlayTheGame(game, player1Choice);       
        //if player 1 castle visited after dfs traversal,player 1 earns an extra move
        if (isPlayerCastleIncremented(player1DfsResult)) {
            System.out.println("Player 1 Earns an Extra Move Because a Stone Player 1 Drop Is In Player 1's Own Castle.");
            player1ExtraMove = true;
        } else {
            player1ExtraMove = false;//if player 1 castle not visited after dfs traversal,player 2 makes move
        }        
        if (player1ExtraMove) {
            System.out.println("Player 1 Turn... Please Choose a Pit That is Not Empty.");
            player1Choice = sc.nextInt();
            makePlayer1PlayTheGame(game, player1Choice);
            player1ExtraMove = false;
        //extra moves are limited by one.
        }  
        // Player 2 Turn
        if (!isThereAWinner()) {
            System.out.println("Player 2 Turn... Please Choose a Pit That is Not Empty.");
            player2Choice = sc.nextInt();
            convertPlayer2ChoiceToIndex = convertInputToPitArrayIndexForPlayer2(player2Choice);
            player2DfsResult = applyDfs(game, convertPlayer2ChoiceToIndex);
            makePlayer2PlayTheGame(game, convertPlayer2ChoiceToIndex);       
            if (isPlayerCastleIncremented(player2DfsResult)) {
                System.out.println("Player 2 Earns an Extra Move Because a Stone That Player 2 Drop Is In Player 2's Own Castle.");
                player2ExtraMove = true;
            } else {
                player2ExtraMove = false;
            }
        }       
        if (player2ExtraMove) {
            System.out.println("Player 2 Turn... Please Choose a Pit That is Not Empty.");
            player2Choice = sc.nextInt();
            convertPlayer2ChoiceToIndex = convertInputToPitArrayIndexForPlayer2(player2Choice);
            makePlayer2PlayTheGame(game, convertPlayer2ChoiceToIndex);
            player2ExtraMove = false;
        }
    }
System.out.println();
System.out.println();    
System.out.println();    
    if(isPlayer1Win()) {
	System.out.println("              GAME OVER.THE WINNER IS PLAYER 1");
	printPlayer1WonTheGame();
}else {
	System.out.println("              GAME OVER.THE WINNER IS PLAYER 2");
	printPlayer2WonTheGame();
}
}
public void printPlayer1WonTheGame() {
	System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");	
	System.out.println("|           |     "+0+"    |     "+0+"   |      "+0+"  |     "+0+"   |     "+0+"   |     "+0+"   |"+"         |");
	System.out.println("|     "+48+"    |----------+---------+---------+---------+---------+---------|    "+0+"    |");
	System.out.println("|           |     "+0+"    |     "+0+"   |      "+0+"  |     "+0+"   |     "+0+"   |     "+0+"   |"+"         |");
	System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");	
}
public void printPlayer2WonTheGame() {
	System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");	
	System.out.println("|           |     "+0+"    |     "+0+"   |      "+0+"  |     "+0+"   |     "+0+"   |     "+0+"   |"+"         |");
	System.out.println("|     "+0+"     |----------+---------+---------+---------+---------+---------|    "+48+"   |");
	System.out.println("|           |     "+0+"    |     "+0+"   |      "+0+"  |     "+0+"   |     "+0+"   |     "+0+"   |"+"         |");
	System.out.println("+-----------+----------+---------+---------+---------+---------+---------+---------+");		
}
public void PrintMangala(MangalaDirectedGraphImplementation game) {
	//----------------------------------------------------------------------------------------	
	//Summary:Board is printed.	
	//-----------------------------------------------------------------------------------------		
	game.printMangala();
}
public Pit[] applyDfs(MangalaDirectedGraphImplementation game,int chosenPit) {
	//----------------------------------------------------------------------------------------	
	//Summary:The DFS algorithm which is defined in the MangalaDirectedGraphImplementation class , is applied.	
	//-----------------------------------------------------------------------------------------		
	Pit[] getTraversedPits=game.dfsAlgorithmForStoneDistribution(allPits[chosenPit].getPitIdx());
	return getTraversedPits;	
}
}