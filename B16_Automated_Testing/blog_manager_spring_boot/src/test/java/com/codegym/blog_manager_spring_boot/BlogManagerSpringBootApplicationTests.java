package com.codegym.blog_manager_spring_boot;

import com.codegym.blog_manager_spring_boot.model.User;
import com.codegym.blog_manager_spring_boot.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class BlogManagerSpringBootApplicationTests {
    private User user;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp()
    {
        user = new User();
        user.setIdUser(1l);
        user.setFirstName("Virat");
        user.setLastName("RCB");
    }

    @Test
    public void userCreationTest() throws Exception {
        when(userRepository.findById(user.getIdUser())).thenReturn(java.util.Optional.ofNullable(user));
        ObjectMapper mapper = new ObjectMapper();
        String transactionString = mapper.writeValueAsString(user);

        MvcResult result = mockMvc.perform(post("/users/load").content(transactionString).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();
        String responseUser = result.getResponse().getContentAsString();

        JSONAssert.assertEquals(responseUser, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void findAllUsersTest() throws Exception {
        List<User> users = new ArrayList<>();
        users.add(user);

        when(userRepository.findAll()).thenReturn(users);

        MvcResult result = mockMvc.perform(get("/users")).andExpect(status().isOk()).andReturn();
        JSONAssert.assertEquals(new ObjectMapper().writeValueAsString(users),
                result.getResponse().getContentAsString(), false);
    }


}
