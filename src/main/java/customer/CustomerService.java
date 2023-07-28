package customer;

import java.util.*;

public class CustomerService {
	Map<Integer,Customer> customers = new HashMap<>();
	/*
	public CustomerService() {
		Customer c = new Customer(1,"박지성","영국 맨체스터","000-5000-0001");
		customers.put(1, c);
		c = new Customer(2,"김연아","대한민국 서울","000-6000-0001");
		customers.put(2,c);
		c = new Customer(3,"장미란","대한민국 강원도","000-7000-0001");
		customers.put(3,c);
		c = new Customer(4,"추신수","미국 클리블랜드","000-8000-0001");
		customers.put(4,c);
		c = new Customer(5,"박세리","대한민국 대전","N/A");
		customers.put(5,c);
	}*/
	public Customer get(int id) {
        Customer rtn = null;
        
        rtn = customers.get(id);
        
        if (rtn == null) {
            rtn = new Customer();
            rtn.setId(-1);
            rtn.setName("");
            rtn.setAddress("");
            rtn.setPhone("");
        }
        
        return rtn;
    }
	
	public synchronized void add(Customer customer) {
		int max = Collections.max(customers.keySet());
		customer.setId(max + 1);
		
		customers.put(customer.getId(),customer);
	}
	
	public List<Customer> findAll(){
		return new ArrayList<>(customers.values());
	}
//	public Customer find(String id) {
//		return customers.get(id);
//	}
	 public synchronized void set(Customer customer) {
	        customers.put(customer.getId(), customer);
	    }
	 public synchronized void remove(int id) {
        customers.remove(id);
     }
	
}
