package com.superhero.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Skills Domain Object.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@Entity
@Table(name = "skills")
public class SkillDO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "skill_id")
	private Long id;

	@Column(name = "skill_name", nullable = false)
	@NotNull(message = "Name can not be null!")
	private String name;

	/**
	 * Default Constructor
	 */
	public SkillDO() {
	}
	/**
	 * Constructor
	 * @param name
	 */
	public SkillDO(String name) {
		this.name = name;
	}
	/**
	 * @return Long
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}