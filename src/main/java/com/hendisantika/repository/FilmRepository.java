package com.hendisantika.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hendisantika.entity.Film;

@Repository
public interface FilmRepository extends JpaRepository<Film,Long> {

}
