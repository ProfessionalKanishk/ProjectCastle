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
	public Piece getResident() 
	{
		return resident;
	}
	public Piece setResident(Piece piece)
	{
		resident = piece;
		return resident;
	}
}
