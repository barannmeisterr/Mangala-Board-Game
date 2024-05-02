//-----------------------------------------------------
//Title: TesterClass class
//Author: Arda Baran
//Description: This class tests methods are working well.
//------------------------------------------------------
public class TesterClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
        int numberOfPits = 14; 
        MangalaDirectedGraphImplementation gameBoard = new MangalaDirectedGraphImplementation(numberOfPits);
        MangalaGame g = new MangalaGame(gameBoard);
        Pit[] player1Pits=g.getPlayer1Pits();
   
        Pit[] player2Pits=g.getPlayer2Pits();
    
        Pit player1Castle = g.getPlayer1Castle();
       Pit p1c=player1Castle;
       
        Pit player2Castle = g.getPlayer2Castle();
     System.out.println();
      
     
        Pit[] testPits=g.getAllPits();
      
     
    	 
       System.out.println("beggining :");
       
       g.PrintMangala(gameBoard);
        
       /*System.out.println("Iteration 1: ");
       Pit[]empStart=g.getEmptyPits(player1Pits);
       Pit [] testDfs=g.applyDfs(gameBoard,testPits[5].getPitIdx());
       g.incrementStonesInTraversedPits(gameBoard, testDfs);
       g.takeAllStonesFromTheOpponentPitThatYouMadeStonesEven(1, testDfs, player2Pits); 
       g.captureOpponentStonesIfYouFillYourEmptyPit(1,gameBoard, empStart, testDfs);
               System.out.println("Player Contains Empty Stone ? "+ g.doesPlayerPitsContainEmptyStone(1));
       System.out.println("is castle incremented : "+g.isPlayerCastleIncremented(testDfs)); 
       System.out.println("Is There A Winner ? "+g.isThereAWinner()); 
       g.PrintMangala(gameBoard);
      
        
        System.out.println("Iteration 2: ");
        Pit[]emp=g.getEmptyPits(player1Pits);
        Pit[]testDfs2=g.applyDfs(gameBoard, testPits[6].getPitIdx());
        g.incrementStonesInTraversedPits(gameBoard, testDfs2);
        g.takeAllStonesFromTheOpponentPitThatYouMadeStonesEven(1, testDfs2, player2Pits);
        
       g.captureOpponentStonesIfYouFillYourEmptyPit(1,gameBoard, emp, testDfs2);      
        System.out.println("Player Contains Empty Stone ? "+ g.doesPlayerPitsContainEmptyStone(1));
        System.out.println("is castle incremented : "+g.isPlayerCastleIncremented(testDfs2)); 
        System.out.println("Is There A Winner ? "+g.isThereAWinner());
        g.PrintMangala(gameBoard);
         
        System.out.println("Iteration 3: ");
        Pit[]emp2=g.getEmptyPits(player1Pits);
        System.out.println("Player Contains Empty Stone ? "+ g.doesPlayerPitsContainEmptyStone(1));
        Pit[]testDfs3=g.applyDfs(gameBoard, testPits[5].getPitIdx());
        g.incrementStonesInTraversedPits(gameBoard, testDfs3);
        g.takeAllStonesFromTheOpponentPitThatYouMadeStonesEven(1, testDfs3, player2Pits);
       
       
        g.captureOpponentStonesIfYouFillYourEmptyPit(1,gameBoard, emp2, testDfs3);          
        System.out.println(g.getNumberOfEmptyPitsForPlayer(player1Pits));
       
       
        
        
        System.out.println("is castle incremented : "+g.isPlayerCastleIncremented(testDfs3)); 
        System.out.println("Is There A Winner ? "+g.isThereAWinner());
        g.PrintMangala(gameBoard);
    
        System.out.println("Iteration 4: ");
        System.out.println("Player Contains Empty Stone ? "+ g.doesPlayerPitsContainEmptyStone(1));
        Pit [] emp3=g.getEmptyPits(player1Pits); 
        Pit[]testDfs4=g.applyDfs(gameBoard, testPits[2].getPitIdx());
         
        g.incrementStonesInTraversedPits(gameBoard, testDfs4);
        g.captureOpponentStonesIfYouFillYourEmptyPit(1,gameBoard, emp3, testDfs4);
        
        
        g.takeAllStonesFromTheOpponentPitThatYouMadeStonesEven(1, testDfs4, player2Pits);
      
      
     System.out.println(g.getNumberOfEmptyPitsForPlayer(player1Pits));
     System.out.println("is castle incremented : "+g.isPlayerCastleIncremented(testDfs4)); 
     System.out.println("Is There A Winner ? "+g.isThereAWinner());
     g.PrintMangala(gameBoard);
	*/
     /* System.out.println("ýteration 1"); 
 g.makePlayer1PlayTheGame(gameBoard, 6);
 g.makePlayer2PlayTheGame(gameBoard, 13);	

 
 
 System.out.println("ýteration 2 ");
 g.makePlayer1PlayTheGame(gameBoard, 6);	
 g.makePlayer2PlayTheGame(gameBoard, 12);
 System.out.println("ýteration 3");
 g.makePlayer1PlayTheGame(gameBoard, 5);
 g.makePlayer2PlayTheGame(gameBoard, 12);
System.out.println("ýteration 4");
// g.makePlayer1PlayTheGame(gameBoard, 6);
 //g.makePlayer2PlayTheGame(gameBoard, 9);	
	System.out.println("ýteration 5 ");
 //g.makePlayer1PlayTheGame(gameBoard, 6);
 g.makePlayer2PlayTheGame(gameBoard, 13);
	System.out.println("ýteration 6 ");
 g.makePlayer1PlayTheGame(gameBoard, 5);
 g.makePlayer2PlayTheGame(gameBoard, 10);	
 g.makePlayer2PlayTheGame(gameBoard, 13);	
	*/
g.printPlayer1WonTheGame();
g.printPlayer2WonTheGame();	
	}

}
