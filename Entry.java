package a2_352;

public class Entry<K,V> {
	
	private K key;
	private V value;
	
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	K getKey( ) {
		return key;
	}; // returns the key stored in this entry
	V getValue( ) {
		return value;
	}

}