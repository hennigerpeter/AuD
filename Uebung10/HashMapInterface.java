/**
 * An interface for a simple hash map.
 *
 * @param <K>
 *            The data type of a key.
 * @param <V>
 *            The data type of a value.
 */
public interface HashMapInterface<K,V> {

    /**
     * Return the number of key-value pairs stored in the map.
     * @return Number of stored entries.
     */
    public int size();

    /**
     * Inserts the given key-value mapping into the bucket with the given index
     * and increases the size(). Does not check whether a mapping for the key
     * of the given entry already exists.
     *
     * @param idx Index of the bucket for the given mapping.
     * @param entry The new mapping to insert at the given index.
     */
    public void insertEntry(int idx, Pair<K, V> entry);

    /**
     * Establish a key-value mapping. If a mapping with the same key already
     * exists, the value of the existing mapping is updated with the specified
     * value. Otherwise a new mapping is created and inserted.
     *
     * @param key
     *            The key of the mapping.
     * @param value
     *            The value of the mapping.
     * @return Returns true if a new mapping was added. Returns false if the mapping already exists or the
     *         value of an existing mapping was only updated.
     * @throws IllegalArgumentException
     *             Thrown if the specified key is null.
     */
    public boolean put(K key, V value);

    /**
     * Calculates the index of the bucket for the given key.
     *
     * @param key
     *          Potential key to store.
     * @return Returns the index of the bucket.
     * @throws IllegalArgumentException
     *             Thrown if the given key is null.
     */
    public int getBucketIndex(K key);

    /**
     * Retrieve the value associated with the specified key.
     *
     * @param key
     *            The key whose value is to be returned.
     * @return Returns the value associated with the specified key or null if no
     *         such key is stored in the map.
     * @throws IllegalArgumentException
     *             Thrown if the specified key is null.
     */
    public V get(K key);

    /**
     * Retrieve the key-value entry associated with the specified key.
     *
     * @param key
     *            The key whose key-value entry is to be returned.
     * @return Returns the key-value entry whose key matches the specified key.
     * @throws IllegalArgumentException
     *             Thrown if the specified key is null.
     */
    public Pair<K, V> getEntry(K key);

    /**
     * Remove a key-value mapping from the map.
     *
     * @param key
     *            The key of the key-value mapping to remove.
     * @return True if a mapping with the specified key was found and removed.
     *         False if the map did not contain a mapping with the specified
     *         key.
     * @throws IllegalArgumentException
     *             Thrown if the specified key is null.
     */
    public boolean remove(K key);

    /**
     * Test whether the map contains an entry for the given key.
     *
     * @param key
     *            The key to test.
     * @return Returns true if the map contains an entry with the specified
     *         key, false otherwise.
     */
    public boolean contains(K key);

    /**
     * Resizes the map to use a greater number of buckets.
     * Keeps all current entries of the SimpleHashMap, but they may be in a different order.
     *
     * @param updatedCapacity The new capacity (i.e. the new number of buckets after resizing).
     * @throws IllegalArgumentException
     *              Thrown if the desired capacity is smaller than the current capacity.
     */
    public void resize(int updatedCapacity);

}
