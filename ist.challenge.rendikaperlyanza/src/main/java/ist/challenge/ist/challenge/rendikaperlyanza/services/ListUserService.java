package ist.challenge.ist.challenge.rendikaperlyanza.services;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import ist.challenge.ist.challenge.rendikaperlyanza.repository.ListUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ListUserService {
    @Autowired
    private ListUserRepository listUserRepository;

    public BaseResponse getData() {
            var listUser = listUserRepository.getData();
            return BaseResponse.builder("Sukses", HttpStatus.OK, listUser);
    }

    public BaseResponse updateData(long id, LoginModel loginModel) {
        try {
            if (listUserRepository.checkID(id) == 0) {
                return BaseResponse.builder("Data Tidak Ditemukan", HttpStatus.BAD_REQUEST, null);
            }
            int statusUsername = listUserRepository.checkUsername(loginModel.getUsername());
            if (statusUsername == 1) {
                return BaseResponse.builder("Username Sudah Terpakai", HttpStatus.CONFLICT, null);
            }

            String statusPassword = listUserRepository.checkPassword(id);
            if (statusPassword.equals(loginModel.getPassword())) {
                return BaseResponse.builder("Password Tidak Boleh Sama", HttpStatus.CONFLICT, null);
            }

            Optional<LoginModel> checkID = listUserRepository.findById(id);
            checkID.get().setId(id);
            checkID.get().setUsername(loginModel.getUsername());
            checkID.get().setPassword(loginModel.getPassword());

            listUserRepository.save(checkID.get());
            return BaseResponse.builder("Sukses", HttpStatus.OK, null);

        } catch (Exception e) {
            log.error("Gagal Update {0}", e);
            return BaseResponse.builder("Gagal", HttpStatus.INTERNAL_SERVER_ERROR, null);
        }
    }
}
