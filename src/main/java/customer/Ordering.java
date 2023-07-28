package customer;
import java.util.*;
public class Ordering {
	private int id;
    private int customerId;
    private int bookId;
    private int sellingPrice;
    private String orderingDate;
    private Customer customer;
    private Book book;
	
	public Ordering() {}
	
	public Ordering(int id, int customerId, int bookId, int sellingPrice, String orderingDate) {
		this.id = id;
		this.customerId = customerId;
		this.bookId = bookId;
		this.sellingPrice = sellingPrice;
		this.orderingDate = orderingDate;
	}

	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(int sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getOrderingDate() {
        return orderingDate;
    }

    public void setOrderingDate(String orderingDate) {
        this.orderingDate = orderingDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
