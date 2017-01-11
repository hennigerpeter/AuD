import java.awt.List;

public class Entklammern implements EntklammernAbstrakterKnoten{
	
	public EntklammernAbstrakterKnoten entklammern(String s){
		
		if (s == "" || s == null)
			throw new IllegalArgumentException();
		
		int offeneKlammer = 0;
		String cur = "";
		for(char c:s.toCharArray()){
			
			if(c == ')'){
				if(offeneKlammer == 0)
					throw new IllegalArgumentException();
				
				offeneKlammer--;
				
				// Neues Blatt ergaenzen
			}
			
			else if(c == '('){
				offeneKlammer++;
			}
			
			else{
				
				cur = cur + c;
			}
		}
		
		
		return null;
		
	}
	
}