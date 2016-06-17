
import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.*;

class ChessSymbols{
	
	public static void main (String[ ] args) throws
	UnsupportedEncodingException { 
		
	String unicodeMessage =
	"\u2654" 	+ // white king
	"\u2655"    + // white queen
	"\u2656" 	+ // white rook
	"\u2657" 	+ // white bishop
	"\u2658" 	+ // white knight
	"\u2659"	+ // white pawn
	"\n" 		+
	"\u265A"	+ // black king
	"\u265B"	+ // black queen
	"\u265C"	+ // white rook
	"\u265D"	+ // black bishop
	"\u265E"	+ // black knight
	"\u265F"	+ // black pawn
	"\n" ;

	PrintStream out = new PrintStream (System.out, true, "UTF-8");
	out.println(unicodeMessage) ;
	}
}

public class VirtualChess {
	
	//logger
	private final static Logger LOGGER = Logger.getLogger(VirtualChess.class.getName());
	
	public enum Chessmen {
		WHITE_KING,
		WHITE_QUEEN,
		WHITE_ROOK,
		WHITE_BISHOP,
		WHITE_KNIGHT,
		WHITE_PAWN,
		BLACK_KING,
		BLACK_QUEEN,
		BLACK_ROOK,
		BLACK_BISHOP,
		BLACK_KNIGHT,
		BLACK_PAWN,
		EMPTY;
	}


	//Creates a chessboard size 8 x 8. 
	public static void main(String[] args) {
		try {
			ChessLogger.setup();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot set up ChessLogger");
		}
		
		LOGGER.setLevel(Level.ALL);
		
		Chessmen[][] chessboard = new Chessmen [8][8];
		Scanner sc = new Scanner(System.in);
			
			for(int i=0; i < 8; i++){
				for(int j=0; j < 8; j++){
					if(i == 7){
						if(j == 0 || j == 7){
							chessboard[i][j] = Chessmen.WHITE_ROOK;
						}
						else if(j == 1 || j == 6){
							chessboard[i][j] = Chessmen.WHITE_KNIGHT;
						}
						else if(j == 2 || j == 5){
							chessboard[i][j] = Chessmen.WHITE_BISHOP;
						}
						else if(j == 3){
							chessboard[i][j] = Chessmen.WHITE_QUEEN;
						}
						else if(j == 4){
							chessboard[i][j] = Chessmen.WHITE_KING;
						}
					}
					else if(i == 6){
						chessboard[i][j] = Chessmen.WHITE_PAWN;
					}
					else if(i == 1){
						chessboard[i][j] = Chessmen.BLACK_PAWN;
					}
					else if(i == 0){
						if(j == 0 || j == 7){
							chessboard[i][j] = Chessmen.BLACK_ROOK;
						}
						else if(j == 1 || j == 6){
							chessboard[i][j] = Chessmen.BLACK_KNIGHT;
						}
						else if(j == 2 || j == 5){
							chessboard[i][j] = Chessmen.BLACK_BISHOP;
						}
						else if(j == 3){
							chessboard[i][j] = Chessmen.BLACK_QUEEN;
						}
						else if(j == 4){
							chessboard[i][j] = Chessmen.BLACK_KING;
						}
					}
					else{
						chessboard[i][j] = Chessmen.EMPTY;
					}
				}
				
			}
		
		//check for exit
		Boolean exit = false;
		int counter = 0;
		String currentPlayer = " ";
		System.out.println("Let's start with the whites.\nPlease enter move in the form 'x0' to 'x0'");
		while(!exit)
		{
			System.out.println(" ");
			printBoard(chessboard);

			if(counter % 2 == 0)
			{
				System.out.println("It's white's turn.");
				currentPlayer = "white";
			}
			else
			{	
				System.out.println("It's black's turn.");
				currentPlayer = "black";
			}
			counter++;
			
			String newMove = sc.nextLine();
			if(newMove.equals("exit"))
			{
				System.out.println("GoodBye");
				System.exit(0);
			}
			else if(newMove.length() != 8)
			{
				LOGGER.warning("That's invalid input.");
			}
			
			
			else
			{
				move(chessboard, newMove, currentPlayer, counter);
			}
		}
	}
	//chessboard
	public static void printBoard (Chessmen[][] chessboard) {
		String pieces;
	    int rows = 8;
	    int columns = 8;
	    System.out.println("\ta\tb\tc\td\te\tf\tg\th");
	    
		for (int i = 0; i < rows; i++){
			System.out.print((7-i) + 1 + "." + "\t");
			
			
			for(int j=0; j < columns; j++){
				
				switch(chessboard[i][j]){
					case WHITE_KING : pieces = "\u2654 \t";
					break;
					case WHITE_QUEEN : pieces = "\u2655 \t";
					break;
					case WHITE_ROOK : pieces = "\u2656 \t";
					break;
					case WHITE_BISHOP : pieces = "\u2657 \t";
					break;
					case WHITE_KNIGHT : pieces = "\u2658 \t";
					break;
					case WHITE_PAWN : pieces = "\u2659 \t";
					break;
					case BLACK_KING : pieces = "\u265A \t";
					break;
					case BLACK_QUEEN : pieces = "\u265B \t";
					break;
					case BLACK_ROOK : pieces = "\u265C \t";
					break;
					case BLACK_BISHOP : pieces = "\u265D \t";
					break;
					case BLACK_KNIGHT : pieces = "\u265E \t";
					break;
					case BLACK_PAWN : pieces = "\u265F \t";
					break;
					case EMPTY: pieces = "\t";
					break;
					default: pieces = "invalid";
					break;
				}
				System.out.print(pieces);
			}
			System.out.println("");
		}
	}

	public static void move(Chessmen[][] chessboard, String move, String currentPlayer, int counter)
	{	

		//parse move string into components
		String[] components = move.split(" ");
		
		//if you assume that the move is "e1 to e5" then
		//components[0].charAt(0) = 'e'
		//components[0].charAt(1) == '1'
		
		int fromY = 0;
		int fromX = - (Character.getNumericValue(components[0].charAt(1))-8);
		int toY = 0;
		int toX = - (Character.getNumericValue(components[2].charAt(1))-8);
		
		if (components[0].charAt(0) == 'a')
		{
			fromY = 0;
		}
		
		else if(components[0].charAt(0) == 'b')
		{
			fromY = 1;
		}
		
		else if(components[0].charAt(0) == 'c')
		{
			fromY = 2;
		}
		
		else if(components[0].charAt(0) == 'd')
		{
			fromY = 3;
		}
		
		else if(components[0].charAt(0) == 'e')
		{
			fromY = 4;
		}
		
		else if(components[0].charAt(0) == 'f')
		{
			fromY = 5;
		}
		
		else if(components[0].charAt(0) == 'g')
		{
			fromY = 6;
		}
		
		else 
		{
			fromY = 7;
		}
		
		if (components[2].charAt(0) == 'a')
		{
			toY = 0;
		}
		
		else if(components[2].charAt(0) == 'b')
		{
			toY = 1;
		}
		
		else if(components[2].charAt(0) == 'c')
		{
			toY = 2;
		}
		
		else if(components[2].charAt(0) == 'd')
		{
			toY = 3;
		}
		
		else if(components[2].charAt(0) == 'e')
		{
			toY = 4;
		}
		
		else if(components[2].charAt(0) == 'f')
		{
			toY = 5;
		}
		
		else if(components[2].charAt(0) == 'g')
		{
			toY = 6;
		}
		
		else 
		{
			toY = 7;
		}
		
		if(checkMove(chessboard, fromX, fromY, toX, toY) && isEmpty(chessboard, fromY, fromX, toY, toX) && checkPiece(chessboard, fromX, fromY, toX, toY, currentPlayer, counter))
		{
			chessboard[toX][toY] = chessboard[fromX][fromY];
			chessboard[fromX][fromY] = Chessmen.EMPTY;
		}
		
		else{
			LOGGER.severe("That is invalid");
		}
	}
	
	//Validation
	public static boolean checkMove(Chessmen[][] chessboard, int fromX, int fromY, int toX, int toY)
	{
		boolean validMove = false;
		
		if(chessboard[fromX][fromY] == Chessmen.BLACK_KING)
		{
			if((toX <= fromX + 1 && toX >= Math.abs(fromX -1)) && (toY <= fromY + 1 && toY >= Math.abs(fromY -1)))
			{
				validMove = true;
				
			}
			
			else
			{
				validMove = false;
			}
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.WHITE_KING)
		{
			if((toX <= fromX + 1 && toX >= Math.abs(fromX -1)) && (toY <= fromY + 1 && toY >= Math.abs(fromY -1)))
				{
					validMove = true;
					
				}
				
			else
				{
					validMove = false;
				}
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.BLACK_KNIGHT)
		{
			int newRow = Math.abs(toX - fromX);
			int newColumn = Math.abs(toY - fromY);
			
			if ((newRow == 2 && newColumn == 1) || (newRow == 1 && newColumn == 2))
			{
				validMove = true;
			}
			else
			{
				validMove = false;
			}
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.WHITE_KNIGHT)
		{
			int newRow = Math.abs(toX - fromX);
			int newColumn = Math.abs(toY - fromY);
			
			if ((newRow == 2 && newColumn == 1) || (newRow == 1 && newColumn == 2))
			{
				validMove = true;
			}
			else
			{
				validMove = false;
			}
		}
		
		else if (chessboard[fromX][fromY] == Chessmen.BLACK_ROOK)
		{
			if (toX != fromX || toY != fromY)
			{
				validMove = true;
			}
			
			else
			{
				for(int i = 0; i < toX; i++)
				{
					for(int j = 0; j < toY; j++)
					{
						if(chessboard[i][j] == Chessmen.EMPTY)
						{
							validMove = true;
						}
						else
						{
							validMove = false;
						}
					}
				}
			}
				
		}
		
		else if (chessboard[fromX][fromY] == Chessmen.WHITE_ROOK)
		{
			if (toX != fromX || toY != fromY)
			{
				validMove = true;
			}
			
			else
			{
				for(int i = 0; i < toX; i++)
				{
					for(int j = 0; j < toY; j++)
					{
						if(chessboard[i][j] == Chessmen.EMPTY)
						{
							validMove = true;
						}
						else
						{
							validMove = false;
						}
					}
				}
			}
				
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.BLACK_BISHOP)
		{
			int newRow = Math.abs(toX - fromX);
		    int newColumn = Math.abs(toY - fromY);
		    
			if(newRow != newColumn)
			{
		        validMove =  false;
			}
		    
			else
			{
				for(int i = 0; i < toX; i++)
				{
					for(int j = 0; j < toY; j++)
					{
						if(chessboard[i][j] == Chessmen.EMPTY)
						{
							validMove = true;
						}
						else
						{
							validMove = false;
						}
					}
				}
			}
		    
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.WHITE_BISHOP)
		{
			int newRow = Math.abs(toX - fromX);
		    int newColumn = Math.abs(toY - fromY);
		    
			if(newRow != newColumn)
			{
		        validMove =  false;
			}
		    
			else
			{
				for(int i = 0; i < toX; i++)
				{
					for(int j = 0; j < toY; j++)
					{
						if(chessboard[i][j] == Chessmen.EMPTY)
						{
							validMove = true;
						}
						else
						{
							validMove = false;
						}
					}
				}
			}
		    
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.BLACK_QUEEN)
		{
			if(Math.abs(toX - fromX) >= 1 && (toY - fromY) == 0){
				validMove = true;
			}
			//can move up and down
			else if((toX - fromX) == 0 && Math.abs(toY - fromY) >= 1){
				validMove = true;
			}
			//can move diagonally
			else if(Math.abs(toX - fromX) == Math.abs(toY - fromY)){
				validMove = true;
			}
			else{
				validMove = false;
			}
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.WHITE_QUEEN)
		{
			if(Math.abs(toX - fromX) >= 1 && (toY - fromY) == 0){
				validMove = true;
			}
			//can move up and down
			else if((toX - fromX) == 0 && Math.abs(toY - fromY) >= 1){
				validMove = true;
			}
			//can move diagonally
			else if(Math.abs(toX - fromX) == Math.abs(toY - fromY)){
				validMove = true;
			}
			else
			{
				validMove = false;
			}
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.BLACK_PAWN)
		{
			if(toY == fromY && toX == fromX+2 || toX == fromX+1){
				validMove = true;
			}
			else{
				validMove = false;
			}
		}
		
		else if(chessboard[fromX][fromY] == Chessmen.WHITE_PAWN)
		{
			if(toY == fromY && toX == fromX-2 || toX == fromX-1){
				validMove = true;
			}
			else{
				validMove = false;
			}
		}
		
		else{
			validMove = false;
		}
		
		return validMove;
	}
	
	
	public static boolean isEmpty (Chessmen [][] chessboard, int fromY, int fromX, int toY, int toX) {
		if (chessboard[fromX][fromY] != Chessmen.EMPTY){
			return true;
		} 
		else {
			return false; 
		}
	}
	
	public static Boolean checkPiece(Chessmen[][] chessboard, int fromX, int fromY, int toX, int toY, String currentPlayer, int counter){
		if(chessboard[fromX][fromY] == Chessmen.BLACK_BISHOP || 
				chessboard[fromX][fromY] == Chessmen.BLACK_PAWN || 
				chessboard[fromX][fromY] == Chessmen.BLACK_ROOK || 
				chessboard[fromX][fromY] == Chessmen.BLACK_KNIGHT || 
				chessboard[fromX][fromY] == Chessmen.BLACK_KING || 
				chessboard[fromX][fromY] == Chessmen.BLACK_QUEEN) {
			if(currentPlayer.equals("black")){
				switch(chessboard[toX][toY]) {
				case BLACK_ROOK : return false;
				case BLACK_KNIGHT: return false; 
				case BLACK_BISHOP: return false; 
				case BLACK_QUEEN: return false;
				case BLACK_KING: return false; 
				case BLACK_PAWN: return false; 
				default: currentPlayer = "white"; 
				return true;
				}
			}
			else {
				LOGGER.warning("It's not your turn");
				return false;
			}
		}
		else if(chessboard[fromX][fromY] == Chessmen.WHITE_BISHOP ||
				chessboard[fromX][fromY] == Chessmen.WHITE_ROOK || 
				chessboard[fromX][fromY] == Chessmen.WHITE_KNIGHT || 
				chessboard[fromX][fromY]== Chessmen.WHITE_QUEEN ||
				chessboard[fromX][fromY] == Chessmen.WHITE_KING || 
				chessboard[fromX][fromY]== Chessmen.WHITE_PAWN) {
			if(currentPlayer.equals("white") || counter == 0){
				switch(chessboard[toX][toY]){
				case WHITE_ROOK : return false; 
				case WHITE_KNIGHT : return false; 
				case WHITE_BISHOP : return false; 
				case WHITE_QUEEN : return false; 
				case WHITE_KING : return false; 
				case WHITE_PAWN : return false; 
				default: currentPlayer = "black"; System.out.println(currentPlayer); 
				return true;
				}
			}
			else {
				LOGGER.warning("It's not your turn");
				return false;
			}
		}
		else{
			return false;
		}
	}
}