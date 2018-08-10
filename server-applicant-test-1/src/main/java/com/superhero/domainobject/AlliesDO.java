package com.superhero.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Allies Domain Object.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@Entity
@Table(name = "allies")
public class AlliesDO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "allies_id")
	private Long id;

	@Column(name = "allies_name", nullable = false)
	@NotNull(message = "Name can not be null!")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "super_hero_id")
	private SuperHeroDO superHero;

	/**
	 * Default Constructor
	 */
	public AlliesDO() {
	}
	/**
	 * Constructor
	 * @param name
	 * @param superHero
	 */
	public AlliesDO(String name, SuperHeroDO superHero) {
		this.name = name;
		this.superHero = superHero;
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