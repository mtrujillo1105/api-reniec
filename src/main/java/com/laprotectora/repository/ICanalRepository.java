package com.laprotectora.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laprotectora.entity.Canal;


@Repository
public interface ICanalRepository extends JpaRepository<Canal,Integer>{
	List<Canal> findByEmpresa(String empresa);
}
