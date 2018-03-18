package lt.invoices.good;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="GOODS")
public class GoodModel {

		@Id
		@Column (name="ID", nullable=false)
		@GeneratedValue(strategy=GenerationType.AUTO)
		private Long id;
		
		@Column (name="NAME", nullable=false, length=100)
		private String name;
		
		@Column (name="AMOUNT")
		private double amount;
		
		@Column (name="UNITS", nullable=false, length=100)
		private  String unitType;
		
		@Column (name="GOODS")
		private BigDecimal pricePerUnit;
		
		@Column (name="INVOICE_ID")
		@ManyToOne
		private Long invoiceId;
		
		public GoodModel() {}

		

		public GoodModel(Long id, String name, double amount, String unitType, BigDecimal pricePerUnit,
				Long invoiceId) {
			super();
			this.id = id;
			this.name = name;
			this.amount = amount;
			this.unitType = unitType;
			this.pricePerUnit = pricePerUnit;
			this.invoiceId = invoiceId;
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

		public Long getInvoiceId() {
			return invoiceId;
		}

		public void setInvoiceId(Long invoiceId) {
			this.invoiceId = invoiceId;
		}
	
}
