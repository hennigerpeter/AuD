public class GameOfDice {

	// determines the winner
	// input is an Array containing the values as Strings
	// returns 0 for draw
	// returns 1 for player 1
	// returns 2 for player 2
	// returns -1 if the array is too short or too long
	public static int game(String args[]) {
		// TODO: implement logic here
    
    if (args.length != 4)
      return -1;      
    
    int spieler1 = Integer.parseInt(args[0]) + Integer.parseInt(args[1]);
    int spieler2 = Integer.parseInt(args[2]) + Integer.parseInt(args[3]);
    
    if (spieler1 > spieler2)
      return 1;
    if (spieler2 > spieler1)
      return 2;
    if (spieler1 == spieler2)
      return 0;
    
    
		return -1;
	}

	// DON'T modify this part
	public static void main(String args[]) {
		int e = game(args);
		if (e == 0) {
			System.out.println("Draw");
		} else if (e == 1) {
			System.out.println("Player 1 won");
		} else if (e ==  2) {
			System.out.println("Player 2 won");
		} else {
			System.out.println("Game Error");
		}
	}
}
