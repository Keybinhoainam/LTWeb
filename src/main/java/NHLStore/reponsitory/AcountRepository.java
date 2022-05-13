package NHLStore.reponsitory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import NHLStore.domain.Account;
@Repository
public interface AcountRepository extends JpaRepository<Account,Long>{
    @Query("Select a from Account a where a.username = ?1")
    Optional<Account> findByUserName(String name);
}

