package com.app.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * arugji CIS175 fall 2021 Oct 5
 */

@Entity
@Table(name = "ListDetails")
public class ListDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "listName", length = 100, nullable = false)
	private String listName;

	@Column(name = "tripDate")
	private LocalDate tripDate;

	@ManyToOne(fetch = FetchType.EAGER)
	private Shopper shopper;

	@OneToMany(fetch = FetchType.EAGER)
	private List<ListItem> listOfItems;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public LocalDate getTripDate() {
		return tripDate;
	}

	public void setTripDate(LocalDate tripDate) {
		this.tripDate = tripDate;
	}

	public Shopper getShopper() {
		return shopper;
	}

	public void setShopper(Shopper shopper) {
		this.shopper = shopper;
	}

	public List<ListItem> getListOfItems() {
		if (Objects.isNull(listOfItems)) {
			listOfItems = new ArrayList<ListItem>();
		}
		return listOfItems;
	}

	public void setListOfItems(List<ListItem> listOfItems) {
		this.listOfItems = listOfItems;
	}

}
