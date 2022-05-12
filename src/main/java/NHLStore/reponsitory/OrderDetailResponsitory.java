package NHLStore.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import NHLStore.domain.OrderDetail;
@Repository
public interface OrderDetailResponsitory extends JpaRepository<OrderDetail, Long>{

}
