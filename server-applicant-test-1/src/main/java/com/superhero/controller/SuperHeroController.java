package com.superhero.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.superhero.controller.mapper.SuperHeroMapper;
import com.superhero.datatransferobject.SuperHeroDTO;
import com.superhero.domainobject.SuperHeroDO;
import com.superhero.exception.ConstraintsViolationException;
import com.superhero.exception.EntityNotFoundException;
import com.superhero.service.SuperHeroService;

/**
 * Super Hero Rest API.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@RestController
@RequestMapping("/superhero")
public class SuperHeroController {
	
	/** Super Hero Service*/
	@Autowired
	private SuperHeroService service;
	
	@Autowired
	public SuperHeroController(final SuperHeroService service) {
		this.service = service;
	}
	/**
	 * get Super Hero by ID.
	 * 
	 * @param id
	 * @return SuperHeroDTO
	 * @throws EntityNotFoundException
	 */
	@GetMapping("/find/{id}")
	public SuperHeroDTO get(@Valid @PathVariable long id)
			throws EntityNotFoundException {
		return SuperHeroMapper.makeSuperHeroDTO(service.find(id));
	}
	/**
	 * Create Super Hero.
	 * 
	 * @param superHeroDTO
	 * @return SuperHeroDTO
	 * @throws ConstraintsViolationException
	 */
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public SuperHeroDTO create(@Valid @RequestBody SuperHeroDTO superHeroDTO)
			throws ConstraintsViolationException {
		SuperHeroDO superHeroDO = SuperHeroMapper.makeSuperHeroDO(superHeroDTO);
		return SuperHeroMapper.makeSuperHeroDTO(service.create(superHeroDO));
	}
	/**
	 * Retrieve all super heros.
	 * 
	 * @return List<SuperHeroDTO>
	 * @throws ConstraintsViolationException
	 *             , EntityNotFoundException
	 */
	@GetMapping("/find")
	public List<SuperHeroDTO> find()
			throws ConstraintsViolationException, EntityNotFoundException {
		return SuperHeroMapper.makeSuperHeroDTOList(service.findAll());
	}
}