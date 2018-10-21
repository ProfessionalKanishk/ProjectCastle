package src;
public class Tile 
{
	private Piece resident;
	
	public Tile(Piece piece)
	{
		resident = piece;
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
