package a2_352;

public interface MyPQ<K,V> {
	int size( );
	boolean isEmpty( );
	Entry<K,V> insert(K key, V value) throws IllegalArgumentException;
	Entry<K,V> min( );
	Entry<K,V> removeMin( );
}
