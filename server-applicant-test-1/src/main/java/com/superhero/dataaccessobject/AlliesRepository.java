package com.superhero.dataaccessobject;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.superhero.domainobject.AlliesDO;

/**
 * Database Access Object for allies table.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@Repository
public interface AlliesRepository extends CrudRepository<AlliesDO, Long> {

}
