package ist.challenge.ist.challenge.rendikaperlyanza.service;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import ist.challenge.ist.challenge.rendikaperlyanza.repository.RegistrationRepository;
import ist.challenge.ist.challenge.rendikaperlyanza.services.RegistrationService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RegistrationServiceTest {
    @InjectMocks
    private RegistrationService registrationService;

    @Mock
    private RegistrationRepository registrationRepository;

    @Test
    public void successRegistration(){
        var status = 0;
        when(registrationRepository.checkUser(any())).thenReturn(status);
        BaseResponse res = registrationService.registerFunc(LoginModel.builder()
                .username("admin")
                .password("P@ssw0rd")
                .build());
        var result = res.getResponseKey();
        assertEquals("Sukses",result);
    }
    @Test
    public void failedRegistration(){
        var status = 1;
        when(registrationRepository.checkUser(any())).thenReturn(status);
        BaseResponse res = registrationService.registerFunc(LoginModel.builder()
                .username("admin")
                .password("P@ssw0rd")
                .build());
        var result = res.getResponseKey();
        assertEquals("Username Sudah Terpakai",result);
    }
}
