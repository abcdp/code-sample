package com.charter.enterprise.motd;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MotdControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getMotd() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(MotdController.DEFAULT_MESSAGE)));
    }

    @Test
    public void setMotd() throws Exception {
        String newMessage = "testMessage";
        MessageResource resource = new MessageResource(newMessage, MotdController.SECURITY_KEY);
        ObjectMapper mapper = new ObjectMapper();
        String resourceJson = mapper.writeValueAsString(resource);
        mvc.perform(MockMvcRequestBuilders.post("/")
                .content(resourceJson));
//                .andExpect(content().string("Message changed successfully."));
        mvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk()).andExpect(content().string(newMessage));


    }



}
