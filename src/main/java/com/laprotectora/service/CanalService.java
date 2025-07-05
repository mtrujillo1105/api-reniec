package com.laprotectora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laprotectora.entity.Canal;
import com.laprotectora.repository.ICanalRepository;

@Service
public class CanalService {

	@Autowired
	private ICanalRepository repository;
	
	public Canal saveCanal(Canal inmueble) {
		return repository.save(inmueble);
	}
	
	public List<Canal> saveCanales(List<Canal> inmuebles){
		return repository.saveAll(inmuebles);
	}
	
	public List<Canal> getCaneles(){
		return repository.findAll();
	}
	
	public Optional<Canal> getCanalById(Integer id) {
		return repository.findById(id);
	}
	
	public List<Canal> getCanalByEmpresa(String empresa) {
		return repository.findByEmpresa(empresa);
	}

	public String deleteCanal(Integer id) {
		repository.deleteById(id);
		return "block removed !! " + id;
	}
	
	public Canal updateCanal(Canal inmueble) {
		Canal existBlock = repository.findById(inmueble.getId()).orElse(inmueble);
		existBlock.setDescripcion(inmueble.getDescripcion());
		existBlock.setEstado(inmueble.getEstado());
		return repository.save(existBlock);
	}
}
