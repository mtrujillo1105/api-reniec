package com.laprotectora.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laprotectora.repository.IEmpresaRepository;
import com.laprotectora.entity.Empresa;

@Service
public class EmpresaService {

	@Autowired
	private IEmpresaRepository repository;
	
	public Empresa saveEmpresa(Empresa inmueble) {
		return repository.save(inmueble);
	}
	
	public List<Empresa> saveEmpresas(List<Empresa> inmuebles){
		return repository.saveAll(inmuebles);
	}
	
	public List<Empresa> getEmpresas(){
		return repository.findAll();
	}
	
	public Optional<Empresa> getEmpresaById(Integer id) {
		return repository.findById(id);
	}

	public String deleteEmpresa(Integer id) {
		repository.deleteById(id);
		return "block removed !! " + id;
	}
	
	public Empresa updateEmpresa(Empresa inmueble) {
		Empresa existBlock = repository.findById(inmueble.getId()).orElse(inmueble);
		existBlock.setDescripcion(inmueble.getDescripcion());
		existBlock.setEstado(inmueble.getEstado());
		return repository.save(existBlock);
	}
}
