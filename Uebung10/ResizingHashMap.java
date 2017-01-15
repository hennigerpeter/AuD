public class ResizingHashMap<K, V> implements HashMapInterface<K, V> {

	private int size;

	public Pair<K, V>[] buckets;

	@SuppressWarnings("unchecked")
	public ResizingHashMap(int capacity) {
		// TODO a
		buckets = new Pair[capacity];
	}

	@Override
	public int size() {
		// TODO b
		return size;
	}

	@Override
	public void insertEntry(int idx, Pair<K, V> entry) {
		// TODO c
		Pair<K, V> bucket = buckets[idx];

		if (bucket == null)
			bucket = entry;
		else {
			while (bucket.nextPairInBucket != null)
				bucket = bucket.nextPairInBucket;
			bucket.nextPairInBucket = entry;
		}
		size++;
	}

	@Override
	public int getBucketIndex(K key) {
		// TODO d
		int hash = key.hashCode() % (buckets.length);

		// TODO ungetestet
		if (hash < 0)
			hash += hash % (-buckets.length);

		return hash;
	}

	@Override
	public Pair<K, V> getEntry(K key) {
		// TODO e
		int hash = getBucketIndex(key);
		Pair<K, V> bucket = buckets[hash];

		if (bucket == null)
			return null;

		while (!bucket.key.equals(key) && bucket.nextPairInBucket != null)
			bucket = bucket.nextPairInBucket;

		return bucket;
	}

	@Override
	public V get(K key) {
		// TODO f
		Pair<K, V> bucket = getEntry(key);
		if (bucket != null)
			return bucket.getValue();

		return null;
	}

	@Override
	public boolean contains(K key) {
		// TODO g

		Pair<K, V> bucket = getEntry(key);
		if (bucket != null)
			return true;

		return false;
	}

	@Override
	public boolean put(K key, V value) {
		// TODO h

		Pair<K, V> bucket = getEntry(key);
		if (bucket != null) {
			bucket.value = value;
			return false;
		} else {
			bucket = new Pair<K, V>(key, value, null);
			insertEntry(getBucketIndex(key), bucket);
		}
		return true;
	}

	@Override
	public boolean remove(K key) {
		// TODO i
		int hash = getBucketIndex(key);
		Pair<K, V> bucket = getEntry(key);
		Pair<K, V> next = null;
		Pair<K, V> prev = buckets[hash];

		if (bucket == null)
			return false;

		// Zeiger aufs naechste ist nicht null
		// Naechstes speichern und dem vorherigen geben
		// Ansonsten wird der Nextzeiger auf null gesetzt
		if (bucket.nextPairInBucket != null)
			next = bucket.nextPairInBucket;

		// Falls das zu loeschende direkt im bucket liegt
		if (prev.getKey().equals(key))
			buckets[hash] = next;
		else {
			// Ansonsten wird das vorherige gesucht
			while (!prev.nextPairInBucket.getKey().equals(key) && prev.nextPairInBucket != null)
				prev = prev.nextPairInBucket;

			// Und das naechste uebergeben
			prev.nextPairInBucket = next;
		}
		// Groesse anpassen
		size--;

		return true;

	}

	@Override
	@SuppressWarnings("unchecked")
	public void resize(int updatedCapacity) {
		// TODO j
		Pair<K, V>[] oldbuckets = buckets;
		buckets = new Pair[updatedCapacity];
		size = 0;

		for (Pair<K, V> kv : buckets) {
			if (kv != null) {
				// Bucket fuellen
				int index = getBucketIndex(kv.getKey());
				insertEntry(index, kv);
				// moegliche Liste mitschleifen
				while (kv.nextPairInBucket != null) {
					insertEntry(index, kv.nextPairInBucket);
				}
			}
		}
	}
}
