package com.superhero.api;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.superhero.controller.SuperHeroController;
import com.superhero.domainobject.PublisherDO;
import com.superhero.domainobject.SkillDO;
import com.superhero.domainobject.SuperHeroDO;
import com.superhero.service.SuperHeroService;

@RunWith(SpringRunner.class)
@WebMvcTest(SuperHeroController.class)
public class SuperHeroApplicationTest {
	
	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private SuperHeroService service;
    
	@Test
	public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
	  throws Exception {
	     
		PublisherDO publisher = new PublisherDO();
		publisher.setId(new Long(1));
		publisher.setName("DC");
		SuperHeroDO superHero = new SuperHeroDO("SH 1", publisher, new ArrayList<SkillDO>());
		
	    List<Employee> allEmployees = Arrays.asList(alex);
	 
	    given(service.getAllEmployees()).willReturn(allEmployees);
	 
	    mvc.perform(get("/api/employees")
	      .contentType(MediaType.APPLICATION_JSON))
	      .andExpect(status().isOk())
	      .andExpect(jsonPath("$", hasSize(1)))
	      .andExpect(jsonPath("$[0].name", is(alex.getName())));
	}

}
