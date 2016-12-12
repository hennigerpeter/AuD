public class StarTrekLift{
	
	// attr
	public String name;
	private TurboShaft[] turboShaft;
	private Control control;
	
	// constr
	public StarTrekLift(String name, TurboShaft[] turboshafts, Control control){
		
		// attr versorgen
		this.name = name;
		
		// Bestandtteile erstellen
		this.turboShaft = turboshafts.clone();
		this.control = control;
	}
	
	// meth
	
}

class Control{
	
	// attr
	protected TurboShaft[] turboShaft;
	
	// constr
	public Control(TurboShaft[] turboshafts){
		
		this.turboShaft = turboshafts.clone();
	}
	
}

class TurboShaft{
	
	// attr
	public String name;
	private Cabine cabine;
	Motor motor;
	protected Deck[] decks;
	
	// constr
	public TurboShaft(String name, Deck[] decks){
		
		this.name = name;
		
	}
	
	// meth
	public void goTo(Deck destination){
		cabine.position = destination;
	}
	
	public Deck currentPosition(){

		return cabine.position;
	}
	
	public Deck[] getReachableDecks(){
		
		return cabine.destinations;
	}
	
}

class Deck{
	
	//attr
	private String name;
	private boolean request;
	
	// constr
	private Deck(String name){
		
		this.name = name;
	}
	
	public Deck(){
		this.name = "basic constructor";
	}
}

class Motor{
	
	// attr
	public static String MOTOR_TYPE = "Linear induction";
	
	// constr
	
	// meth
	public void start(int direction, float speed){
		
	}
	
	public void stop(){
		
	}
}

class Cabine{
	
	// attr
	public boolean doorState;
	public Deck position;
	public Deck[] destinations;
	
	// constr
	
	// meth
	public void changeDoorState(boolean doorState){
		this.doorState = doorState;
	}
}