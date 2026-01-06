package APQImplementation;

public class APQ<K,V> extends HeapPriorityQueue<K,V> {
	private boolean minHeap;
	public APQ() {
		super();
		this.minHeap= true;
	}
	@Override
	protected int compare(Entry<K,V> obj1, Entry<K,V> obj2) {
		int result = super.compare(obj1, obj2);
		if (minHeap) {
			return result;
		} else {
			return -result;
		}
	}

	/*1. toggle(): Switches the queue between min-heap and max-heap modes.*/
	public void toggle() {
		minHeap = !minHeap;
		rebuildHeap();
	}
	// helper method: rebuild heap
	private void rebuildHeap() {
		int n = size();
		for (int i=parent(n-1);i>=0;i--) {
			downheap(i);
		}
	}
	/*2. removeTop(): Removes and returns the entry (key-value pair) with the smallest or largest
key, depending on the current mode (Min or Max).
*/
	public Entry<K,V> removeTop(){
		if (heap.isEmpty()) {
			return null;
		}
		Entry<K,V> top=heap.get(0);
		swap(0,heap.size()-1);
		heap.remove(heap.size()-1);
		downheap(0);
		return top;
	}
	/*
3. insert(k, v): Adds a new entry with key k and value v to the queue, returning the resulting
entry object. */
	@Override
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
		checkKey(key);
		Entry<K,V> newE = new PQ<>(key,value);
		heap.add(newE);
		upheap(heap.size()-1);
		return newE;
	}
	

	/*4. top(): Retrieves the entry with the smallest or largest key (depending on the current mode)
without removing it. */
	public Entry<K,V> top(){
		if (heap.isEmpty()) {
			return null;
		}
		return heap.get(0);
	}
	/*
5. remove(e): Removes a specific entry e from the queue and returns it. */
	public Entry<K,V> remove(Entry<K,V> e){
		int index=-1;
		for (int i=0; i<heap.size();i++) {
			if (heap.get(i)==e) {
				index=i;
				break;
			}
		}
		if (index ==-1) {
			return null;
		}
		Entry<K,V> removedEntry = heap.get(index);
		if (index==heap.size()-1) {
			heap.remove(index);
		} else {
			heap.set(index, heap.get(heap.size() - 1));
			heap.remove(heap.size()-1);
			upheap(index);
			downheap(index);
		}
		return removedEntry;
	}
	/*
6. replaceKey(e, k): Updates the key of entry e to k and returns the old key.*/
	public K replaceKey(Entry<K,V> e, K key) {
		checkKey(key);
		int index=-1;
		for (int i=0; i<heap.size();i++) {
			if (heap.get(i)==e) {
				index =i;
				break;
			}
		}
		if (index==-1) {
			throw new IllegalArgumentException("Error: key to replace was not found.");
		}
		K oldKey = e.getKey();
		((PQ<K,V>) e).setKey(key);
		upheap(index);
		downheap(index);
		return oldKey;
	}

/*7. replaceValue(e, v): Updates the value of entry e to v and returns the old value.*/
	public V replaceValue(Entry<K,V> e, V value) {
		int index =-1;
		for (int i=0; i<heap.size(); i++) {
			if (heap.get(i)==e) {
				index =i;
				break;
			}
		}
		if (index==-1) {
			throw new IllegalArgumentException("Error: value to replace was not found.");
		}
		V oldValue=e.getValue();
		((PQ<K,V>) e).setValue(value);
		return oldValue;
	}
	
/*8. state(): Returns the current mode of the queue (Min or Max). */
	public String state() {
		if (minHeap) {
			return "Minimum";
		} else {
			return "Maximum";
		}
	}

/*9. isEmpty(): Checks if the queue is empty, returning true if it is. //inherited!
10. size(): Returns the total number of entries in the queue. //inherited!*/


/*11. peekAt(n): Returns the n-th entry in the priority queue (e.g., the n-th smallest key in a minheap or the n-th largest key in a max-heap) without removing it. Throws an error if n is out of
bounds.*/
	public Entry<K,V> peekAt(int n){
		if (n<1||n>heap.size()) {
			throw new IndexOutOfBoundsException();
		}
		@SuppressWarnings("unchecked")
		Entry<K,V>[] sorted = (Entry<K,V>[]) new Entry[heap.size()];
		for (int i=0; i< heap.size(); i++) {
			sorted[i]=heap.get(i);
		}
		for (int i=0; i< sorted.length-1;i++) {
			for (int j=0; j<sorted.length-i-1; j++) {
				if (compare(sorted[j], sorted[j+1])>0) {
					Entry<K,V> temp=sorted[j];
					sorted[j]=sorted[j+1];
					sorted[j+1]=temp;
				}
			}
		}
		return sorted[n-1];
	}
	
	
/*12. merge(otherAPQ): Merges the current priority queue with another APQ, combining all
entries into a single APQ. The result should maintain the current state (Min or Max) of the
primary APQ*/
	public void merge(APQ<K,V> otherAPQ) {
		if (otherAPQ==null||otherAPQ.isEmpty()) {
			return;
		} else {
			for (int i=0; i<otherAPQ.size();i++) {
				Entry<K,V> entry=otherAPQ.heap.get(i);
				heap.add(entry);
			}
			for (int i = parent(heap.size()-1); i>=0;i--) {
				downheap(i);
			}
		}
	}
}
