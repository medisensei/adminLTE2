package com.hendisantika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.hendisantika.entity.Nationalite;

@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite,Long> {
	
	List<Nationalite> findByLibelleContaining(@RequestParam("libelle") String libelle);

}
