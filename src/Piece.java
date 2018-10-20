public class Piece
{
	public final static int PAWN = 0;
	public final static int ROOK = 1;
	public final static int KNIGHT_1 = 2;
	public final static int BISHOP = 3;
	public final static int QUEEN = 4;
	public final static int KING = 5;
	private int type;
	public Piece(int typea)
	{
		type = typea;
	}
	public int getType()
	{
		return type;
	}
	public int setType(int typea)
	{
		type = typea;
		return type;
	} 
}