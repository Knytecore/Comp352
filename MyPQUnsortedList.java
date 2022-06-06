package a2_352;

import java.util.Comparator;



public class MyPQUnsortedList<K,V> implements MyPQ<K,V>{
	private Node head;
	private int size;
	private Comparator<K> comp = new DefaultComparator<K>();
	
	class Node{
		private Entry<K, V> value;
		private Node next;
		private Node prev;

		
		Node(Entry<K, V> value, Node next){
			this.value = value;
			this.next = next;
		}
		

		public Node getnext() {
			return next;
		}
		
		public Entry<K, V> getValue() {
			return value;
		}

		
		
	}
	
	
	
	
	
	
	public MyPQUnsortedList() {
		head = null;
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
		head = new Node(newEntry,head);
		if(size>0) {
			head.next.prev = head;
		}
		size++;
		return newEntry;
	}

	public Entry<K, V> min() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return null;
		}
		Entry<K, V> min_entry = head.getValue();
		K min = head.getValue().getKey();
		while(head != null) {
			if(comp.compare(min, head.getValue().getKey())>0) {
				min = head.getValue().getKey();
				min_entry = head.getValue();
			}
			head = head.getnext();
		}
		

		return min_entry;
	}
	
	private Node min_node() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return null;
		}
		Node min_node = head;
		Node temp = head;
		K min = head.getValue().getKey();
		boolean change_head = true;
		for(int i =0;i<size;i++) {
			if(comp.compare(min, temp.getValue().getKey())>0) {
				min = temp.getValue().getKey();
				min_node = temp;
				change_head = false;
			}
			temp = temp.getnext();
		}
		
		if(change_head) {
			head=head.next;
		}
		

		return min_node;
	}

	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return null;
		}
		Node min = min_node();
		try {
			min.prev.next = min.next;

		}catch(Exception e){
			
		}
		try {
			min.next.prev = min.prev;

		}catch(Exception e){
			
		}
		size--;
		return min.getValue();
	}

}
