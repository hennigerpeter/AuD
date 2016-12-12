
public class ONotation {
	
	public static char f(int x) {
		char h = 'h';
		
		int counter = 0;
		
		for (long i = h; i-- > ++i; x--) {
		h++;
		}
		return h;
	}
	
	
	
	public static void main (String[] args){
		
		char ret = f(5000);
		
	}
	
}