package com.superhero.service;

import java.util.List;

import com.superhero.domainobject.SuperHeroDO;
import com.superhero.exception.ConstraintsViolationException;
import com.superhero.exception.EntityNotFoundException;

/**
 * Service interface to encapsulate the link between DAO and controller and to
 * have business logic for some super hero specific things.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
public interface SuperHeroService {
	/**
	 * Find super hero by id.
	 * 
	 * @param id
	 * @return SuperHeroDO
	 * @throws EntityNotFoundException
	 */
	SuperHeroDO find(Long id) throws EntityNotFoundException;
	/**
	 * Create super hero entity.
	 * 
	 * @param superHeroDO
	 * @return SuperHeroDO
	 * @throws ConstraintsViolationException
	 */
	SuperHeroDO create(SuperHeroDO superHeroDO) throws ConstraintsViolationException;
	/**
	 * Find all super hero list.
	 * 
	 * @return List<SuperHeroDO>
	 */
	List<SuperHeroDO> findAll();
}
