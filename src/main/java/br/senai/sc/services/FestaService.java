package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Festa;
import br.senai.sc.repositories.FestaRepository;
import br.senai.sc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class FestaService {
	
	@Autowired
	private FestaRepository repo;
	
	public List<Festa> listarTodos() {
		return repo.findAll();
	}

	public Festa buscarPorId(Integer id) {
		Optional<Festa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Festa não encontrada."));
	}

	public void delete(Integer id) {
		buscarPorId(id);
		repo.deleteById(id);
	}

	public void update(Festa obj) {
		buscarPorId(obj.getId());
		repo.save(obj);
	}

	public void insert(Festa obj) {
		obj.setId(null);
		repo.save(obj);
	}

}
