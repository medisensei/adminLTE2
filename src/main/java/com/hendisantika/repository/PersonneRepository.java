package com.hendisantika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendisantika.entity.Personne;

@Repository
public interface PersonneRepository extends JpaRepository<Personne,Long> {

}
