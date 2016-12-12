public class AwesomWeapon {
	// TODO: Hier die noetigen Datenstrukturen anlegen
	private int damage;
	private int wear;
	
	
	public AwesomWeapon(int damage, int wear) {
		// TODO
		setDamage(damage);
		setWear(wear);
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

	public int getWear() {
		// TODO
		// Gibt den aktuellen Wert von wear zurueck.
		return this.wear;
	}

	public void setWear(int wear) {
		// TODO
		// Setzt wear auf den uebergebenen Wert. Positive wie negative Werte
		// sind moeglich.
		this.wear = wear;
	}

	public int attack() {
		// TODO
		// Die Methode prueft zunaechst, ob wear groesser 0 ist. Ist die Waffe
		// aufgebraucht, so soll 0 zurueckgegeben werden.
		// Falls die Waffe noch funktioniert soll wear um 1 reduziert werden und
		// damage zurueckgegeben werden.
		if(getWear() <= 0)
			return 0;
		
		setWear(getWear() - 1);
		return getDamage();
	}

}
