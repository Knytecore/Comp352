package a1_352;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;  


public class Covid_reservations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date[] dates = null;
		//Create dates array
		try {
			dates = new Date[]{sdf.parse("25-11-2021"),sdf.parse("08-03-2022"),sdf.parse("02-12-2021"),sdf.parse("01-02-2022"),sdf.parse("02-12-2021"),
					sdf.parse("03-12-2021"),sdf.parse("25-01-2022"),sdf.parse("14-01-2022"),sdf.parse("01-02-2022"),sdf.parse("01-02-2022")};
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Create rSlot array
		int[] rSlot = {25,10,7,15,3,40,36,11,10,15};
		
		//Create rMedicare array
		String[] rMedicare = {"CCC11","FFF22","DDD77","HHH33","KKK77","AAA66","JJJ44","EEE99","GGG55","BBB66"};
		rearrangeReservations(dates,rSlot,rMedicare);
		for(int i = 0; i<dates.length;i++) {
			System.out.println(dates[i] + "   " + rSlot[i] + "      " + rMedicare[i]);
		}
		
	}
	
	public static int rearrangeReservations(Date[] dates,int[] rSlot,String[] rMedicare) {
		boolean done =true;
		int activeReservations = 0;
		int count = 0;
		while(count<(dates.length-1)) {
			int result = dates[count].compareTo(dates[count+1]);
			if(result == 0) { //Dates equal
				if(rSlot[count] < rSlot[count+1]) {
					int temp = rSlot[count];
					rSlot[count] = rSlot[count+1];
					rSlot[count+1] = temp;
					
					String tempMed = rMedicare[count];
					rMedicare[count] = rMedicare[count+1];
					rMedicare[count+1] = tempMed;
				}
			}else if(result < 0) { //Date[count] is before date[count+1]
				done = false;
				Date temp = dates[count];
				dates[count] = dates[count+1];
				dates[count+1] = temp;
				
				int tempSlot = rSlot[count];
				rSlot[count] = rSlot[count+1];
				rSlot[count+1] = tempSlot;
				
				String tempMed = rMedicare[count];
				rMedicare[count] = rMedicare[count+1];
				rMedicare[count+1] = tempMed;
				
				
			}
			count++;
		}
		count = dates.length -1;
		while(count > 0) {

			int result = dates[count].compareTo(dates[count-1]);
			if(result == 0) { //Dates equal
				if(rSlot[count] > rSlot[count-1]) {
					int temp = rSlot[count];
					rSlot[count] = rSlot[count-1];
					rSlot[count-1] = temp;
					
					String tempMed = rMedicare[count];
					rMedicare[count] = rMedicare[count-1];
					rMedicare[count-1] = tempMed;
				}
			}else if(result > 0) { //Date[count] is after date[count-1]
				done = false;
				Date temp = dates[count];
				dates[count] = dates[count-1];
				dates[count-1] = temp;
				
				int tempSlot = rSlot[count];
				rSlot[count] = rSlot[count-1];
				rSlot[count-1] = tempSlot;
				
				String tempMed = rMedicare[count];
				rMedicare[count] = rMedicare[count-1];
				rMedicare[count-1] = tempMed;
			}
			count--;
		}
		
		if(!done) {
			rearrangeReservations(dates,rSlot,rMedicare);
		}
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		Date today = null;
		try {//Set date of today
			today = sdf.parse("01-01-2022");
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		
		while(today.compareTo(dates[activeReservations]) <= 0) {
			activeReservations++;
		}
		
		int start = 0;
		int end = activeReservations;
		
	    while (start < end)
	    {
	        Date temp = dates[start];
	        dates[start] = dates[end];
	        dates[end] = temp;
	        
			int tempSlot = rSlot[start];
			rSlot[start] = rSlot[end];
			rSlot[end] = tempSlot;
			
			String tempMed = rMedicare[start];
			rMedicare[start] = rMedicare[end];
			rMedicare[end] = tempMed;
			
	        start++;
	        end--;
	    }
	    
	    
		
		return activeReservations;
	}
	
	
	

}