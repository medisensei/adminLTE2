package com.hendisantika.repository;

import java.util.Date;
import java.util.List;


import javax.persistence.TemporalType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;



import com.hendisantika.entity.Seance;

@Repository
public interface SeanceRepository extends JpaRepository<Seance,Long> {
	
	List<Seance> findByDateProjection(@Temporal(TemporalType.DATE)  Date dateProjection);
	
}
