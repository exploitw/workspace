package customer;

public class Book {
	private int id;
	private String title;
	private String publisher;
	private int price;
	
	public Book(int id, String title, String publisher, int price) {
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.price = price;
	}
	public Book() {}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
