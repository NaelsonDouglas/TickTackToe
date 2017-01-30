package IA2.TicTacToe;

import java.awt.PageAttributes.PrintQualityType;
import java.lang.reflect.Array;
import java.util.Scanner;

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
    	//B2.setOwner(2);
    	//A3.setOwner(2);
    	
    	while(true){
    		printTable();
    		userInput();
    		play();
    		printTable();
    		
    		
    
    	}
    	
    	
    	    	
    	
    }
    
    public static boolean userInput(){
    	Scanner scan = new Scanner(System.in);
    	
    	
    	boolean valiInput = false;
    	
    	while(!valiInput){
    		System.out.println("Digite a célula que você quer jogar: ");
    		String input = scan.nextLine();
    	    	
    	
	    	if (input.equals("A1")){
	    		valiInput = tryCell(A1);    		
	    	} else if (input.equals("A2")){
	    		valiInput = tryCell(A2);    		
	    	} else if (input.equals("A3")){
	    		valiInput = tryCell(A3);    		
	    	} else if (input.equals("B1")){
	    		valiInput =  tryCell(B1);    		
	    	} else if (input.equals("B2")){
	    		valiInput =  tryCell(B2);    		
	    	} else if (input.equals("B3")){
	    		valiInput =  tryCell(B3);    		
	    	} else if (input.equals("C1")){
	    		valiInput = tryCell(C1);    		
	    	} else if (input.equals("C2")){
	    		valiInput = tryCell(C2);    		
	    	} else if (input.equals("C3")){
	    		valiInput = tryCell(C3);    		
	    	} 
    	
	    		
    	}
    	return true;
    	
    }
    public static void reset(){
    	
    	printTable();
    	System.out.println("Fim de jogo\n");
    	A1 = new Cell();
    	A2 = new Cell();
    	A3 = new Cell();
    	B1 = new Cell();
    	B2 = new Cell();
    	B3 = new Cell();
    	C1 = new Cell();
    	C2 = new Cell();
    	C3 = new Cell();
    	
    }
    
    private static boolean tryCell(Cell cell){
    	
    	if (!cell.isOwned()){
			cell.setOwner(1);
			return true;
		} else{
			System.out.println("Esta casa já está ocupada\n");
		}
    	return false;
    }
    
    public static void play(){
    	if(findWin(2) || findAndFixDanger(2) ||  fillASet(2));
    }
    
    public static void printTable(){
    	System.out.println(A1.getOwner()+"|"+A2.getOwner()+"|"+A3.getOwner());
    	System.out.println(B1.getOwner()+"|"+B2.getOwner()+"|"+B3.getOwner());
    	System.out.println(C1.getOwner()+"|"+C2.getOwner()+"|"+C3.getOwner());
    	System.out.println("\n");
    }
    
    
    
    public static boolean findWin(int ID){
    	int enemy = getEnemy(ID);
    	
    	    			
    			boolean won = 
    			checkWinOnSet(A1, A2, A3, ID) ||
    			checkWinOnSet(B1, B2, B3, ID) ||
    			checkWinOnSet(C1, C2, C3, ID) ||   	
    			
    			checkWinOnSet(A1, B1, C1, ID) ||    			
    			checkWinOnSet(A2, B2, C2, ID) ||
    			checkWinOnSet(A3, B3, C3, ID) ||
    			
    			checkWinOnSet(A1, B2, C3, ID) ||
    			checkWinOnSet(A3, B2, C1, ID);
    			
    			if (won){
    				reset();
    				return true;
    			}
    			System.out.println("Não encontrou vitória\n");
    			return false;
    			
    			
    }
    
    public static boolean findAndFixDanger(int ID){
    	int enemy = 1; 
    	
    	
    	return(    			
    			fixDanger(A1, A2, A3, enemy) ||
    			fixDanger(B1, B2, B3, enemy) ||
    			fixDanger(C1, C2, C3, enemy) ||
    			
    			fixDanger(A1, B1, C1, enemy) ||    			
    			fixDanger(A2, B2, C2, enemy) ||
    			fixDanger(A3, B3, C3, enemy) ||  
    			
    			fixDanger(A1, B2, C3, enemy) ||
    			fixDanger(A3, B2, C1, enemy)    			
    			);
    			
    }
    
    public static boolean fillASet(int ID){
    	
    	
    				
    			boolean areFreeSets = 
    			fillEmptySet(A1, A2, A3, ID) ||
    			fillEmptySet(B1, B2, B3, ID) ||
    			fillEmptySet(C1, C2, C3, ID) ||  
    			
    			fillEmptySet(A1, B1, C1, ID) ||    			
    			fillEmptySet(A2, B2, C2, ID) ||
    			fillEmptySet(A3, B3, C3, ID) ||
    			
    			fillEmptySet(A1, B2, C3, ID) ||
    			fillEmptySet(A3, A2, C1, ID);
    			
    			
    			if (!areFreeSets){
    				System.out.println("Fill any");
    				fillAnySet(ID);    				
    			}
    			
    			
    			return true;
    }
    
    private static void fillAnySet(int ID){
    	
    	if (!A1.isOwned()){
    		A1.setOwner(ID);
    	} else if(!A2.isOwned()){
    		A2.setOwner(ID);
    	} else if(!A3.isOwned()){
    		A3.setOwner(ID);
    	}else if(!B1.isOwned()){
    		B1.setOwner(ID);
    	}else if(!B2.isOwned()){
    		B2.setOwner(ID);
    	}else if(!B3.isOwned()){
    		B3.setOwner(ID);
    	}else if(!C1.isOwned()){
    		C1.setOwner(ID);
    	}else if(!C2.isOwned()){
    		C2.setOwner(ID);
    	}else if(!C3.isOwned()){
    		C3.setOwner(ID);
    	}
    	
    }
    private static boolean fillEmptySet(Cell cell1, Cell cell2, Cell cell3, int ID){
    	
    	if(cell1.getOwner()==0 && cell2.getOwner()==0 && cell3.getOwner()==0){
    		cell2.setOwner(ID);
    		return true;
    	}
    	return false;  	    	
    }
    
    
    
    public static boolean checkWinOnSet(Cell cell1, Cell cell2, Cell cell3,int ID ){
    	
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
    
    
    
    
    
    
    
    public static int getEnemy(int ID){
    	if (ID == 1){
    		return 2;
    	} else if(ID == 2){
    		return 1;
    	} else {
    		return -1;
    	}
    }
    
    
    public static boolean compareCellsOwner(Cell cell1, Cell cell2, int ID){
    	
    	if ((cell1.getOwner() == ID) && (cell2.getOwner() == ID)){
    		return true;
    	}
    	
    	return false;
    }
    
    private static boolean fixDanger(Cell cell1, Cell cell2, Cell cell3, int enemyID){
    	
    	if (cell1.getOwner() == 1 && cell2.getOwner() == 1){
    		if (!cell3.isOwned()){
    			cell3.setOwner(2);
    			return true;
    		}
    	}
    	
    	
    	
    	if (cell1.getOwner() == 1 && cell3.getOwner() == 1){
    	
    		    	
    		if (!cell2.isOwned()){
    			cell2.setOwner(2);	
    			return true;
    		}
    	}
    	
    	
    	
    	
    	if (cell2.getOwner() == 1 && cell3.getOwner() == 1){
    		
    		if (!cell1.isOwned()){
    			cell1.setOwner(2);
    			return true;
    		}
    	}
    	
    	
    	
    	return false;
    }
}
