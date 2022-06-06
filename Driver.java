package a2_352;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPQUnsortedArray PQUnsortedArray = new MyPQUnsortedArray<Integer,String>();
		PQUnsortedArray.insert(1,"test");
		PQUnsortedArray.insert(6,"testa");
		PQUnsortedArray.insert(3,"testaaa");
		PQUnsortedArray.insert(4,"aa");
		Entry<Integer,String> entry = PQUnsortedArray.removeMin();
		System.out.print(entry.getValue());
		System.out.println(PQUnsortedArray.min_index());
		
		MyPQSortedArray PQSortedArray = new MyPQSortedArray<Integer,String>();
		PQSortedArray.insert(1,"test");
		PQSortedArray.insert(-1,"testa");
		PQSortedArray.insert(3,"testaaa");
		PQSortedArray.insert(4,"aa");
		Entry<Integer,String> entry2 = PQSortedArray.removeMin();
		Entry<Integer,String> entry3 = PQSortedArray.removeMin();

		System.out.println(entry3.getValue());
		
		MyPQUnsortedList PQUnsortedList = new MyPQUnsortedList<Integer,String>();
		PQUnsortedList.insert(1,"test");
		PQUnsortedList.insert(3,"testaaa");
		PQUnsortedList.insert(4,"aa");
		PQUnsortedList.insert(-1,"testa");

		Entry<Integer,String> entry4 = PQUnsortedList.removeMin();
		Entry<Integer,String> entry5 = PQUnsortedList.removeMin();
		Entry<Integer,String> entry6 = PQUnsortedList.removeMin();


		System.out.println(entry4.getValue());
		
		MyPQSortedList PQSortedList = new MyPQSortedList<Integer,String>();
		PQSortedList.insert(1,"test");
		PQSortedList.insert(3,"testaaa");
		PQSortedList.insert(4,"aa");
		PQSortedList.insert(-1,"testa");

		Entry<Integer,String> entry7 = PQSortedList.removeMin();
		Entry<Integer,String> entry8 = PQSortedList.removeMin();
		Entry<Integer,String> entry9 = PQSortedList.removeMin();
		Entry<Integer,String> entry10 = PQSortedList.removeMin();




		System.out.println(entry7.getValue());
		
	}

}
