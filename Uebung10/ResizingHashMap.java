public class ResizingHashMap<K,V> implements HashMapInterface<K,V> {

    private int size;

    public Pair<K, V>[] buckets;

    @SuppressWarnings("unchecked")
    public ResizingHashMap(int capacity) {
        //TODO a
    }

    @Override
    public int size() {
        //TODO b
        return -1;
    }

    @Override
    public void insertEntry(int idx, Pair<K, V> entry) {
        //TODO c
    }

    @Override
    public int getBucketIndex(K key) {
        //TODO d
        return -1;
    }

    @Override
    public Pair<K, V> getEntry(K key) {
        //TODO e
        return null;
    }

    @Override
    public V get(K key) {
        //TODO f
        return null;
    }

    @Override
    public boolean contains(K key) {
        //TODO g
        return false;
    }

    @Override
    public boolean put(K key, V value) {
        //TODO h
        return false;
    }

    @Override
    public boolean remove(K key) {
        //TODO i
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void resize(int updatedCapacity) {
        //TODO j
    }
}
