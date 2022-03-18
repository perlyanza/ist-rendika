package ist.challenge.ist.challenge.rendikaperlyanza.service;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import ist.challenge.ist.challenge.rendikaperlyanza.repository.LoginRepository;
import ist.challenge.ist.challenge.rendikaperlyanza.services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoginServiceTest {
    @InjectMocks
    private LoginService loginService;

    @Mock
    private LoginRepository loginRepository;

    @Test
    public void loginSuccess(){
        int status = 1;
        when(loginRepository.checkingUserPass(any(),any())).thenReturn(status);
        BaseResponse result = loginService.loginFunc(LoginModel.builder().username("admin").password("P@ssw0rd").Id(1L).build());
        var res = result.getResponseKey();
        assertNotNull(res);
        assertEquals("Login Sukses",res);
    }
    @Test
    public void loginFailedCheckingDB(){
        int status = 0;
        when(loginRepository.checkingUserPass(any(),any())).thenReturn(status);
        BaseResponse result = loginService.loginFunc(LoginModel.builder().username("admin").password("P@ssw0rd").Id(1L).build());
        var res = result.getResponseKey();
        assertNotNull(res);
        assertEquals("Username / Password Salah",res);
    }
    @Test
    public void loginFailedCheckingField(){
        BaseResponse result = loginService.loginFunc(LoginModel.builder().username(null).password(null).Id(1L).build());
        var res = result.getResponseKey();
        assertNotNull(res);
        assertEquals("Username dan / atau Password Kosong",res);
    }
}
