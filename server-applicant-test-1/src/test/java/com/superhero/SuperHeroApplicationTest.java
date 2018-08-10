package com.superhero;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.superhero.service.SuperHeroService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SuperHeroApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
public class SuperHeroApplicationTest {
	
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private SuperHeroService service;
    
    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
      throws Exception {
     
        mvc.perform(get("/superhero/create")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(content()
          .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
          .andExpect(jsonPath("$[0].name", is("bob")));
    }
}