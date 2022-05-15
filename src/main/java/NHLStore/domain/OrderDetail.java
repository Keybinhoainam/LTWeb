package NHLStore.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="orderdetails")
public class OrderDetail implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderDatailId;
	@Column(nullable = false)
	private int quantity;
	@Column(nullable = false)
	private double unitprice;
	@ManyToOne
	@JoinColumn(name="orderId")
	private Order order;
	@ManyToOne
	@JoinColumn(name="productId")
	private Product product;
	public OrderDetail() {
		super();
	}
	public Long getOrderDatailId() {
		return orderDatailId;
	}
	public void setOrderDatailId(Long orderDatailId) {
		this.orderDatailId = orderDatailId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getUnitprice() {
		return unitprice;
	}
	public void setUnitprice(double unitprice) {
		this.unitprice = unitprice;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
}
