package ist.challenge.ist.challenge.rendikaperlyanza.services;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import ist.challenge.ist.challenge.rendikaperlyanza.repository.LoginRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class LoginService {
    @Autowired
    private  LoginRepository loginRepository;

    public BaseResponse loginFunc(LoginModel login) {
        try {
            int checkUser = loginRepository
                    .checkingUserPass(login.getUsername(), login.getPassword());
            if (Objects.isNull(login.getUsername()) || Objects.isNull(login.getPassword())) {
                return BaseResponse.builder("Username dan / atau Password Kosong", HttpStatus.BAD_REQUEST, null);
            }
            if (checkUser == 0) {
                return BaseResponse.builder("Username / Password Salah", HttpStatus.BAD_REQUEST, null);
            }
            return BaseResponse.builder("Login Sukses", HttpStatus.OK, null);

        } catch (Exception e) {
            log.error("Gagal Login {}", e);
            return BaseResponse.builder("Login Gagal", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
