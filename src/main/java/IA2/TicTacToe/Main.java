package IA2.TicTacToe;

import java.lang.reflect.Array;

import org.omg.Messaging.SyncScopeHelper;

/**
 * Hello world!
 *
 */
public class Main 
{
	
	
	
	public 	static Cell A1,A2,A3,B1,B2,B3,C1,C2,C3;
	
	
	
	
    public static void main( String[] args )
    {
    	
    	A1 = new Cell();
    	A2 = new Cell();
    	A3 = new Cell();
    	B1 = new Cell();
    	B2 = new Cell();
    	B3 = new Cell();
    	C1 = new Cell();
    	C2 = new Cell();
    	C3 = new Cell();
    	/**
    	 
    	A1|A2|A3    	
    	B1|B2|B3
    	C1|C2|C3
    	
    	**/
    	
    	
    	
    	
    	    	
    	
    }
    
    
    public boolean findWin(int ID){
    	int enemy = getEnemy(ID);
    	
    	return (    			
    			checkWinOnSet(A1, A2, A3, ID) ||
    			checkWinOnSet(B1, B2, B3, ID) ||
    			checkWinOnSet(C1, C2, C3, ID) ||   			
    			checkWinOnSet(A1, B1, C1, ID) ||    			
    			checkWinOnSet(A2, B2, C2, ID) ||
    			checkWinOnSet(A3, B3, C3, ID) ||   			
    			checkWinOnSet(A1, B2, C3, ID) ||
    			checkWinOnSet(A3, A2, C1, ID)
    			);    	
    }
    
    public boolean findAndFixDanger(int ID){
    	int enemy = getEnemy(ID); 
    	
    	
    	return(    			
    			fixDanger(A1, A2, A3, enemy) ||
    			fixDanger(B1, B2, B3, enemy) ||
    			fixDanger(C1, C2, C3, enemy) ||   			
    			fixDanger(A1, B1, C1, enemy) ||    			
    			fixDanger(A2, B2, C2, enemy) ||
    			fixDanger(A3, B3, C3, enemy) ||   			
    			fixDanger(A1, B2, C3, enemy) ||
    			fixDanger(A3, A2, C1, enemy)    			
    			);
    			
    }
    
    
    
    public boolean checkWinOnSet(Cell cell1, Cell cell2, Cell cell3,int ID ){
    	
    	if (compareCellsOwner(cell1,cell2, ID) && !cell3.isOwned()){
    		cell3.setOwner(ID);
    		return true;
    	}
    	
    	
    	if (compareCellsOwner(cell1,cell3, ID) && !cell2.isOwned()){
    		cell2.setOwner(ID);
    		return true;
    	}
    	
    	
    	if (compareCellsOwner(cell2,cell3, ID) && !cell1.isOwned()){
    		cell1.setOwner(ID);
    		return true;
    	}
    	
    	return false;
    }
    
    
    
    
    
    
    
    public int getEnemy(int ID){
    	if (ID == 1){
    		return 2;
    	} else if(ID == 2){
    		return 1;
    	} else {
    		return -1;
    	}
    }
    
    
    public boolean compareCellsOwner(Cell cell1, Cell cell2, int ID){
    	
    	if ((cell1.getOwner() == ID) && (cell2.getOwner() == ID)){
    		return true;
    	}
    	
    	return false;
    }
    
    private boolean fixDanger(Cell cell1, Cell cell2, Cell cell3, int enemyID){
    	
    	if (cell1.getOwner() == enemyID && cell2.getOwner() == enemyID){
    		cell3.setOwner(getEnemy(enemyID));
    		return true;
    	}
    	
    	
    	
    	if (cell1.getOwner() == enemyID && cell3.getOwner() == enemyID){
    		cell2.setOwner(getEnemy(enemyID));
    		return true;
    	}
    	
    	
    	
    	
    	if (cell2.getOwner() == enemyID && cell3.getOwner() == enemyID){
    		cell1.setOwner(getEnemy(enemyID));
    		return true;
    	}
    	
    	
    	
    	return false;
    }
}
