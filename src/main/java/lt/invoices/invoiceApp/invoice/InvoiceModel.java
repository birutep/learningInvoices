package lt.invoices.invoiceApp.invoice;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lt.invoices.invoiceApp.good.GoodModel;

@Entity
@Table(name="INVOICES")
public class InvoiceModel {

	@Id
	@Column (name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column (name="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date; 
	
	@Column (name="GIVEN_BY_ORG", nullable=false, length=100)
	private String orgGiving;
	
	@Column (name="RECEIVED_BY_ORG", nullable=false, length=100)
	private  String orgReceiving;
	
	@OneToMany(mappedBy="invoice")
	private Set<GoodModel> goods;
	
	public InvoiceModel() {}

	public InvoiceModel(String orgGiving, String orgReceiving) {
		this.date = new Date();
		this.orgGiving = orgGiving;
		this.orgReceiving = orgReceiving;
		this.goods = new HashSet<GoodModel>();
	}

	public Long getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOrgGiving() {
		return orgGiving;
	}

	public void setOrgGiving(String orgGiving) {
		this.orgGiving = orgGiving;
	}

	public String getOrgReceiving() {
		return orgReceiving;
	}

	public void setOrgReceiving(String orgReceiving) {
		this.orgReceiving = orgReceiving;
	}

	public Set<GoodModel> getGoods() {
		return goods;
	}

	public void setGoods(Set<GoodModel> goods) {
		this.goods = goods;
	}

	public void addGood(GoodModel good) {
		this.goods.add(good);
		good.setInvoice(this);
	}
	
	
	
	
	
}
