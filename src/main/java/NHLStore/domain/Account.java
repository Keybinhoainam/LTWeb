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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Accounts")
public class Account implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(length=30)
	private String username;
	@Column(length=30, nullable=false)
	private String passwword;
	@Column(length=30)
	private String phone;
	@Column(length=30)
	private String email;
	@Column(columnDefinition = "bit not null")
	private boolean isadmin;
	
	@OneToMany(mappedBy = "account",cascade =CascadeType.ALL)
	private Set<Order> orders;
	@OneToMany(mappedBy = "account",cascade = CascadeType.ALL)
	private Set<CartItem> CartItems;
}
