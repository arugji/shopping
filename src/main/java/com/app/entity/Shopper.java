package com.app.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * arugji CIS175 fall 2021 Oct 5
 */

@Entity
@Table(name = "Shopper")
public class Shopper {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "shopperName", length = 100, nullable = false)
	private String shopperName;

	@Column(name = "createdOn")
	private LocalDate createdOn = LocalDate.now();

	public Shopper() {
	}

	public Shopper(long id, String shopperName, LocalDate createdOn) {
		this.id = id;
		this.shopperName = shopperName;
		this.createdOn = createdOn;
	}

	public Shopper(String shopperName) {
		this.shopperName = shopperName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getShopperName() {
		return shopperName;
	}

	public void setShopperName(String shopperName) {
		this.shopperName = shopperName;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

}
