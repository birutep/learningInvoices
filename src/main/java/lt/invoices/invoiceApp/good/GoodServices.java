package lt.invoices.invoiceApp.good;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodServices {
	
	@Autowired
	private GoodRepository goodRep;
	
	@Transactional(readOnly = true)
	public List<GoodModel> getInvoices(){
		return goodRep.findAll();
	}
	
	@Transactional
	public void createGood(GoodModel good) {
		goodRep.save(good);
	}
	
	@Transactional
	public void deleteGood(GoodModel good) {
		goodRep.delete(good);
	}

}
