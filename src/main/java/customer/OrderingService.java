package customer;
import java.util.*;
import org.apache.commons.csv.*;
public class OrderingService {

	Map<Integer,Ordering> orderings = new HashMap<>();
	/*
	public OrderingService() {
		Ordering o = new Ordering(1,1,1,6000,"2023-06-30");
		orderings.put(1, o);
		o = new Ordering(2,1,3,21000,"2020-07-03");
		orderings.put(2, o);
		o = new Ordering(3,2,5,8000,"2020-07-03");
		orderings.put(3, o);
		o = new Ordering(4,3,6,6000,"2020-07-04");
		orderings.put(4, o);
		o = new Ordering(5,4,7,20000,"2020-07-05");
		orderings.put(5, o);
		o = new Ordering(6,1,2,12000,"2020-07-07");
		orderings.put(6, o);
		o = new Ordering(7,4,8,13000,"2020-07-07");
		orderings.put(7, o);
		o = new Ordering(8,3,10,12000,"2020-07-08");
		orderings.put(8, o);
		
		o = new Ordering(9,2,10,7000,"2020-07-09");
		orderings.put(9, o);
		o = new Ordering(10,3,8,13000,"2020-07-09");
		orderings.put(10, o);
	}*/
	
	public synchronized void add(Ordering ordering) {
		int max = Collections.max(orderings.keySet());
		ordering.setId(max + 1);
		ordering.setOrderingDate("2023-07-23");
		orderings.put(ordering.getId(),ordering);
	}
	
	public List<Ordering> findAll(){
		return new ArrayList<>(orderings.values());
	}
	public Ordering find(int id) {
		return orderings.get(id);
	}
}
