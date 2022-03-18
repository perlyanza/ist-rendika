package ist.challenge.ist.challenge.rendikaperlyanza.controller;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.services.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private LoginService loginService;

    @Before
    public void beforeEachTest() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void LoginSuccess() throws Exception {
        Mockito.when(loginService.loginFunc(Mockito.any())).thenReturn(
                BaseResponse.builder("Login Sukses", HttpStatus.OK,null)
        );
        mockMvc.perform(post("/login").characterEncoding("utf-8").contentType(MediaType.APPLICATION_JSON).content("{}")).andExpect(status().isOk()).andReturn();
    }
}
