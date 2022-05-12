package NHLStore.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import NHLStore.domain.Product;
@Repository
public interface ProductReposity extends JpaRepository<Product, Long>{
	@Query("select p from Product p where p.name like %?1%")
	List<Product> findByNameContaining(String name);
	@Query("select p from Product p where p.quantity > 0")
	List<Product> findProductInStock();
	@Query("select p from Product p where p.quantity <= 0")
	List<Product> findProductOutStock();

}
