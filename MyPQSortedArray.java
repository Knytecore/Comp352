package a2_352;

import java.util.Comparator;

public class MyPQSortedArray<K,V> implements MyPQ<K,V>{
	private int size;
	private Entry<K, V>[] arr;
	private Comparator<K> comp = new DefaultComparator<K>();
	
	public MyPQSortedArray() {
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
		if(size == 0) {
			Entry<K,V> newEntry = new Entry<K,V>(key,value);
			arr[0] = newEntry;
			this.size++;
			return newEntry;
		}
		Entry<K,V> newEntry = new Entry<K,V>(key,value);
		Entry<K, V>[] oldarr = arr;
		if(size == arr.length) {
			arr = (Entry<K, V>[])new Entry[arr.length*2];
			for(int i = 0; i<size;i++) {
				arr[i] = oldarr[i];
			}
		} 
		
		int i =0;
		
		while(i<size && comp.compare(key, oldarr[i].getKey())>0) { 
			i++;
		}
		
		arr[i] = newEntry;
		for(int j = i+1;j<size+1;j++) {
			arr[j] = oldarr[j-1];
		}
		
		this.size++;
		return newEntry;
	}

	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		Entry<K, V> min_entry = arr[0];

		return min_entry;
	}
	

	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return null;
		}
		Entry<K, V>[] oldarr = arr;
		Entry<K, V> min_entry = arr[0];

		for(int i = 1; i<size;i++) {
			this.arr[i-1] = oldarr[i];

		}

		size--;
		return min_entry;
	}

}
