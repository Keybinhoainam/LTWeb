package NHLStore.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CartItemDTO implements Serializable{
	private Long id;
	private Long userId;
	private Long productId;
	private int quantity;
	private Long cartId;
	private int isActive;
	private double amount;
}
