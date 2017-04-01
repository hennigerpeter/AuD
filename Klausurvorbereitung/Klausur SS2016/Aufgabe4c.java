
public class Aufgabe4c {

	public void floydifi(double[][] g) {
		int n = g.length;
		// durchlaufe alle Knoten vi und vj:

		// Zur Initialisierung von G0 = G
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < n; k++) {
				g[i][k] = g[i][k];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					if (g[j][i] + g[i][k] < g[j][k]) { 
						g[j][k] = g[j][i] + g[i][k];
					}
				}
			}
		}
	}

}
