public class Objekt { 
	private char x; 
	private int y;
	
	Objekt(char x, int y) { 
		this.x = x; 
		this.y = y; 
		}
	
	public Objekt vermenge(Objekt x) { 
		this.x = x.x; 
		this.y += x.y; 
		return this; 
		}
	
	public Objekt vermische(Objekt y) { 
		return new Objekt(x, y.y); 
		}
	
	public void kopiere(Objekt z) { 
		z = this; 
		}
	
	public void aendere(char x) { 
		this.x = x; 
		}
	
	
	public static void main(String[] args) { 
		Objekt x, y = null, z = null; x = new Objekt('A', 1); 
		/** 0 **/ 
		y = new Objekt('B', 13); 
		
		/** 1 **/ 
		z = x.vermenge(y); 
		
		/** 2 **/ 
		x = new Objekt('C', 42); 
		
		/** 3 **/ 
		y = z; 
		
		/** 4 **/ 
		z = z.vermische(x); 
		
		/** 5 **/ 
		y = (new Objekt('D', 666)).vermenge(y); 
		
		/** 6 **/ 
		x.kopiere(y); 
		
		/** 7 **/ 
		z = x = y.vermische(z); 
		
		/** 8 **/ 
		z.aendere('X'); 
		
		/** 9 **/ 
		y = x.vermische(y.vermenge(z.vermische(y))); 
		
		/** 10 **/ }
}