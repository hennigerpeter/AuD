import java.util.*;

public abstract class EntklammernAbstrakterKnoten implements List<EntklammernAbstrakterKnoten>{
	
	protected List<EntklammernAbstrakterKnoten> kinder;
	
	public List<EntklammernAbstrakterKnoten> kinder(){
		return kinder;
	};
}