package ist.challenge.ist.challenge.rendikaperlyanza.repository;

import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ListUserRepository extends JpaRepository<LoginModel,Long> {
    @Query(value = "SELECT * FROM login_model",nativeQuery = true)
    List<LoginModel>getData();

    @Query(value = "SELECT COUNT(A) FROM login_model A where username = ?1",nativeQuery = true)
    int checkUsername(String username);
    @Query(value = "SELECT COUNT(A) FROM login_model A where id = ?1",nativeQuery = true)
    int checkID(long id);
    @Query(value = "SELECT password FROM login_model A WHERE id = ?1",nativeQuery = true)
    String checkPassword(long id);
}
