package a2_352;

import java.util.Comparator;

import a2_352.MyPQUnsortedList.Node;



public class MyPQSortedList<K,V> implements MyPQ<K,V>{
	private Node head;
	private int size;
	private Comparator<K> comp = new DefaultComparator<K>();
	
	class Node{
		private Entry<K, V> value;
		private Node next = null;
		private Node prev= null;

		
		Node(Entry<K, V> value, Node next){
			this.value = value;
			this.next = next;
		}
		
		Node(Entry<K, V> value, Node next,Node prev){
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		

		public Node getnext() {
			return next;
		}
		
		public Entry<K, V> getValue() {
			return value;
		}

		
		
	}
	
	
	
	
	
	
	public MyPQSortedList() {
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
		
		
		if(size == 0 || comp.compare(key, head.getValue().getKey())<0) {
			head = new Node(newEntry,head);
			size++;
			return newEntry;
		}
		K min = head.getValue().getKey();
		Node temp = head;
		
		int i =0;
		if(comp.compare(key, head.getValue().getKey())<0) {
			head = new Node(newEntry,head);
			size++;
			return newEntry;
		}
		
		while(i<size-1 && comp.compare(key, temp.next.getValue().getKey())>0) { 
			i++;
			temp = temp.getnext();

		}
		try {
			Node past_prev = temp.next.prev;
			temp.next.prev = new Node(newEntry,temp.next.next,past_prev);
			past_prev.next.next = temp.next.prev;
		}catch(Exception e) {
			temp.next = new Node(newEntry,null,temp);
			
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


		return min_entry;
	}
	
	public Node min_node() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return null;
		}
		

		return head;
	}

	public Entry<K, V> removeMin() {
		// TODO Auto-generated method stub
		if(size == 0) {
			return null;
		}
		Entry<K, V> entry = head.getValue();
		try {
			head = head.next;
	
		}catch(Exception e) {
			head = null;
		}
		size--;
		return entry;
	}

}
