// PLEASE KEEP IN MIND:
// Place your new/additional code immediately below the line marked "// TODO:"
// and/or replace the expression after the return statement if necessary.
// Do not change any given code above or below those lines!
// For higher computational precision perform all multiplications before divisions!

public class Geometrie {
	// computes and returns the circumference of a
	// regular polygon with n edges of length a
	public static double umfangRegelmaessigesVieleck(int n, double a) {
		// TODO:
    // Der Umfang eines regelmaessigen Vielecks ist das n-fache der Seitenlaenge: U = n*a

		double seitenAnzahl = (double)n;
		
		if (seitenAnzahl >= 0 && a >= 0.0)
		{
			return seitenAnzahl * a;
		}
			
		// args < 0
		else
			return -1.0;		
    }

	// computes and returns the circumference of a circle with radius r
	// (hint: use Math.PI for a precise value of PI)
	public static double umfangKreis(double r) {
		// TODO:
		// U = 2*pi*r
		if (r >= 0.0)
		{
			return 2.0*Math.PI*r;
		}
		else
		{
			return -1.0;
		}
	}

	// computes and returns the surface area of a trapezium (aka trapezoid)
	// with base edge a, opposite edge c, and height h
	public static double flaecheTrapez(double a, double c, double h) {
		// TODO:
		// A = 0.5*(a+c)*h
    if (a>=0.0 && c>=0.0 && h>=0.0)
      return 0.5 * (a+c)*h;
    else
      return -1.0;
		
	}

	// computes and returns the volume of a square pyramid
	// with base length a and height h
	public static double volumenPyramide(double a, double h) {
		// TODO:
		// V = (G*h)/3; V = (a*a)/3
    if (a>=0.0 && h>=0.0)
      return (a*a*h)/3;
    else 
      return -1.0;
	}

	// computes and returns the surface are of a square pyramid
	// with base length a and height h
	// (hint: use Math.sqrt(x) to compute the square root of x)
	public static double flaechePyramide(double a, double h) {
		// TODO:
		// F = G+M; F = G+(4.0*(0.5*a*hd)); hd = Wurzel(0.5*a+h) (Pythagoras)
		if (a>=0.0 && h>=0.0)
    {
      double hoeheDreieck = Math.sqrt(0.5*a+h);
      double mantelflaeche = 4.0*(0.5*a*hoeheDreieck);
      double grundflaeche = a*a;
      return mantelflaeche + grundflaeche;
    }
    else
      return -1.0;
	}

	// computes and returns the volume of a sphere with radius r
	public static double volumenKugel(double r) {
		// TODO:
		// V = (Math.PI*r*r*r)*4.0/3.0
    if (r>= 0.0)
      return (Math.PI*r*r*r)*4.0/3.0;
    else
      return -1.0;
	}

	// computes and returns the surface area of a closed irregular polygon
	// with consecutive connected nodes at (xi, yi)
	// (hint: use Math.abs(x) to compute the absolute value of x, i.e. |x|)
	public static double flaecheVieleck8(double x0, double y0, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4, double x5, double y5, double x6, double y6, double x7, double y7) {
		// TODO:
		// http://www.mathopenref.com/coordpolygonarea.html
		double flaeche = -1;
		double flaeche = Math.abs(((x0*y1-y0*x1)+(x1*y2-y1*x2+(x2*y3-y2*x3)+(x3*y4-y3*x4)+(x4*y5-y4*x5)+(x5*y6-y5*x6)+(x6*y7-y6*x7)+(x7*y0-y7*x0)))/2);


		return flaeche;
	}

	// classifies a triangle by the given sides a, b and c
	// and returns one of the values 0 to 3 as follows:
	// 0 : if a,b,c are illegal, i.e. do not form a valid triangle
	// 1 : if triangle is scalene
	// 2 : if triangle is isosceles
	// 3 : if triangle is equilateral
	public static int typDesDreiecks(long a, long b, long c) {
		// TODO:
		// 1 : if triangle is scalene (ungleichseitig)
		// 2 : if triangle is isosceles (gleichschenkelig)
		// 3 : if triangle is equilateral (gleichseitig)
    if (a<0 || b<0 || c<0)
      return 0;
		else if (a+b<c || a+c<b || b+c<a)
			return 0;
    else if (a == b || a == c || b == c)
			return 2;
		else if (a == b && b == c)
			return 3;
		
		else
			return 1;
			
	}
}