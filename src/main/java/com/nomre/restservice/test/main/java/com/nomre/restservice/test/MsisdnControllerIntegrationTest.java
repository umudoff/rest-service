package main.java.com.nomre.restservice.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.com.nomre.restservice.Controller.MSISDNController;
import main.java.com.nomre.restservice.Model.Customer;
import main.java.com.nomre.restservice.Repository.CustomerRepository;
import main.java.com.nomre.restservice.RestServiceApplication;
import main.java.com.nomre.restservice.Service.ReservationService;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.ResourceUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = MSISDNController.class)
public class MsisdnControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CustomerRepository userRepository;


    @Test
   public void whenValidInput_thenMapsToBusinessModel() throws Exception {

/* to be done
        mockMvc.perform(MockMvcRequestBuilders.get("/search", 42L)
                .param("category", "all")
                .param("msisdn", "99XXXXX17"))
                .andExpect(status().isOk());
        */

    }






}
