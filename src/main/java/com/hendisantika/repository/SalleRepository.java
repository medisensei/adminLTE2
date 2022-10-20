package com.hendisantika.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.hendisantika.entity.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long> {

	List<Salle> findByNumero(@RequestParam("numero") int numero );
}
