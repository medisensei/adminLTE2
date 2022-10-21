package com.hendisantika.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.hendisantika.repository.SeanceRepository;
import com.hendisantika.entity.Seance;



@Service
@Transactional
public class SeanceService extends AbstractService<Seance>  {
	
	
	SeanceRepository seanceRepository;

	
	public SeanceService(SeanceRepository seanceRepository) {
		
		this.seanceRepository = seanceRepository;
	}
	
	@Override
	protected JpaRepository<Seance, Long> getRepository() {
		
		return seanceRepository;
		
	}
	
public List<Seance> getFilteredList(Date filter){
		
		
		return seanceRepository.findByDateProjection(filter);
	}




}
