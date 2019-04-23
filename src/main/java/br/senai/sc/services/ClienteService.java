package br.senai.sc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.senai.sc.domain.Cliente;
import br.senai.sc.repositories.ClienteRepository;
import br.senai.sc.services.exceptions.ObjetoNaoEncontradoException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> listarTodos() {
		return repo.findAll();
	}

	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjetoNaoEncontradoException("Cliente não encontrado."));
	}

	public void delete(Integer id) {
		buscarPorId(id);
		repo.deleteById(id);
	}

	public void update(Cliente obj) {
		buscarPorId(obj.getId());
		repo.save(obj);
	}

	public void insert(Cliente obj) {
		obj.setId(null);
		repo.save(obj);
	}

}
