package src;
public class Tile 
{
	private Piece resident;
	private int x_pos;
	private int y_pos;
	
	public Tile(Piece piece, int x, int y)
	{
		resident = piece;
		this.x_pos = x;
		this.y_pos = y;
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
	
	public void set_x(int x) {
		this.x_pos = x;
	}
	
	public int get_x() {
		return this.x_pos;
	}
	
	public void set_y(int y) {
		this.x_pos = y;
	}
	
	public int get_y() {
		return this.x_pos;
	}
}
