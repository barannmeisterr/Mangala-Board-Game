import java.util.Scanner;
//-----------------------------------------------------
//Title: Main class
//Author: Arda Baran
//Description: the game is initialized and played.
//------------------------------------------------------
public class Main {
    public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int numberOfPits = 14; 
MangalaDirectedGraphImplementation game=new MangalaDirectedGraphImplementation(numberOfPits);
MangalaGame mangala = new MangalaGame(game);    
mangala.PlayGame(game, sc);       
    }
}
