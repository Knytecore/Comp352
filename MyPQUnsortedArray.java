package a2_352;

import java.util.Comparator;

public class MyPQUnsortedArray<K,V> implements MyPQ<K,V>{
	private int size;
	private Entry<K, V>[] arr;
	private Comparator<K> comp = new DefaultComparator<K>();
	
	public MyPQUnsortedArray() {
		size = 0;
		arr = (Entry<K, V>[])new Entry[1];
	}
	
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	public boolean isEmpty() {
		if(size ==0) {
			return true;
		}else {
			return false;

		}
	}
	public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Entry<K,V> newEntry = new Entry<K,V>(key,value);
		if(size == arr.length) {
			Entry<K, V>[] oldarr = arr;
			arr = (Entry<K, V>[])new Entry[arr.length*2];
			for(int i = 0; i<size;i++) {
				arr[i] = oldarr[i];
			}
		}
		arr[size] = newEntry;
		this.size++;
		return newEntry;
	}

	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return null;
		}
		K min = arr[0].getKey();
		Entry<K, V> min_entry = arr[0];
		for(int i = 1; i<size;i++) {
			if(comp.compare(min, arr[i].getKey())>0) {
				min = arr[i].getKey();
				min_entry = arr[i];
			}
		}
		return min_entry;
	}
	
	public int min_index() {
		// TODO Auto-generated method stub

		K min = arr[0].getKey();
		int index = 0;
		for(int i = 1; i<size;i++) {
			if(comp.compare(min, arr[i].getKey())>0) {
				min = arr[i].getKey();
				index = i;
			}
		}
		return index;
	}

	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return null;
		}
		int min = min_index();
		Entry<K, V>[] oldarr = arr;
		Entry<K, V> min_entry = arr[min];
		
		if(size < arr.length/4) {
			this.arr = (Entry<K, V>[])new Entry[arr.length/2];

		}else {
			this.arr = (Entry<K, V>[])new Entry[arr.length];

		}
		for(int i = 0; i<min;i++) {
			this.arr[i] = oldarr[i];

		}
		for(int i = min; i<size-1;i++) {
			this.arr[i] = oldarr[i+1];

		}
		size--;
		return min_entry;
	}

}
