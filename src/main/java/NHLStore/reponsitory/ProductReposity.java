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
	@Query("select p from Product p where p.category.id=?1 and  p.status=?2")
	List<Product> findByCondi(Long x, String y);
	@Query("select p from Product p where p.category.id = ?1")
	List<Product> findByCategory(Long id);
	@Query("select p from Product p where category.id = 1 ")
	List<Product> findTop3Nuts();
	@Query("select p from Product p where category.id = 2 ")
	List<Product> findTop3Oils();
	@Query("select p from Product p where category.id = 3 ")
	List<Product> findTop3PastaNoodles();
	@Query("select p from Product p where p.name like %?1% and p.category.id=?2 and p.status=?3")
	List<Product> findByFilter(String name,Long category,String status);
	@Query("select p from Product p where p.discount>10")
	List<Product> findByDiscount();
	@Query("select p from Product p where p.name like %?1% and p.status=?2")
	List<Product> findByFilter1(String name,String status);
	@Query("select p from Product p where p.name like %?1% and p.category.id=?2 ")
	List<Product> findByFilter2(String name,Long category);

}
