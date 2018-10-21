package src;

public class Player {
	
	private char player;
	private int player_num;
	
	
	
	void Player(char name, int player_num) {
		this.player = name;
		this.player_num = player_num;
	}
	
	public void set_name(char name) {
		this.player = name;
	}
	
	public char get_name() {
		return this.player;
	}
	
	public void set_player_num(int num) {
		this.player_num = num;
	}
	
	public int get_player_num() {
		return this.player_num;
	}

}
