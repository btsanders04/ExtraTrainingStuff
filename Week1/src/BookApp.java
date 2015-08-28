
public class BookApp {

	public static void main(String[] args) {
		
		Book[] books = new Book[4];
		double total = BuyMultipleBooks(books);
		
	
	}
	
	public static double BuyMultipleBooks(Book[] books){
		double total=0;
		for(int i=0; i<books.length; i++){
			Book b = BookDB.getBook(books[i].getTitle());
			if(b.isInStock()){
				total+=b.getPrice();
			}
			else System.out.println(b.getTitle() + "is not in Stock");
		}
		return total;
	}

}
