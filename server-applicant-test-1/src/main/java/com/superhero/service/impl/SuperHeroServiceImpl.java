package com.superhero.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.superhero.dataaccessobject.AlliesRepository;
import com.superhero.dataaccessobject.SuperHeroRepository;
import com.superhero.domainobject.AlliesDO;
import com.superhero.domainobject.SuperHeroDO;
import com.superhero.exception.ConstraintsViolationException;
import com.superhero.service.SuperHeroService;

/**
 * Service to encapsulate the link between DAO and controller and to have
 * business logic for some super hero specific things.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@Service
public class SuperHeroServiceImpl implements SuperHeroService {

	private static org.slf4j.Logger LOG = LoggerFactory.getLogger(SuperHeroServiceImpl.class);
	@Autowired
	private SuperHeroRepository superHeroRepository;
	@Autowired
	private AlliesRepository alliesRepository;

	/**
	 * Selects a super hero by id...
	 * 
	 * @param id
	 * @return SuperHeroDO
	 * @throws EntityNotFoundException if no super hero with the given id was found.
	 */
	@Override
	public SuperHeroDO find(Long id) throws EntityNotFoundException {
		return findSuperHeroChecked(id);
	}
	/**
	 * Find Super Hero...
	 * @param id
	 * @return SuperHeroDO
	 * @throws EntityNotFoundException
	 */
	private SuperHeroDO findSuperHeroChecked(Long id) throws EntityNotFoundException {
		SuperHeroDO superHeroDO = superHeroRepository.findOne(id);
		if (superHeroDO == null) {
			throw new EntityNotFoundException("Could not find entity with id: " + id);
		}
		return superHeroDO;
	}
	/**
	 * Creates a new super hero.
	 * 
	 * @param superHeroDO
	 * @return SuperHeroDO
	 * @throws ConstraintsViolationException if a super hero already exists with the given name, ... .
	 */
	@Override
	public SuperHeroDO create(SuperHeroDO superHeroDO) throws ConstraintsViolationException {
		SuperHeroDO superHero;
		try {
			superHero = superHeroRepository.save(superHeroDO);
			if(superHeroDO.getAllies() != null && superHeroDO.getAllies().size() > 0) {
				for(AlliesDO alliesDO : superHeroDO.getAllies()) {
					alliesRepository.save(new AlliesDO(alliesDO.getName(), superHero));
				}
			}
		} catch (DataIntegrityViolationException e) {
			LOG.warn("Some constraints are thrown due to super hero creation", e);
			throw new ConstraintsViolationException(e.getMessage());
		}
		return superHero;
	}
	/**
	 * Find all super hero list.
	 * 
	 * @return List<SuperHeroDO>
	 */
	@Override
	public List<SuperHeroDO> findAll() {
		List<SuperHeroDO> superHeros = new ArrayList<SuperHeroDO>();
		Iterator<SuperHeroDO> items = superHeroRepository.findAll().iterator();
		while (items.hasNext()) {
			superHeros.add(items.next());
		}
		return superHeros;
	}
}
