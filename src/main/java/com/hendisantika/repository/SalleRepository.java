package com.hendisantika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendisantika.entity.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle,Long> {

}
