package com.superhero.domainobject;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * Super Hero DO
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@Entity
@Table(name = "super_hero")
public class SuperHeroDO {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(nullable = false)
	@NotNull(message = "Name can not be null!")
	private String name;
	
	@Column
	private String pseudonym;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "publisher_id")
	private PublisherDO publisher;
	
	@ManyToMany(cascade = CascadeType.MERGE, fetch=FetchType.EAGER)
    @Fetch(value=FetchMode.SELECT)
    @JoinTable(name="super_hero_skills", joinColumns=@JoinColumn(name="super_hero_id"), inverseJoinColumns=@JoinColumn(name="skill_id"))
	private List<SkillDO> skills;
	
	@OneToMany(mappedBy = "superHero", cascade = CascadeType.MERGE)
	private List<AlliesDO> allies = new ArrayList<AlliesDO>();
	
	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private ZonedDateTime dateCreated = ZonedDateTime.now();
	
	/**
	 * Default Constructor
	 */
	public SuperHeroDO() {}
	/**
	 * Constructor.
	 * @param name
	 * @param publisher
	 */
	public SuperHeroDO(String name, PublisherDO publisher, List<SkillDO> skills) {
		this.name = name;
		this.publisher = publisher;
		this.skills = skills;
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
	/**
	 * @return String
	 */
	public String getPseudonym() {
		return pseudonym;
	}
	/**
	 * @param pseudonym
	 */
	public void setPseudonym(String pseudonym) {
		this.pseudonym = pseudonym;
	}
	/**
	 * @return PublisherDO
	 */
	public PublisherDO getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher
	 */
	public void setPublisher(PublisherDO publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return List
	 */
	public List<SkillDO> getSkills() {
		return skills;
	}
	/**
	 * @param skills
	 */
	public void setSkills(List<SkillDO> skills) {
		this.skills = skills;
	}
	/**
	 * @return List
	 */
	public List<AlliesDO> getAllies() {
		return allies;
	}
	/**
	 * @param allies
	 */
	public void setAllies(List<AlliesDO> allies) {
		this.allies = allies;
	}
	/**
	 * @return ZonedDateTime
	 */
	public ZonedDateTime getDateCreated() {
		return dateCreated;
	}
	/**
	 * @param dateCreated
	 */
	public void setDateCreated(ZonedDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}
}