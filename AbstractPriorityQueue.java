package APQImplementation;

import java.util.Comparator;

public abstract class AbstractPriorityQueue<K,V> implements PriorityQueue<K,V>{

	// nested PQ class
	static class PQ<K,V> implements Entry<K,V>{
		private K key;
		private V value;
		public PQ(K key, V value) {
			this.key=key;
			this.value=value;
		}
		public K getKey() {
			return key;
		}
		public V getValue() {
			return value;
		}
		void setKey(K key) {
			this.key=key;
		}
		void setValue(V value) {
			this.value = value;
		}			
	} // end of nested

	protected Comparator<K> comparator1;
	protected AbstractPriorityQueue(Comparator<K> comparator2) {
		comparator1=comparator2;
	}
	protected AbstractPriorityQueue() {
		this(new DefaultComparator<K>());
	}
	protected int compare(Entry<K,V> obj1, Entry<K,V> obj2) {
		return comparator1.compare(obj1.getKey(), obj2.getKey());
	}
	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comparator1.compare(key,key)==0);
		} catch (Exception e){
			throw new IllegalArgumentException("Error: The key is not compatible.");
		}
	}
	public boolean isEmpty() {
		if (size()==0) {
			return true;
		} else {
			return false;
		}
	}
}