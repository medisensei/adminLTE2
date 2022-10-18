package com.hendisantika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendisantika.entity.Seance;

@Repository
public interface SeanceRepository extends JpaRepository<Seance,Long> {
	
}
