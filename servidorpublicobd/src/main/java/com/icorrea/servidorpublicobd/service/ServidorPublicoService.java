package com.icorrea.servidorpublicobd.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icorrea.servidorpublicobd.entity.ServidorPublico;
import com.icorrea.servidorpublicobd.repository.IServidorPublicoRepository;


@Service
public class ServidorPublicoService implements IServidorPublicoService {

	@Autowired
	private IServidorPublicoRepository servidorRepository;
	
	
	@Override
	public List<ServidorPublico> listAll() {
		
		List<ServidorPublico> servidorespublicos = new ArrayList<>();
		servidorRepository.findAll().forEach(servidorespublicos::add);
		return servidorespublicos;
		
	}

	@Override
	public Optional<ServidorPublico> listByMatricula(long matricula) {
		
		return servidorRepository.findById(matricula);
		
	}


	@Override
	public void save(ServidorPublico servidor) {
		servidorRepository.save(servidor);
		
	}


	@Override
	public void update(ServidorPublico servidor) {
		Optional<ServidorPublico> servidorEncontrado = servidorRepository.findById(servidor.getMatricula());
		
		servidorEncontrado.ifPresent(
				p -> servidorRepository.save(servidor)
				);
	}


	@Override
	public void delete(long matricula) {
		Optional<ServidorPublico> servidorEncontrado = servidorRepository.findById(matricula);
		
		servidorEncontrado.ifPresent(
				p -> servidorRepository.delete(servidorEncontrado.get())
				);
		
	}
}
