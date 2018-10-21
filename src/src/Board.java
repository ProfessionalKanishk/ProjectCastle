package src;


public class Board 
{
	private Tile board[][];
	private int level;
	public Board(int type)
	{
		level = type;
		board = new Tile[8][8];
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
			{
				if((i == 0 && j == 0)||(i == 0 && j == 7)||(i == 7 && j == 0)||(i == 7 && j == 7)) 
					board[i][j] = new Tile(new Piece(1));
				else if((i == 0 && j == 1)||(i == 0 && j == 6)||(i == 7 && j == 1)||(i == 7 && j == 6))
					board[i][j] = new Tile(new Piece(2));
				else if((i == 0 && j == 2)||(i == 0 && j == 5)||(i == 7 && j == 2)||(i == 7 && j == 5))
					board[i][j] = new Tile(new Piece(3));
				else if((i == 0 && j == 3)||(i == 7 && j == 3))
					board[i][j] = new Tile(new Piece(4));
				else if((i == 0 && j == 4)||(i == 7 && j == 4))
					board[i][j] = new Tile(new Piece(5));
				else if(i == 1 || i == 6)
					board[i][j] = new Tile(new Piece(0));
				else
					board[i][j] = null;
			}
	}
	
	public boolean valid_move(Tile current, Tile dest) {
		
		//Pawn move validity
	    if(current.getResident().getType() == 0) {
			
		}
	    
	    //Pawn move validity
	    else if(current.getResident().getType() == 1) {
			
		}

	    //Pawn move validity
	    else if(current.getResident().getType() == 2) {
			
		}

	    //Pawn move validity
	    else if(current.getResident().getType() == 3) {
			
		}
	    
	    //Pawn move validity
	    else if(current.getResident().getType() == 4) {
			
		}

	    //Pawn move validity
	    else if(current.getResident().getType() == 5) {
			
		}
	public Tile[][] getBoard()
	{
		return board;
	}
	public int getLevel() 
	{
		return level;
	}
}
