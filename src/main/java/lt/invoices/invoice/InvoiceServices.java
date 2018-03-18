package lt.invoices.invoice;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InvoiceServices {

	@Autowired
	private InvoiceRepository invoiceRep;
	
	public InvoiceServices() {}
	
	@Transactional(readOnly = true)
	public List<InvoiceModel> getInvoices(){
		return invoiceRep.findAll();
	}
	
	@Transactional
	public void createInvoice(InvoiceModel invoice) {
		invoiceRep.save(invoice);
	}
	
	@Transactional
	public void deleteInvoice(Long id) {
		invoiceRep.deleteById(id);;
	}
	
}
