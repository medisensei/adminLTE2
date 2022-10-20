package com.hendisantika.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hendisantika.entity.Nationalite;
import com.hendisantika.repository.NationaliteRepository;

@Service
public class NationaliteService {
	NationaliteRepository nationaliteRepository;
	public NationaliteService(NationaliteRepository nationaliteRepository) {
		this.nationaliteRepository=nationaliteRepository;
	}
	
	public List<Nationalite> getList(){
		return nationaliteRepository.findAll();
	}
	
	public List<Nationalite> getFilteredList(String filter){
		
		return nationaliteRepository.findByLibelleContaining(filter);
	}
	
	
	
	public Nationalite getNationalite(Long ID) {
		return nationaliteRepository.findById(ID)
				.orElse(new Nationalite());
	}
	public Nationalite save(Nationalite nationalite) {
		return nationaliteRepository.save(nationalite);
	}
	public void delete(Long ID) {
		nationaliteRepository.deleteById(ID);
	}

}
