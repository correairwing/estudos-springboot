package com.icorrea.servidorpublicobd;

import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.icorrea.servidorpublicobd.entity.ServidorPublico;
import com.icorrea.servidorpublicobd.service.ServidorPublicoService;

import jakarta.annotation.PostConstruct;


@Configuration
public class ServidorPublicoAppRunner implements CommandLineRunner {

	private ServidorPublicoService servidorService;
	
	@Autowired
	public void setServidorPublicoService(ServidorPublicoService servidorService) {
		this.servidorService = servidorService;
	}
	
	@PostConstruct
	public void listAll() {
		List<ServidorPublico> servidorespublicos = servidorService.listAll();
		
		if(servidorespublicos.size() != 0) {
			System.out.println("##################################");
			servidorespublicos.forEach(
					servidor -> {
						System.out.println(servidor.getMatricula());
						System.out.println(servidor.getNome());
						System.out.println(servidor.getFoto());
						System.out.println(servidor.getOrgao());
					}
					);
		} else {
			System.out.println("Tabela sem registros");
		}
	}
	
	@PostConstruct
	public void listByMatricula() {
		long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matrícula procurada"));
		
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if(servidorEncontrado.isPresent()) {
			System.out.println("##################################");
			System.out.println(servidorEncontrado.get().getMatricula());
			System.out.println(servidorEncontrado.get().getNome());
			System.out.println(servidorEncontrado.get().getFoto());
			System.out.println(servidorEncontrado.get().getOrgao());
		} else {
			System.out.println("Servidor não encontrado");
		}
	}
	
	public void save() {
		long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matrícula procurada"));
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if(!servidorEncontrado.isPresent()) {
			ServidorPublico novoServidor = new ServidorPublico();
			novoServidor.setMatricula(matricula);
			String nome = JOptionPane.showInputDialog("Digite o nome do servidor");
			String foto = JOptionPane.showInputDialog("Digite a foto do servidor");
			String orgao = JOptionPane.showInputDialog("Digite o nome do orgão do servidor");
			String vinculo = JOptionPane.showInputDialog("Digite o vinculo do servidor");
			String cargo = JOptionPane.showInputDialog("Digite o cargo do servidor");
			String lotacao = JOptionPane.showInputDialog("Digite a lotação do servidor");
			String exercicio = JOptionPane.showInputDialog("Digite o exercicio do servidor");
			String email = JOptionPane.showInputDialog("Digite o email do servidor");
			String telefone = JOptionPane.showInputDialog("Digite o telefone do servidor");
			String celular = JOptionPane.showInputDialog("Digite o celular do servidor");
			String cpf = JOptionPane.showInputDialog("Digite o cpf do servidor");
			String naturalidade = JOptionPane.showInputDialog("Digite a naturalidade do servidor");
			
			novoServidor.setNome(nome);
			novoServidor.setFoto(foto);
			novoServidor.setOrgao(orgao);
			novoServidor.setVinculo(vinculo);
			novoServidor.setCargo(cargo);
			novoServidor.setLotacao(lotacao);
			novoServidor.setExercicio(exercicio);
			novoServidor.setEmail(email);
			novoServidor.setTelefone(telefone);
			novoServidor.setCelular(celular);
			novoServidor.setCpf(cpf);
			novoServidor.setNaturalidade(naturalidade);
			
			servidorService.save(novoServidor);
			
		} else {
			System.out.println("Servidor já existente.");
		}
	}
	
	public void update() {
		long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matrícula a ser alterada"));
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if(servidorEncontrado.isPresent()) {
			String nome = JOptionPane.showInputDialog("Digite o nome do servidor");
			servidorEncontrado.get().setNome(nome);
			
			servidorService.update(servidorEncontrado.get());
			
			
		} else {
			System.out.println("Servidor não encontrado");
			
		}
			
		
	}
	
	public void delete() {
		long matricula = Long.parseLong(JOptionPane.showInputDialog("Digite a matrícula a ser excluída"));
		Optional<ServidorPublico> servidorEncontrado = servidorService.listByMatricula(matricula);
		
		if(servidorEncontrado.isPresent()) {	
			servidorService.delete(matricula);
			
			
		} else {
			System.out.println("Servidor não encontrado");
			
		}
	}
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

	}

}
