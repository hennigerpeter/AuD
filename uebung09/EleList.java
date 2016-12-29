public class EleList<T> {
	
	private T head;
	private static EleList<?> tail;
	
	
	// erzeugt eine neue und zunaechst leere Elementare Liste 
	private EleList<?> create(){
		
		return new EleList<>();
		
	}
	
	// fuegt ein neues Element vorne in die Liste ein
	public static EleList<?> add(EleList<?> list, T head){

		list.tail = list;
		list.head = head;
		return list;
		
	}
	
	// gibt das erste (vorderste) Element der Liste zurueck
	public T head(EleList<?> list){
		
		return this.head;
		
	}
	
	// gibt die Restliste ohne das erste Element zurueck
	public static EleList<?> tail(EleList<?> list){
		
		return list.tail;
		
	}
	
}