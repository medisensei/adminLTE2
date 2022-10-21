package com.hendisantika.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Film extends AbstractModel {/**
	 * 
	 */
	private static final long serialVersionUID = -3069653192725569123L;
	
	@Column(nullable = false,length = 100)
	private String title;
	
	@Column(nullable = false)
	private int duree;
	
	@Column(nullable = true)
	private String photo;
	
	@Column(nullable = false)
	private int annee;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "GENRE_ID")
	private Genre genre;
	
	@OneToMany(mappedBy = "film",fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Seance> seances;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "NATIONALITE_ID")
	private Nationalite nationalite;
	
	@ManyToMany
	@JoinTable(
		name = "FILM_ACTEUR",
		joinColumns =@JoinColumn(name="ACTEUR_ID",referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name="FILM_ID",referencedColumnName = "ID")
	)
	@JsonIgnore
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Personne> acteurs;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "REALISATEUR_ID")
	@JsonIgnore
	private Personne realisateur;

}
