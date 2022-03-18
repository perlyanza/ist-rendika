package ist.challenge.ist.challenge.rendikaperlyanza.repository;

import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<LoginModel,Long> {
    @Query(value = "SELECT COUNT(1) FROM login_model where username = ?1",nativeQuery = true)
    int checkUser(String user);
}
