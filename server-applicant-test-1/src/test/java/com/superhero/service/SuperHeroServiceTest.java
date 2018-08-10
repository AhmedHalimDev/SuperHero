package com.superhero.service;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.superhero.dataaccessobject.AlliesRepository;
import com.superhero.dataaccessobject.SuperHeroRepository;
import com.superhero.domainobject.PublisherDO;
import com.superhero.domainobject.SkillDO;
import com.superhero.domainobject.SuperHeroDO;
import com.superhero.service.impl.SuperHeroServiceImpl;

@RunWith(SpringRunner.class)
public class SuperHeroServiceTest {
	
	@Autowired
    private SuperHeroService superHeroService;
    @MockBean
    private SuperHeroRepository superHeroRepository;
    @MockBean
    private AlliesRepository alliesRepository;
    
	@TestConfiguration
    static class SuperHeroServiceImplTestContextConfiguration {
        @Bean
        public SuperHeroService superHeroService() {
            return new SuperHeroServiceImpl();
        }
    }
	
	@Before
	public void setUp() {
		PublisherDO publisher = new PublisherDO();
		publisher.setId(new Long(1));
		publisher.setName("DC");
	    SuperHeroDO superHero = new SuperHeroDO("SH 1", publisher, new ArrayList<SkillDO>());
	    
	    
	    Mockito.when(superHeroRepository.save(superHero))find(superHero)).thenReturn(superHero);
	}

}
