package br.com.icorrea.servidorpublico.service;

import java.util.List;
import java.util.Optional;

import br.com.icorrea.servidorpublico.model.ServidorPublico;

public interface IServidorPublicoService {

	
	List<ServidorPublico> listAll();
	
	Optional<ServidorPublico> listByMatricula(long matricula);
}
