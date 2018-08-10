package com.superhero.datatransferobject;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.superhero.domainobject.AlliesDO;
import com.superhero.domainobject.PublisherDO;
import com.superhero.domainobject.SkillDO;

/**
 * Super Hero Data Transfer Object.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SuperHeroDTO {
	@JsonIgnore
	private Long id;

	@NotNull(message = "Name can not be null!")
	private String name;

	@NotNull(message = "Publisher can not be null!")
	private PublisherDO publisher;
	
	@NotNull(message = "Skills can not be null!")
	private List<SkillDO> skills;
	
	@NotNull(message = "Date can not be null!")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date dateCreated;
	
	private List<AlliesDO> allies;
	private String pseudonym;
	
	/**
	 * Default Constructor.
	 * 
	 */
	private SuperHeroDTO() {
	}
	/**
	 * Constructor
	 * @param id
	 * @param name
	 * @param publisher
	 * @param skills
	 * @param allies
	 * @param pseudonym
	 * @param dateCreated
	 */
	private SuperHeroDTO(Long id, String name, PublisherDO publisher, List<SkillDO> skills, List<AlliesDO> allies, String pseudonym, Date dateCreated) {
		this.id = id;
		this.name = name;
		this.publisher = publisher;
		this.skills = skills;
		this.allies = allies;
		this.pseudonym = pseudonym;
		this.dateCreated = dateCreated;
	}
	/**
	 * Initializing.
	 * 
	 * @return SuperHeroDTOBuilder
	 */
	public static SuperHeroDTOBuilder newBuilder() {
		return new SuperHeroDTOBuilder();
	}
	/**
	 * @return Long
	 */
	@JsonProperty
	public Long getId() {
		return id;
	}
	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return PublisherDO
	 */
	public PublisherDO getPublisher() {
		return publisher;
	}
	/**
	 * @return List
	 */
	public List<SkillDO> getSkills() {
		return skills;
	}
	/**
	 * @return List
	 */
	public List<AlliesDO> getAllies() {
		return allies;
	}
	/**
	 * @return String
	 */
	public String getPseudonym() {
		return pseudonym;
	}
	/**
	 * @return Date
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	/**
	 * Class for building a Super Hero DTO.
	 * 
	 */
	public static class SuperHeroDTOBuilder {
		
		private Long id;
		private String name;
		private PublisherDO publisher;
		private List<SkillDO> skills;
		private List<AlliesDO> allies;
		private String pseudonym;
		private Date dateCreated;

		/**
		 * @param id
		 * @return SuperHeroDTOBuilder
		 */
		public SuperHeroDTOBuilder setId(Long id) {
			this.id = id;
			return this;
		}
		/**
		 * @param name
		 * @return SuperHeroDTOBuilder
		 */
		public SuperHeroDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}
		/**
		 * @param publisher
		 * @return SuperHeroDTOBuilder
		 */
		public SuperHeroDTOBuilder setPublisher(PublisherDO publisher) {
			this.publisher = publisher;
			return this;
		}
		/**
		 * @param skills
		 * @return SuperHeroDTOBuilder
		 */
		public SuperHeroDTOBuilder setSkills(List<SkillDO> skills) {
			this.skills = skills;
			return this;
		}
		/**
		 * @param allies
		 * @return SuperHeroDTOBuilder
		 */
		public SuperHeroDTOBuilder setAllies(List<AlliesDO> allies) {
			this.allies = allies;
			return this;
		}
		/**
		 * @param pseudonym
		 */
		public SuperHeroDTOBuilder setPseudonym(String pseudonym) {
			this.pseudonym = pseudonym;
			return this;
		}
		/**
		 * @param dateCreated
		 */
		public SuperHeroDTOBuilder setDateCreated(Date dateCreated) {
			this.dateCreated = dateCreated;
			return this;
		}
		/**
		 * Create Super Hero DTO.
		 * 
		 * @return SuperHeroDTO
		 */
		public SuperHeroDTO createSuperHeroDTO() {
			return new SuperHeroDTO(id, name, publisher, skills, allies, pseudonym, dateCreated);
		}
	}
}