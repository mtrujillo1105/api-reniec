package com.laprotectora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laprotectora.entity.Empresa;

@Repository
public interface IEmpresaRepository extends JpaRepository<Empresa,Integer>{

}
