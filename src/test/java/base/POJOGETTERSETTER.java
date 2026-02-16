package base;

public class POJOGETTERSETTER {

	private String quote;
	private String author;
	
	public POJOGETTERSETTER() {};
	
	public POJOGETTERSETTER(String quote, String author) {
		this.quote = quote;
		this.author = author;
	}
	
	public String getquote() {
		return quote;
	}
	
	public void setquote(String quote) {
		this.quote = quote;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void SetAuthor(String author) {
		this.author = author;
	}
	
}
