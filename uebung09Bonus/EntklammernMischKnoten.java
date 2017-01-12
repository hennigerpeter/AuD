import java.util.*;

public class EntklammernMischKnoten extends EntklammernAbstrakterKnoten {

	private List<EntklammernAbstrakterKnoten> kinder = new LinkedList<>();
	public EntklammernMischKnoten(List<EntklammernAbstrakterKnoten> kinder) {
		this.kinder = kinder;
	}
	
	public EntklammernMischKnoten(){};

	public String toString() {

		String res = "";
		for (EntklammernAbstrakterKnoten abs : kinder) {
			res = res + abs.toString();
		}
		return res;
	}

	@Override
	public boolean add(EntklammernAbstrakterKnoten e) {
		// TODO Auto-generated method stub

		try {
			kinder.add(e);
			return true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
		}

		return false;

	}

	@Override
	public void add(int index, EntklammernAbstrakterKnoten element) {
		kinder.add(index, element);

	}

	@Override
	public boolean addAll(Collection<? extends EntklammernAbstrakterKnoten> c) {
		try {
			kinder.addAll(c);
			return true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends EntklammernAbstrakterKnoten> c) {
		try {
			kinder.addAll(index, c);
			return true;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			// e1.printStackTrace();
		}

		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntklammernAbstrakterKnoten get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<EntklammernAbstrakterKnoten> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<EntklammernAbstrakterKnoten> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<EntklammernAbstrakterKnoten> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntklammernAbstrakterKnoten remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EntklammernAbstrakterKnoten set(int index, EntklammernAbstrakterKnoten element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<EntklammernAbstrakterKnoten> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}