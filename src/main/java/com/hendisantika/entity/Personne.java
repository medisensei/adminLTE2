package com.hendisantika.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hendisantika.enums.TypePersonne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor 
public class Personne extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5857273707909009389L;
	
	@Column(nullable = false,length = 50)
	private String nom;
	
	@Column(nullable = false,length = 50)
	private String prenom;

	@Column(nullable = true,length = 100)
	private String photo;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance;
	
	@Column(nullable = false,length = 50)
	@Enumerated(EnumType.STRING)
	private TypePersonne typePersonne;
	
	@Column(name = "added_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
			insertable = false,updatable = false)
	private Date addedDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NATIONALITE_ID")
	private Nationalite nationalite;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(mappedBy = "acteurs")
	@JsonIgnore
	private List<Film> films;
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy = "realisateur")
	@JsonIgnore
	private List<Film> filmsRealises;
	
	

}
