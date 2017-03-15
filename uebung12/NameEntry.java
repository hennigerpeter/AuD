/**
 * Just a helper class, everything is public here
 */
public class NameEntry {
	public final String firstName;
	public final String surname;

	public NameEntry(String surname, String firstName) {
		this.surname = surname;
		this.firstName = firstName;

	}
	@Override
	public String toString() {
		return surname + ", " + firstName;
	}
}
