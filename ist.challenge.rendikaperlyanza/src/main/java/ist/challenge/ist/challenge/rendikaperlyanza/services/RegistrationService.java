package ist.challenge.ist.challenge.rendikaperlyanza.services;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import ist.challenge.ist.challenge.rendikaperlyanza.repository.RegistrationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepository registerRepository;

    public BaseResponse registerFunc(LoginModel login) {
        try {
            int checkUser = registerRepository
                    .checkUser(login.getUsername());
            if (Objects.isNull(login.getUsername()) || Objects.isNull(login.getPassword())) {
                return BaseResponse.builder("User/Password Kosong", HttpStatus.BAD_REQUEST, null);
            }
            if (checkUser != 0) {
                return BaseResponse.builder("Username Sudah Terpakai", HttpStatus.CONFLICT, null);
            }
            registerRepository.save(login);
            return BaseResponse.builder("Sukses", HttpStatus.OK, null);

        } catch (Exception e) {
            log.error("Registrasi Gagal {0}", e);
            return BaseResponse.builder("Registrasi Gagal", HttpStatus.INTERNAL_SERVER_ERROR, null);

        }
    }
}
