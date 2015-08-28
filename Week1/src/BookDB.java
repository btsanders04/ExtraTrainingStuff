
public class BookDB {

	
	public static Book getBook(String title){
		
		Book b = new Book();
		
		b.setTitle(title);
		if(title.equalsIgnoreCase("java"))
		{
			b.setDescription("Murach's Beginning Java");
			b.setPrice(49.50);
		}
		else if(title.equalsIgnoreCase("jsps")){
			b.setDescription("Murach's Java Servlets and JSP");
			b.setPrice(49.50);
		}
		else if (title.equalsIgnoreCase("mcb2")){
			b.setDescription("Murach's Mainframe COBOL");
			b.setPrice(59.50);
		}
		else{
			b.setDescription("Unknown");
		}
		
		return b;
		
	}
	
}
