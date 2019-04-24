package br.senai.sc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.senai.sc.domain.Festa;

@Repository
public interface FestaRepository extends JpaRepository<Festa, Integer>{

}