package APQImplementation;

import java.util.Comparator;

public class DynamicArray<K,V> {
    private Entry<K,V>[] data;   //array
    private int size;   //nb of elements
    private Comparator<Entry<K,V>> comparator;
    
    public Entry<K,V> get(int index){
    	if (index<0||index>=size) {
    		throw new IndexOutOfBoundsException();
    	}
    	return data[index];
    }
    public void set(int index, Entry<K,V> entry) {
    	if (index<0||index>=size) {
    		throw new IndexOutOfBoundsException();
    	}
    	data[index]=entry;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    
    @SuppressWarnings("unchecked")
    public DynamicArray(){
        data = (Entry<K,V>[]) new Entry[10];
        size = 0;
        // Default to min-heap comparator
        this.comparator = (e1, e2) -> ((Comparable<K>)e1.getKey()).compareTo(e2.getKey());
    }
    
    /*public boolean add(Entry<K,V> entry) {
    	if (size==data.length) {
    		resize(data.length*2);
    	}
    	data[size]=entry;
    	size++;
    	return true;
    } */
    
    //Dynamic resizing
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        //creating a new array to hold the data 
        Entry<K,V>[] newData = (Entry<K,V>[]) new Entry[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
    
    //Appends the specified element to the end of this list 

    public boolean add(Entry<K,V> entry){
        if(size == data.length)
            resize(data.length * 2); //helper method to have dynamic resizing when growing
        data[size] = entry; //using size as an index in data to add the element progressively
        size++;  //increasing the size
        return true;
    }
    public Entry<K,V> remove(int index) {
        if (index<0||index>=size) {
            throw new IndexOutOfBoundsException();
        }
        Entry<K,V> removedEntry = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return removedEntry;
    }
    
    //Removes all of the elements from this list 
    void clear(){
        for(int i=0; i < size; i++){
            data[i] = null;
        }
        size = 0;
    }
    
    //returns the number of elements in this list 
    public int size(){
        return size;
    }
    
    //returns a string representation of this list
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}