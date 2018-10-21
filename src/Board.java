

public class Board 
{
	private Tile board[][];
	
	public Board(int type)
	{
		board = new Tile[8][8];
		for(int i = 0; i < 8; i++)
			for(int j = 0; j < 8; j++)
			{
				if(i == 0 && j == 0) 
				{
					
				}
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

	}
}
