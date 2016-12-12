public class Vererbung{
	
	public static void main(String[] args){
		
		Trinkbar tm = new MilchShake();

		System.out.println("#1");
		System.out.println(tm.menge);
		
		Essbar em = new MilchShake();
		
		System.out.println("#2");
		System.out.println(em.verdauen(3));

		System.out.println("#3");
		System.out.println(em.menge);

		ObstGericht om = new MilchShake();

		System.out.println("#4");
		System.out.println(om.verdauen(4));

		System.out.println("#5");
		System.out.println(om.menge);
		
		System.out.println("#6");
		System.out.println(om.schaelen(Integer.MAX_VALUE + 123));

		System.out.println("#7");
		System.out.println(om.schaelen("Kiwi"));
		
		MilchShake mm = new MilchShake();
		
		System.out.println("#8");
		System.out.println(mm.menge);
		
		Trinkbar tv = new Vodka();
		
		System.out.println("#9");
		System.out.println(tv.verdauen(1));
		
		System.out.println("#10");
		System.out.println(tm.verdauen(2));
		
		
	}
}

interface Trinkbar {
	long menge = 42L;
	
	String verdauen(long drinks);
	
}

interface Essbar {
	String menge = "0.815 kg";
	
	String verdauen(int portionen);
	
}

abstract class ObstGericht implements Essbar{
	int bananen = 4711;
	
	public String verdauen(int portionen){
		return Integer.toString(bananen);
	}
	
	public static String schaelen(int aepfel){
		return "Apfelringe";
	}
	
	public String schaelen(String birnen){
		return "Birnenringe";
	}
	
}

class MilchShake extends ObstGericht implements Trinkbar{
	static String menge = "1 Becher";
	String bananen = "Hola Chica";
	private boolean lactosefrei = false;
	
	public String verdauen(long portionen){
		return Long.toString(portionen);
	}
	
	public static String schaelen(long aepfel){
		return "Apfelmus";
	}
	
	public String schaelen(String birnen){
		return "Birnenmus";
	}
}

class Vodka implements Trinkbar{
	String menge = "3 Flaschen";
	
	public String verdauen(int stamperl){
		return "dauert mehrere Stunden";
	}
	
	public String verdauen(long humpen){
		return "ist unverdaulich";
	}
	
}