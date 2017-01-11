import java.util.List;

public abstract class EntklammernAbstrakterKnoten implements List<Object>{
	
	protected List<EntklammernAbstrakterKnoten> kinder;
	
	public List<EntklammernAbstrakterKnoten> kinder(){
		return kinder;
	};
}