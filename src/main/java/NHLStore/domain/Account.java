package NHLStore.domain;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name="Accounts")
public class Account implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=30,unique = true, nullable=false)
	private String username;
	@Column(length=30, nullable=false)
	private String password;
	@Column(length=30)
	private String phone;
	@Column(length=30)
	private String email;
	@Column(columnDefinition = "bit not null")
	private boolean isadmin=false;
	
	@OneToMany(mappedBy = "account",cascade =CascadeType.ALL)
	private Set<Order> orders;
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private Set<CartItem> CartItems;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isIsadmin() {
		return isadmin;
	}
	public void setIsadmin(boolean isadmin) {
		this.isadmin = isadmin;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public Set<CartItem> getCartItems() {
		return CartItems;
	}
	public void setCartItems(Set<CartItem> cartItems) {
		CartItems = cartItems;
	}
	public Account() {
		super();
	}
	
}
