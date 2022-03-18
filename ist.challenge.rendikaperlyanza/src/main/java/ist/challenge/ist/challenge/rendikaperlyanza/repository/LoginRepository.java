package ist.challenge.ist.challenge.rendikaperlyanza.repository;

import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<LoginModel,Long> {

    @Query(value = "SELECT COUNT(A) FROM login_model A WHERE USERNAME = ?1",nativeQuery = true)
    int checkingUserName(String username);
    @Query(value = "SELECT COUNT(A) FROM login_model A WHERE username = ?1 AND password = ?2",nativeQuery = true)
    int checkingUserPass(String username,String password);
}
