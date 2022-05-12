package NHLStore.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import NHLStore.domain.CartItem;

public interface CartItemResponsitory extends JpaRepository<CartItem, Long>{
	@Query("select ci from CartItem ci where ci.product.id = ?1")
	List<CartItem> findCartItem(Long id);
}
