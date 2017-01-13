/**
 * Entries for all implementations of the {@link HashMapInterface} interface.
 */
public class Pair<eK, eV> {

    public final eK key;
    public eV value;

    public Pair<eK, eV> nextPairInBucket;

    public Pair(eK key, eV value, Pair<eK, eV> nextPairInBucket) {
        this.key = key;
        this.value = value;
        this.nextPairInBucket = nextPairInBucket;
    }

    public eK getKey() {
        return key;
    }

    public eV getValue() {
        return value;
    }
}
