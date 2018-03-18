package lt.invoices.invoiceApp.good;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lt.invoices.invoiceApp.invoice.InvoiceModel;

@Entity
@Table(name="GOODS")
public class GoodModel {

		@Id
		@Column (name="ID", nullable=false)
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column (name="NAME", nullable=false, length=100)
		private String name;
		
		@Column (name="AMOUNT")
		private double amount;
		
		@Column (name="UNITS", nullable=false, length=100)
		private  String unitType;
		
		@Column (name="UNIT_PRICE")
		private BigDecimal pricePerUnit;
		
		@ManyToOne
		@JoinColumn(name="INVOICE_ID", nullable = false)
		private InvoiceModel invoice;
		
		public GoodModel() {}

		public GoodModel(String name, double amount, String unitType, BigDecimal pricePerUnit) {
			this.name = name;
			this.amount = amount;
			this.unitType = unitType;
			this.pricePerUnit = pricePerUnit;
		}
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getUnitType() {
			return unitType;
		}

		public void setUnitType(String unitType) {
			this.unitType = unitType;
		}

		public BigDecimal getPricePerUnit() {
			return pricePerUnit;
		}

		public void setPricePerUnit(BigDecimal pricePerUnit) {
			this.pricePerUnit = pricePerUnit;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public InvoiceModel getInvoice() {
			return invoice;
		}

		public void setInvoice(InvoiceModel invoice) {
			this.invoice = invoice;
		}

		
	
}
