package lt.invoices.invoice;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value="invoice")
@RequestMapping(value="/invoices")
public class InvoiceController {

	@Autowired
	private InvoiceServices invoiceService;
	
	public InvoiceController() {}
	
	//RequestMapping anotacija galima keisti GetMapping/PostMapping/DeleteMApping anotacijomis
	@RequestMapping(method=RequestMethod.GET)
	@ApiOperation(value="Get all invoices", notes="Returns all invoices in the list.")
	public @ResponseBody List<InvoiceModel> getInvoices(){
		return Collections.emptyList();
		//pasitaisyti return, kai jau veiks i normalu rezultata
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value="Create invoice", notes="Creates new invoice - adds it to DB.")
	public @ResponseBody void addInvoice(@RequestBody InvoiceModel invoice) {
		invoiceService.createInvoice(invoice);
	}
	
	@RequestMapping(path= "/{invoiceId}", method=RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ApiOperation(value="Delete invoice", notes="Deletes one invoice - removes it from DB.")
	public @ResponseBody void deleteInvoice(@PathVariable Long invoiceId) {
		invoiceService.deleteInvoice(invoiceId);
	}
	
}
