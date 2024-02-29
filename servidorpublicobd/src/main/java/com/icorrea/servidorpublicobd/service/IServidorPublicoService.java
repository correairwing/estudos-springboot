package com.icorrea.servidorpublicobd.service;

import java.util.List;
import java.util.Optional;

import com.icorrea.servidorpublicobd.entity.ServidorPublico;



public interface IServidorPublicoService {

	
	List<ServidorPublico> listAll();
	
	Optional<ServidorPublico> listByMatricula(long matricula);
	
	void save(ServidorPublico servidor);
	
	void update(ServidorPublico servidor);
	
	void delete(long matricula);
}
