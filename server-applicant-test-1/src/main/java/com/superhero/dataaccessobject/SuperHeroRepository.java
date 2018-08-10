package com.superhero.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.superhero.domainobject.SuperHeroDO;

/**
 * Database Access Object for super hero table.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@Repository
public interface SuperHeroRepository extends CrudRepository<SuperHeroDO, Long> {

}
