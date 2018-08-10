package com.superhero.domainobject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * Publisher Domain Object.
 * 
 * @author Ahmed ElGamal
 * @version 1.0
 * @since 08.08.2018
 */
@Entity
@Table(name = "publisher", uniqueConstraints = @UniqueConstraint(name = "name", columnNames = { "publisher_name" }))
public class PublisherDO {
	@Id
	@GeneratedValue
	@Column(name = "publisher_id")
	private Long id;

	@Column(name = "publisher_name", nullable = false)
	@NotNull(message = "Name can not be null!")
	private String name;

	/**
	 * Default Constructor
	 */
	public PublisherDO() {
	}
	/**
	 * Constructor
	 * @param name
	 */
	public PublisherDO(String name) {
		this.name = name;
	}
	/**
	 * Get ID
	 * @return Long
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Set ID
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Get Name
	 * @return String
	 */
	public String getName() {
		return name;
	}
	/**
	 * Set Name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
}