package app;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountServiceRepository extends JpaRepository<Account, Long> {

}
