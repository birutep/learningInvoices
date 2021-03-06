package lt.invoices.invoiceApp.invoice;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lt.invoices.invoiceApp.good.GoodModel;

@Service
public class InvoiceServices {

	@Autowired
	private InvoiceRepository invoiceRep;
	
	public InvoiceServices() {}
	
	@Transactional(readOnly = true)
	public List<InvoiceModel> getInvoices(){
		return invoiceRep.findAll();
	}
	
	@Transactional(readOnly = true)
	public Set<GoodModel> getGoodsByInvoiceId(Long invoiceId){
		return invoiceRep.findById(invoiceId).get().getGoods();
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
