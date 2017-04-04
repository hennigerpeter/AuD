
public class LangtonAntJava {

	boolean[][] raster = new boolean[4711][4242];
	int x = 666, y = 666, d = 0; 
	
	void step(){
		
		if (!raster[x][y]){
			// raster ist weiß
			d = (d+3) % 4;
			raster[x][y] = true;
			
			switch (d){
				case 0: y++; break;
				case 1: x--; break;
				case 2: y--; break;
				case 3: x++; break;
			}
			
			
		} else{
			// raster ist schwarz
			d = (d+1) % 4;
			raster[x][y] = false;
			
			switch (d){
			case 0: y++; break;
			case 1: x--; break;
			case 2: y--; break;
			case 3: x++; break;
			
		}
		}
		
	}
	
}
