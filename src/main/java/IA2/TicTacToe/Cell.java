package IA2.TicTacToe;

public class Cell {
	private int owner; //0 for empty; 1 for player; 2 for AI
	private boolean owned;
	
	
		public Cell(){
			owner=0;
			owned=false;
		}
		
		public void setOwner(int owner) {
			this.owner = owner;
			this.owned = true;
		}
		
		public int getOwner() {
			return owner;
		}
		
		public boolean isOwned() {
			return owned;
		}
}
