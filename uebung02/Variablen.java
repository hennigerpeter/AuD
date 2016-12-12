import java.util.Arrays;

public class Variablen {
	// TODO: declare a constant named "FOO_BAR" with a value of -123.456 * 10^(-89)
private static final double FOO_BAR = -123.456 * Math.pow(10, -89);

	// TODO: declare an enumeration named "Months" containing the
	// english names in CAPITAL_LETTERS (!) of all the 12 months of the year in the correct order
    private static enum Months { JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER };

	public static char[] someCharacters() {
		// TODO: declare, fill and return an 1-dimensional
		// array containing the ASCII-letters A to Z (capital letters)
    char[] someChars = { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z' };
		return someChars;
	}

	public static char[][] someMoreCharacters() {
		// TODO: declare, fill and return a 2-dimensional array containing
		// 1) the values (!) 0 to 25 in the first row,
		// 2) the ASCII-letters A to Z (capital letters) in the second row,
		// 3) the ASCII-characters (!) 0 to 9, than 0 to 9 again and finally 0 to 5 in the third row
		// 4) the ASCII-letters a to z (non-capital letters) in the fourth row,
    char[][] myarray = { { 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25 }, 
                         { 'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'},
                         { '0','1','2','3','4','5','6','7','8','9','0','1','2','3','4','5','6','7','8','9','0','1','2','3','4','5'},
                         { 'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'} };
    
		return myarray;
	}

	public static int[][][] theCube() {
		// TODO: declare, fill and return a 3-dimensional array
		// of size 3x3x3 (try to imagine a http://en.wikipedia.org/wiki/Rubik's_Cube)
		// containing only integer numbers such that
		// the value at [x][y][z] == (x+1)*100+(y+1)*10+(z+1)
		// (e.g. cube[2][1][0] == 321)
    
    int[][][] cube = new int[3][3][3];
    
    for (int z = 0; z <= 2; z++)
    {
      for (int y = 0; y <= 2; y++)
      {
        for (int x = 0; x <= 2; x++)
        {
          cube[x][y][z] = (x+1)*100+(y+1)*10+(z+1);
        }
      } 
    }
    
    return cube;
	}

	// after creating the constant and the  enum, uncomment the code by
	// removing the two indicated lines
	// DON'T change anything else
	public static void main(String[] args) {
/* TODO: delete this line ...*/
		System.out.println("-----");
		System.out.println(Variablen.FOO_BAR);
		System.out.println("-----");
		System.out.println(Months.OCTOBER);
		System.out.println("-----");
/*... and this line */
		System.out.println(Arrays.toString(someCharacters()));
		System.out.println("-----");
		// The output of this part will look broken/wrong
		for (char[] r : someMoreCharacters()) {
			System.out.println(Arrays.toString(r));
		}
		System.out.println("-----");
		for (int[][] plane : theCube()) {
			for (int[] row : plane) {
				System.out.print(Arrays.toString(row));
			}
			System.out.println();
		}
	}
}
