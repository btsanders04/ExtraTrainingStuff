import static org.junit.Assert.*;

import org.junit.Test;


public class InvoiceTest {

	Invoice invoice = new Invoice();
	ProductDB data = new ProductDB();
	InvoiceStorage records = new InvoiceStorage();
	@Test
	public void testInvoice() {
		invoice.setTax(.08);
		invoice.customerInfo("Brandon Sanders", "1082 Yellow Rose Dr");
		invoice.addLineItem(new LineItem(data.getProduct("java"),10));
		invoice.addLineItem(new LineItem(data.getProduct("jsps"),1));
		invoice.addLineItem(new LineItem(data.getProduct("banana"),40));
		invoice.addLineItem(new LineItem(data.getProduct("hdd"),3));
		invoice.addLineItem(new LineItem(data.getProduct("flash"),7));
		System.out.println(invoice);
		System.out.println();
		records.addInvoice(invoice);
		System.out.println(records.salesReport());
		
	}
}
