package com.hendisantika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendisantika.entity.Nationalite;

@Repository
public interface NationaliteRepository extends JpaRepository<Nationalite,Long> {

}
