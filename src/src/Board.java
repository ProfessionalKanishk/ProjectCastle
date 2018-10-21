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
					board[i][j] = new Tile(new Piece(1), i, j);
				else if((i == 0 && j == 1)||(i == 0 && j == 6)||(i == 7 && j == 1)||(i == 7 && j == 6))
					board[i][j] = new Tile(new Piece(2), i, j);
				else if((i == 0 && j == 2)||(i == 0 && j == 5)||(i == 7 && j == 2)||(i == 7 && j == 5))
					board[i][j] = new Tile(new Piece(3), i, j);
				else if((i == 0 && j == 3)||(i == 7 && j == 3))
					board[i][j] = new Tile(new Piece(4), i, j);
				else if((i == 0 && j == 4)||(i == 7 && j == 4))
					board[i][j] = new Tile(new Piece(5), i, j);
				else if(i == 1 || i == 6)
					board[i][j] = new Tile(new Piece(0), i, j);
				else
					board[i][j] = null;
			}
	}
	
	public boolean valid_move(Tile curr, Tile dest) {
		int dx = 0;
		int dy = 0;
		if(dest.get_x() > 0 && dest.get_x() < 8 && dest.get_y() > 0 && dest.get_y() < 8) {
			dx = curr.get_x() - dest.get_x();
			dy = curr.get_y() - dest.get_y();
		}
		
		else {
			System.out.print("Incorrect destination");
			return false;
		}
		//Pawn move validity
	    if(curr.getResident().getType() == 0) {
			
			if (dx == 1 && dy == 1) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
				
			if(dx == 1) {
				return true;
			}
			
			return false;
		}
	    
	    //Rook move validity
	    else if(curr.getResident().getType() == 1) {
			if(curr.get_x() - dest.get_x() == 0 && curr.get_y() - dest.get_y() != 0) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			else if(curr.get_x() - dest.get_x() != 0 && curr.get_y() - dest.get_y() == 0) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			return false;
		}

	    //Knight move validity
	    else if(curr.getResident().getType() == 2) {
			if(abs(dx) == 1 && abs(dy) == 2) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			else if(abs(dx) == 2 && abs(dy) == 2) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			return false;
		}

	    //Bishop move validity
	    else if(curr.getResident().getType() == 3) {
			if(abs(dx) == abs(dy)) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			return false;
		}
	    
	    //Queen move validity
	    else if(curr.getResident().getType() == 4) {
			if(abs(dx) == abs(dy)) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			else if (abs(dx) == 0 && abs(dy) > 0) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			else if (abs(dx) > 0 && abs(dy) == 0) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			return false;
		}

	    //King move validity
	    else if(curr.getResident().getType() == 5) {
			if(abs(dx) == 1 && abs(dy) == 1) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			else if(abs(dx) == 1 && abs(dy) == 0) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			else if(abs(dx) == 0 & abs(dy) == 1) {
				dest.setResident(curr.getResident());
				curr.setResident(null);
				return true;
			}
			
			return false;
		}
	    
	    return false;
	}
	
	public Tile[][] getBoard()
	{
		return board;
	}
	
	public int getLevel() 
	{
		return level;
	}
	
	public int abs(int x) {
		if(x < 0) {
			return x * -1;
		}
		return x;
	}
}
