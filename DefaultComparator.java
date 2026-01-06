package APQImplementation;

import java.util.Comparator;

public class DefaultComparator<E> implements Comparator<E>{
	public int compare(E obj1, E obj2) throws ClassCastException{
		return ((Comparable<E>) obj1).compareTo(obj2);
	}

}