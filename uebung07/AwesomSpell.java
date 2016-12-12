public class AwesomSpell {
	// TODO: Hier die noetigen Datenstrukturen anlegen
	private int damage;

	public AwesomSpell(int damage) {
		// TODO
		setDamage(damage);
	}

	public int getCost() {
		// TODO
		// Gibt die Kosten des spell zurueck. Diese belaufen sich auf das
		// Zehnfache der damage.
		return getDamage()*10;
	}

	public int getDamage() {
		// TODO
		// Gibt den aktuellen Wert von damage zurueck.
		return this.damage;
	}

	public void setDamage(int damage) {
		// TODO
		// Setzt damage auf den uebergebenen Wert. Positive wie negative Werte
		// sind moeglich.
		this.damage = damage;
	}

}
