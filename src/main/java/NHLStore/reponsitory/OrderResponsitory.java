package NHLStore.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;

import NHLStore.domain.Order;

public interface OrderResponsitory extends JpaRepository<Order, Long>{

}
