package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Tema;
import br.senai.sc.repositories.TemaRepository;
import br.senai.sc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class TemaService {
	
	@Autowired
	private TemaRepository repo;
	
	public List<Tema> listarTodos() {
		return repo.findAll();
	}

	public Tema buscarPorId(Integer id) {
		Optional<Tema> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Tema não encontrado."));
	}

	public void delete(Integer id) {
		buscarPorId(id);
		repo.deleteById(id);
	}

	public void update(Tema obj) {
		buscarPorId(obj.getId());
		repo.save(obj);
	}

	public void insert(Tema obj) {
		obj.setId(null);
		repo.save(obj);
	}

}
