package br.com.icorrea.servidorpublico.service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.icorrea.servidorpublico.model.ServidorPublico;

@Service
public class ServidorPublicoService implements IServidorPublicoService {

	private final String SERVIDOR  = "/data/servidorpublico.json";
	
	@Override
	public List<ServidorPublico> listAll() {
		try {
			TypeReference<List<ServidorPublico>> typeref = new TypeReference<List<ServidorPublico>>(){};
					
			InputStream inputstream = TypeReference.class.getResourceAsStream(SERVIDOR);
			
			List<ServidorPublico> servidorespublicos = new ObjectMapper().readValue(inputstream,typeref);
			
			return servidorespublicos;
		}
		catch(Exception e) {
			System.out.println("Exceção"+ e.getMessage());
			return null;
		}
	}

	@Override
	public Optional<ServidorPublico> listByMatricula(long matricula) {
		
		try {
			TypeReference<List<ServidorPublico>> typeref = new TypeReference<List<ServidorPublico>>(){};
					
			InputStream inputstream = TypeReference.class.getResourceAsStream(SERVIDOR);
			
			List<ServidorPublico> servidorespublicos = new ObjectMapper().readValue(inputstream,typeref);
			
			Optional<ServidorPublico> servidorEncontrado = servidorespublicos.stream().filter(
					servidor -> servidor.matricula().equals(matricula)).findFirst();
			
			return servidorEncontrado;
		}
		catch(Exception e) {
			System.out.println("Exceção"+ e.getMessage());
			return null;
		}
	}
}
