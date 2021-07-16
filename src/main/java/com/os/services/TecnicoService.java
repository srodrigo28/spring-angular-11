package com.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.os.TecnicoDTO;
import com.os.domain.Tecnico;
import com.os.excetions.ObjetoNotFoundExpcetion;
import com.os.repositories.TecnicoRepository;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository repository;
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjetoNotFoundExpcetion(
				"Registro não encontrado! id: " + id + ", Tipo: " + Tecnico.class.getName()));	
	}
	public List<Tecnico> findAll(){
		return repository.findAll();
	}
	public Tecnico create(TecnicoDTO objDTO) {
		return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
}
