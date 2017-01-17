import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ResizingHashMapPublicTest {

	private <K, V> ResizingHashMap<K, V> instantiate(int size) throws Exception {
		return new ResizingHashMap<K,V>(size);
	}

	//requires replacement of init, getBucketIndex, and insertEntry
	private void fillWithSimpleEntries(HashMapInterface<String, String> map, int n) {
		for (int i = 0; i < n; i++) {
			String k = i + "", v = "value" + i;
			Pair<String, String> entry = new Pair<>(k, v, null);
			map.insertEntry(map.getBucketIndex(k), entry);
		}
	}

	//requires replacement of init, getBucketIndex, and insertEntry
	private void putKeyStringEntry(HashMapInterface<Key, String> map, Key key, String value) {
		Pair<Key, String> entry = new Pair<>(key, value, null);
		map.insertEntry(map.getBucketIndex(entry.getKey()), entry);
	}

	@Test(timeout = 100)
	public void mainTestInitialBucketSize() throws Exception {
		ResizingHashMap<Integer, String> hashMap = new ResizingHashMap<Integer, String>(11);

		assertEquals("Number of buckets does not match (await 11 got " + hashMap.buckets.length + ")", 11, hashMap.buckets.length);
	}

	@Test(timeout = 100)
	public void mainTestInitialSizeIsZero() throws Exception {
		ResizingHashMap<Integer, String> hashMap = new ResizingHashMap<Integer, String>(11);

		assertEquals("Initial size wrong. HashMap is not empty", 0, hashMap.size());
	}

	@Test(timeout = 100)
	public void mainTestInsertEntry() throws Exception {
		ResizingHashMap<Integer, String> hashMap = new ResizingHashMap<Integer, String>(11);

		Pair<Integer, String> e1 = new Pair<Integer, String>(1, "Test1", null);
		hashMap.insertEntry(1, e1);
		assertEquals("Size wrong ", 1, hashMap.size());
		assertEquals("Pair not found in expected bucket with index 1", e1, hashMap.buckets[1]);
	}

	@Test(timeout = 100)
	public void mainTestBucketIndices() throws Exception {
		ResizingHashMap<Integer, String> hashMap = new ResizingHashMap<Integer, String>(11);

		// Calculation of bucket indices
		assertEquals("Wrong bucket index for given key", 2, hashMap.getBucketIndex(2));
		assertEquals("Wrong bucket index for given key", 8, hashMap.getBucketIndex(8));
		assertEquals("Wrong bucket index for given key", 10, hashMap.getBucketIndex(10));
	}

	@Test(timeout = 100)
	public void testSimpleBucketIndex() throws Exception {
		ResizingHashMap<Key, Object> map = instantiate(5);
		int hash = 1;
		assertEquals("Returned wrong index for storing key in buckets", hash, map.getBucketIndex(new Key(hash, "")));
	}

	@Test(timeout = 100)
	public void mainTestGetEntry() throws Exception {
		ResizingHashMap<Integer, String> hashMap = new ResizingHashMap<Integer, String>(11);
		Pair<Integer, String> e1 = new Pair<Integer, String>(3, "Test1", null);
		hashMap.insertEntry(3, e1);

		// Get Pair Object
		Pair<Integer, String> q = hashMap.getEntry(3);

		assertEquals("GetEntry returned unexpected object", e1, q);
	}

	@Test(timeout = 100)
	public void mainTestGet() throws Exception {
		ResizingHashMap<Integer, String> hashMap = new ResizingHashMap<Integer, String>(11);
		Pair<Integer, String> e2 = new Pair<Integer, String>(9, "Test2", null);

		hashMap.insertEntry(9, e2);
		String t2 = hashMap.get(9);

		assertEquals("Get did not return recently inserted entry", "Test2", t2);
	}

	@Test(timeout = 100)
	public void mainTestContains() throws Exception {
		ResizingHashMap<Integer, String> hashMap = new ResizingHashMap<Integer, String>(11);
		Pair<Integer, String> e3 = new Pair<Integer, String>(8, "Test3", null);
		hashMap.insertEntry(8, e3);

		assertEquals("GetEntry did return wrong entry", e3, hashMap.getEntry(8));
		assertTrue("Contains wrong for recently added entry", hashMap.contains(8));
		assertFalse("Contains was true for non-existing entry", hashMap.contains(16));
	}

	@Test(timeout = 100)
	public void mainTestPut() throws Exception {
		ResizingHashMap<Integer, String> hashMap = new ResizingHashMap<Integer, String>(11);

		// Add KV-Pair
		Pair<Integer, String> e1 = new Pair<Integer, String>(1, "Test1", null);
		hashMap.insertEntry(1, e1);
		// Get
		Pair<Integer, String> e2 = new Pair<Integer, String>(9, "Test2", null);
		hashMap.insertEntry(9, e2);
		//contains
		Pair<Integer, String> e3 = new Pair<Integer, String>(8, "Test3", null);
		hashMap.insertEntry(8, e3);

		assertEquals("Size wrong before put", 3, hashMap.size());

		hashMap.put(3, "Test");

		assertEquals("Size wrong after put", 4, hashMap.size());
		assertTrue("Contains wrong for recently added entry", hashMap.contains(3));
		String t = hashMap.get(3);
		assertEquals("Get wrong for recently added entry", "Test", t);
	}

	@Test(timeout = 100)
	public void mainTestRemoveFirstPart() throws Exception {
		ResizingHashMap<Integer, String> hashMap2 = new ResizingHashMap<Integer, String>(11);

		Pair<Integer, String> e1 = new Pair<Integer, String>(1, "Test1", null);
		Pair<Integer, String> e2 = new Pair<Integer, String>(9, "Test2", null);
		Pair<Integer, String> e3 = new Pair<Integer, String>(8, "Test3", null);

		hashMap2.insertEntry(1, e1);
		hashMap2.insertEntry(9, e2);
		hashMap2.insertEntry(8, e3);

		assertEquals("Size wrong", 3, hashMap2.size());

		assertTrue("Did you really remove the entry?", hashMap2.remove(1));
		assertEquals("Size wrong", 2, hashMap2.size());
	}

	@Test(timeout = 100)
	public void mainTestRemoveSecondPart() throws Exception {
		ResizingHashMap<Integer, String> hashMap2 = new ResizingHashMap<Integer, String>(11);

		Pair<Integer, String> e2 = new Pair<Integer, String>(9, "Test2", null);
		Pair<Integer, String> e3 = new Pair<Integer, String>(8, "Test3", null);
		Pair<Integer, String> e4 = new Pair<Integer, String>(2, "Test4", null);
		Pair<Integer, String> e5 = new Pair<Integer, String>(10, "Test5", null);
		Pair<Integer, String> e6 = new Pair<Integer, String>(7, "Test6", null);

		hashMap2.insertEntry(9, e2);
		hashMap2.insertEntry(8, e3);

		assertFalse("Contains was true for non-existing entry", hashMap2.contains(2));
		hashMap2.insertEntry(2, e4);
		assertTrue("Contains wrong for recently added entry", hashMap2.contains(2));

		hashMap2.insertEntry(10, e5);
		hashMap2.insertEntry(7, e6);

		assertTrue("Return value of remove wrong", hashMap2.remove(8));
		assertEquals("Size wrong after remove", 4, hashMap2.size());
	}

	@Test(timeout = 100)
	public void mainTestResize() throws Exception {
		ResizingHashMap<Integer, String> hashMap3 = new ResizingHashMap<Integer, String>(11);

		Pair<Integer, String> e1 = new Pair<Integer, String>(1, "Test1", null);
		Pair<Integer, String> e2 = new Pair<Integer, String>(9, "Test2", null);
		Pair<Integer, String> e3 = new Pair<Integer, String>(8, "Test3", null);
		Pair<Integer, String> e4 = new Pair<Integer, String>(2, "Test4", null);
		Pair<Integer, String> e5 = new Pair<Integer, String>(10, "Test5", null);
		Pair<Integer, String> e6 = new Pair<Integer, String>(7, "Test6", null);
		hashMap3.insertEntry(1, e1);
		hashMap3.insertEntry(9, e2);
		hashMap3.insertEntry(8, e3);
		hashMap3.insertEntry(2, e4);
		hashMap3.insertEntry(10, e5);
		hashMap3.insertEntry(7, e6);

		hashMap3.resize(19);
		assertEquals("Size wrong", 6, hashMap3.size());
		assertEquals("Wrong number of buckets after resize", 19, hashMap3.buckets.length);
		assertEquals("Wrong bucket index for given key", 4, hashMap3.getBucketIndex(4));
		assertEquals("Wrong bucket index for given key", 8, hashMap3.getBucketIndex(8));

	}


	// =========================================================================

	private static final class Key {
		private int hash;
		private String key;

		public Key(int hash, String key) {
			this.hash = hash;
			this.key = key;
		}

		@Override
		public int hashCode() {
			return hash;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Key other = (Key) obj;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}
	}

	public static void main(String args[]) {
		// to compile on command line: javac -cp .:/usr/share/java/junit4.jar *.java
		// to run on command line: java -cp .:/usr/share/java/junit4.jar ResizingHashMapPublicTest

		// starts junit runner - don't try to understand!
		org.junit.runner.JUnitCore.main(new Object() { }.getClass().getEnclosingClass().getSimpleName());
	}
}
