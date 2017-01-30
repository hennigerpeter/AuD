import java.util.ArrayList;

public class NameSorter {

	/**
	 * Returns the character at position <code>pos</code> in <code>str</code>, if it exists.
	 * Otherwise, a character is returned so that <code>str</code> is sorted before other strings that
	 * have  <code>str</code> as a prefix, but are longer.
	 */
	public static char getCharOrDefault(String str, int pos) {
		//TODO!
		return '~';
	}
	/**
	 * Performs one step of Bucket-Sort. Sorts every entry of <code>list</code>
	 * into one of 53 bucket (No character at position, A-Z and a-z), depending on the 
	 * character at position <code>charPos</code> in either <code>name</code> or 
	 * <code>surname</code> in * the entry (which one is used depends on the value 
	 * of <code>useFirstName</code>).
	 */
	public static ArrayList<NameEntry> radixOneStep(
			ArrayList<NameEntry> list, boolean useFirstName, int charPos) {
		
		//TODO!
		return null;
	}
	
	/**
	 * Sorts the supplied list, first by name, then by surname
	 */
	public static ArrayList<NameEntry> sortEntries(ArrayList<NameEntry> in) {
		//TODO!
		return null;
	}
	
}
