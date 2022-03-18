package ist.challenge.ist.challenge.rendikaperlyanza.service;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.domains.dao.LoginModel;
import ist.challenge.ist.challenge.rendikaperlyanza.repository.ListUserRepository;
import ist.challenge.ist.challenge.rendikaperlyanza.services.ListUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.NotNull;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListUserServiceTest {
    @InjectMocks
    private ListUserService listUserService;

    @Mock
    private  ListUserRepository listUserRepository;

    @Mock
    private LoginModel loginModel;

    @Before
    public void before(){
        loginModel = LoginModel.builder().username("admin").password("P@ssw0rd").build();
    }

    @Test
    public void getDataSuccess(){
        BaseResponse res = listUserService.getData();
        var value = res.getResponseKey();
        assertEquals("Sukses",value);
    }
    @Test
    public void getUpdateSuccess(){
        Assert.assertNotNull(listUserService.updateData(anyLong(),LoginModel.builder().username(any()).password(any()).Id(anyLong()).build()));

    }
    @Test
    public void getUpdateFail(){
        int statusID = 0;
        when(listUserRepository.checkID(anyLong())).thenReturn(statusID);
        var data = listUserRepository.checkID(anyLong());
        assertEquals(statusID,data);
    }
}
