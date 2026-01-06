package APQImplementation;

public interface PriorityQueue<K,V> {
	int size();
	boolean isEmpty();
	Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
	Entry<K,V> minimum();
	Entry<K,V> maximum();
	Entry<K,V> removeMinimum();
	Entry<K,V> removeMaximum();

}