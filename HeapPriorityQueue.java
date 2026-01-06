package APQImplementation;

import java.util.Comparator;

public class HeapPriorityQueue<K,V> extends AbstractPriorityQueue<K,V>{
	//protected APQ<K,V> heap = new APQ<>();
	protected DynamicArray<K,V> heap= new DynamicArray<>();
	protected Entry<K,V> get(int index) {
	    return heap.get(index);
	}
	protected HeapPriorityQueue() {
		super();
	}
	public HeapPriorityQueue(Comparator<K> comparator1) {
		super(comparator1);
	}
	protected int parent(int j) {
		return (j-1)/2;
	}
	protected int left(int j) {
		return ((2*j)+1);
	}
	protected int right(int j) {
		return ((2*j)+2);
	}
	protected boolean hasLeft(int j) {
		return left(j)<heap.size();
	}
	protected boolean hasRight(int j) {
		return right(j)<heap.size();
	}
	protected void swap(int i, int j) {
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j,temp);
	}
	protected void upheap(int j) {
		while (j>0) {
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p))>=0) {
				break;
			}
			swap(j,p);
			j=p;
		}
	}
	protected void downheap(int j) {
		while (hasLeft(j)) {
			int leftIndex = left(j);
			int childIndex = leftIndex;
			if (hasRight(j)) {
				int rightIndex=right(j);
				if (compare(heap.get(leftIndex), heap.get(rightIndex))>0) {
					childIndex = rightIndex;
				}
			}
			if (compare(heap.get(childIndex),heap.get(j))>=0) {
				break;
			}
			swap(j, childIndex);
			j=childIndex;
		}
	}
	@Override
	public int size() {
		return heap.size();
	}
	@Override
	public Entry<K, V> minimum() {
		if (heap.isEmpty()) {
			return null;
		}
		return heap.get(0);
	}
	@Override
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key); // check if key is null
		Entry<K,V> newKey = new PQ<>(key,value);
		heap.add(newKey);
		upheap(heap.size()-1);
		return newKey;
	}
	@Override
	public Entry<K, V> removeMinimum() {
		if (heap.isEmpty()) {
			return null;
		}
		Entry<K,V> a = heap.get(0);
		swap(0, heap.size()-1);
		heap.remove(heap.size()-1);
		downheap(0);
		return a;
	}

	
	@Override
	public Entry<K, V> maximum() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Entry<K, V> removeMaximum() {
		// TODO Auto-generated method stub
		return null;
	}
}