package lt.invoices.invoice;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lt.invoices.good.GoodModel;

@Entity
@Table(name="INVOICES")
public class InvoiceModel {

	@Id
	@Column (name="ID", nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column (name="DATE", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date date; 
	
	@Column (name="GIVEN_BY_ORG", nullable=false, length=100)
	private String orgGiving;
	
	@Column (name="RECEIVED_BY_ORG", nullable=false, length=100)
	private  String orgReceiving;
	
	@Column (name="GOODS")
	@OneToMany
	private ArrayList<GoodModel> goods;
	
	public InvoiceModel() {}

	public InvoiceModel(Long id, String orgGiving, String orgReceiving, ArrayList<GoodModel> goods) {
		this.id = id;
		this.date = new Date();
		this.orgGiving = orgGiving;
		this.orgReceiving = orgReceiving;
		this.goods = goods;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public ArrayList<GoodModel> getGoods() {
		return goods;
	}

	public void setGoods(ArrayList<GoodModel> goods) {
		this.goods = goods;
	}
	
	
	
	
	
}
