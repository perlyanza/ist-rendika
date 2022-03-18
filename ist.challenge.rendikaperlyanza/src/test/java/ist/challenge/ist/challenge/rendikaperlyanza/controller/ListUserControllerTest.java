package ist.challenge.ist.challenge.rendikaperlyanza.controller;

import ist.challenge.ist.challenge.rendikaperlyanza.common.BaseResponse;
import ist.challenge.ist.challenge.rendikaperlyanza.services.ListUserService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ListUserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private ListUserService listUserService;

    @Before
    public void beforeEachTest() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getDataSuccess() throws Exception {
        var data = listUserService.getData();
        Mockito.when(listUserService.getData()).thenReturn(
                BaseResponse.builder("Sukses", HttpStatus.OK,data)
        );
        mockMvc.perform(get("/listuser").characterEncoding("utf-8").contentType(MediaType.APPLICATION_JSON).content("{}")).andExpect(status().isOk()).andReturn();
    }
    @Test
    public void upDateData() throws Exception {

        Mockito.when(listUserService.updateData(Mockito.any(),Mockito.any())).thenReturn(
                BaseResponse.builder("Sukses", HttpStatus.OK,null)
        );
        mockMvc.perform(get("/listuser").characterEncoding("utf-8").contentType(MediaType.APPLICATION_JSON).content("{}")).andExpect(status().isOk()).andReturn();
    }
}
