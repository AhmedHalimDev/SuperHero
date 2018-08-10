package com.superhero.controller.mapper;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.superhero.datatransferobject.SuperHeroDTO;
import com.superhero.domainobject.AlliesDO;
import com.superhero.domainobject.PublisherDO;
import com.superhero.domainobject.SkillDO;
import com.superhero.domainobject.SuperHeroDO;

/**
 * Super Hero Mapper for mapping Data Object to Data Transfer Objects and vice versa.
 * <p/>
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
public class SuperHeroMapper {

	/**
	 * Mapping DTO to DO.
	 * 
	 * @param superHeroDTO
	 * @return SuperHeroDO
	 */
	public static SuperHeroDO makeSuperHeroDO(SuperHeroDTO superHeroDTO) {
		SuperHeroDO superHeroDO = new SuperHeroDO(superHeroDTO.getName(), superHeroDTO.getPublisher(), superHeroDTO.getSkills());
		superHeroDO.setAllies(superHeroDTO.getAllies());
		superHeroDO.setPseudonym(superHeroDTO.getPseudonym());
		superHeroDO.setDateCreated(ZonedDateTime.ofInstant(superHeroDTO.getDateCreated().toInstant(),ZoneId.systemDefault()));
		return superHeroDO;
	}

	/**
	 * Mapping DO to DTO.
	 * 
	 * @param superHeroDO
	 * @return SuperHeroDTO
	 */
	public static SuperHeroDTO makeSuperHeroDTO(SuperHeroDO superHeroDO) {
		SuperHeroDTO.SuperHeroDTOBuilder superHeroDTOBuilder = SuperHeroDTO.newBuilder()
				.setId(superHeroDO.getId()).setName(superHeroDO.getName());
		PublisherDO publisher = superHeroDO.getPublisher();
		if (publisher != null) {
			superHeroDTOBuilder.setPublisher(publisher);
		}
		List<SkillDO> skills = superHeroDO.getSkills();
		if(skills != null && skills.size() > 0) {
			superHeroDTOBuilder.setSkills(skills);
		}else {
			superHeroDTOBuilder.setSkills(new ArrayList<SkillDO>());
		}
		List<AlliesDO> allies = superHeroDO.getAllies();
		if(allies != null && allies.size() > 0) {
			superHeroDTOBuilder.setAllies(allies);
		}
		superHeroDTOBuilder.setPseudonym(superHeroDO.getPseudonym());
		superHeroDTOBuilder.setDateCreated(Date.from(superHeroDO.getDateCreated().toInstant()));
		return superHeroDTOBuilder.createSuperHeroDTO();
	}

	/**
	 * Mapping list of DTO from DO.
	 * 
	 * @param superHeros
	 * @return List<SuperHeroDTO>
	 */
	public static List<SuperHeroDTO> makeSuperHeroDTOList(Collection<SuperHeroDO> superHeros) {
		 return superHeros.stream()
		 .map(SuperHeroMapper::makeSuperHeroDTO)
		 .collect(Collectors.toList());
	}
}
